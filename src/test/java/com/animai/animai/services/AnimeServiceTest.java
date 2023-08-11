package com.animai.animai.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import com.animai.animai.entities.Anime;
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

}
