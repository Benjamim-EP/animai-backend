package com.animai.animai.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.animai.animai.repositories.AnimeRepository;
import com.animai.animai.repositories.TagRepository;
import com.animai.animai.dto.AnimeDTO;
import com.animai.animai.dto.TagDTO;
import com.animai.animai.entities.Anime;
import com.animai.animai.entities.Tag;
import com.animai.animai.services.exceptions.DatabaseException;
import com.animai.animai.services.exceptions.ResourceNotFoundException;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository repository;

	@Autowired
	private TagRepository tagRepository;

	@Transactional(readOnly = true)
	public Page<AnimeDTO> findAllPaged(Long tagId, String name, Pageable pageable) {
		List<Tag> tags = (tagId == 0) ? null : Arrays.asList(tagRepository.getOne(tagId));
		Page<Anime> page = repository.find(tags, name, pageable);
		repository.findAnimesWithTags(page.getContent());
		return page.map(x -> new AnimeDTO(x, x.getTags()));
	}


    @Transactional(readOnly = true)
	public AnimeDTO findById(Long id) {
		Optional<Anime> obj = repository.findById(id);
		Anime entity = obj.orElseThrow(() -> new ResourceNotFoundException("Anime não encontrado"));
		return new AnimeDTO(entity, entity.getTags());
	}

	@Transactional
	public AnimeDTO insert(AnimeDTO dto) {
		Anime entity = new Anime();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AnimeDTO(entity);
	}

	/**
	 * Atualiza um anime existente no catálogo.
	 *
	 * @param id O ID do anime a ser atualizado.
	 * @param dto O AnimeDTO contendo os dados atualizados para o anime.
	 * @return A representação AnimeDTO do anime atualizado.
	 * @throws ResourceNotFoundException Se o anime com o ID fornecido não for encontrado.
	 */
	@Transactional
	public AnimeDTO update(Long id, AnimeDTO dto) {
		try {
			Anime entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new AnimeDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("ID não encontrado " + id);
		}		
	}

	

	/**
	 * Exclui um anime do catálogo pelo seu ID.
	 *
	 * @param id O ID do anime a ser excluído.
	 * @throws ResourceNotFoundException Se o anime com o ID fornecido não for encontrado.
	 * @throws DatabaseException Se houver uma violação de integridade do banco de dados ao tentar excluir o anime.
	 */
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("ID não encontrado " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade");
		}
	}

	/**
	 * Copia os dados do AnimeDTO para a entidade Anime.
	 *
	 * @param dto O AnimeDTO contendo os dados a serem copiados.
	 * @param entity A entidade Anime para onde os dados devem ser copiados.
	 */
	private void copyDtoToEntity(AnimeDTO dto, Anime entity) {

		entity.setTitle(dto.getTitle());
		entity.setYear(dto.getYear());
		entity.setEpisodeCount(dto.getEpisodeCount());

		entity.getTags().clear();
		for (TagDTO tagDto : dto.getTags()) {
			Tag tag = tagRepository.getOne(tagDto.getTag_id());
			entity.getTags().add(tag);			
		}
	}	
}
