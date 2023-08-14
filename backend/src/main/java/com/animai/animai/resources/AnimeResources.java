package com.animai.animai.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;

import com.animai.animai.dto.AnimeDTO;
import com.animai.animai.services.AnimeService;

@RestController
@RequestMapping(value = "/animes")
public class AnimeResources {
    
    @Autowired
    private AnimeService service;

    @GetMapping(value = "/all")
    public ResponseEntity<Page<AnimeDTO>> findAll(
            @RequestParam(value = "tagID", defaultValue = "0") Long tagId,
            @RequestParam(value = "tag_name", defaultValue = "") String tag_name,
            Pageable Pageable){

        Page<AnimeDTO> list = service.findAllPaged(tagId,tag_name.trim(), Pageable);  
        return ResponseEntity.ok().body(list); 
    }

    /**
	 * Endpoint para buscar um anime pelo seu ID.
	 * 
	 * @param id O ID do anime a ser buscado.
	 * @return ResponseEntity contendo o ProductDTO correspondente ao ID fornecido.
	 */
	@GetMapping(value = "/{id}")
    public ResponseEntity<AnimeDTO> findById(@PathVariable Long id) {
        AnimeDTO animeDTO = service.findById(id);
        return ResponseEntity.ok().body(animeDTO);
    }
    
}
