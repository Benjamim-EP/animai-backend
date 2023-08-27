package com.animai.animai.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import com.animai.animai.dto.AnimeDTO;
import com.animai.animai.services.AnimeService;

@RestController
@RequestMapping(value = "/animes")
public class AnimeResources {
    
    @Autowired
    private AnimeService service;

    // http://localhost:8080/animes/all?page=n
    @GetMapping(value = "/all")
    public ResponseEntity<Page<AnimeDTO>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        Page<AnimeDTO> list = service.findAllPaged(pageable);
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
