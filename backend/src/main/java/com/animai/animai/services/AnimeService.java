package com.animai.animai.services;

import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import com.animai.animai.repositories.AnimeRepository;
import com.animai.animai.dto.AnimeDTO;
import com.animai.animai.entities.Anime;
import com.animai.animai.services.exceptions.*;

@Service
public class AnimeService {

    private final AnimeRepository repository;

    public AnimeService(AnimeRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<AnimeDTO> findAllPaged(Pageable pageable) {
        Page<Anime> page = repository.findAll(pageable);
        return page.map(AnimeDTO::new);
    }

    @Transactional(readOnly = true)
    public AnimeDTO findById(Long id) {
        Anime entity = findAnimeById(id);
        return new AnimeDTO(entity,entity.getTags(),entity.getNames(),entity.getRatings(),entity.getCreators(),entity.getCharacters(), entity.getEpisodes());
    }

    @Transactional
    public AnimeDTO insert(AnimeDTO dto) {
        Anime entity = new Anime();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new AnimeDTO(entity);
    }

    @Transactional
    public AnimeDTO update(Long id, AnimeDTO dto) {
        Anime entity = findAnimeById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new AnimeDTO(entity);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Anime not found with ID: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Database integrity violation while deleting anime.");
        }
    }

    private Anime findAnimeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Anime not found with ID: " + id));
    }

    private void copyDtoToEntity(AnimeDTO dto, Anime entity) {
        entity.setDescription(dto.getDescription());
        entity.setPicUrl(dto.getPicurl());
    }
}
