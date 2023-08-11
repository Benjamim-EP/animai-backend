package com.animai.animai.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.animai.animai.repositories.AnimeRepository;
import com.animai.animai.repositories.TagRepository;
import com.animai.animai.dto.AnimeDTO;
import com.animai.animai.entities.Anime;
import com.animai.animai.entities.Tag;
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
		Anime entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		return new AnimeDTO(entity, entity.getTags());
	}
}
