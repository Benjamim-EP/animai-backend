package com.animai.animai.services;

import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import com.animai.animai.entities.Anime;
import com.animai.animai.dto.AnimeDTO;
import com.animai.animai.repositories.AnimeRepository;
import com.animai.animai.tests.Factory;

@SpringBootTest
@AutoConfigureTestDatabase
public class AnimeServiceTest {

    @InjectMocks
    private AnimeService service;

    @Mock
    private AnimeRepository repository;

    private long existingId;
    private long nonExistingId;
    private long dependentId;
    private Anime anime;

    private PageImpl<Anime> page;

    // Configura o ambiente de teste
    @BeforeEach
    void Setup () throws Exception{
        existingId = 1L;
        nonExistingId = 2L;
        anime = Factory.creatAnime();
        page = new PageImpl<>(List.of(anime));

        // Simulando o comportamento dos métodos do repositório
        Mockito.when(repository.findAll((Pageable) any())).thenReturn(page);
        Mockito.when(repository.save(any())).thenReturn(anime);
        Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(anime));
        Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());
        
        Mockito.doNothing().when(repository).deleteById(existingId);
        Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(nonExistingId);
        Mockito.doThrow(DataIntegrityViolationException.class).when(repository).deleteById(dependentId);
    }

     @Test
    public void findAllPagedShouldReturnPage() {
        Pageable pageable = PageRequest.of(0, 12);
        Page<AnimeDTO> result = service.findAllPaged(pageable);
        Assertions.assertNotNull(result);
    }

}
