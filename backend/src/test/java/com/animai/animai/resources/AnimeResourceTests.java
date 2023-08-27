package com.animai.animai.resources;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.animai.animai.dto.AnimeDTO;
import com.animai.animai.services.AnimeService;
import com.animai.animai.services.exceptions.DatabaseException;
//import com.animai.animai.services.exceptions.DatabaseException;
import com.animai.animai.services.exceptions.ResourceNotFoundException;
import com.animai.animai.tests.Factory;
//import com.animai.animai.tests.TokenUtil;
@SpringBootTest
@AutoConfigureMockMvc
public class AnimeResourceTests {
    
    @Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AnimeService service;

    private Long existingId;
	private Long nonExistingId;
	private Long dependentId;
	private AnimeDTO animeDTO;
	private PageImpl<AnimeDTO> page;

    @BeforeEach
    void setUp() throws Exception {
        // IDs de Animes para teste
		existingId = 17L;
		nonExistingId = 17434L;
		dependentId = 3L;
		
		// Criação de um AnimeDTO de teste
		animeDTO = Factory.createAnimeDTO();
        // Criação de uma Page de AnimeDTO contendo o anime de teste
		page = new PageImpl<>(List.of(animeDTO));

        // Define o comportamento do mock AnimeService
		when(service.findAllPaged(any())).thenReturn(page);
		when(service.findById(existingId)).thenReturn(animeDTO);
		when(service.findById(nonExistingId)).thenThrow(ResourceNotFoundException.class);
		when(service.insert(any())).thenReturn(animeDTO);
		when(service.update(eq(existingId), any())).thenReturn(animeDTO);
		when(service.update(eq(nonExistingId), any())).thenThrow(ResourceNotFoundException.class);
		doNothing().when(service).delete(existingId);
		doThrow(ResourceNotFoundException.class).when(service).delete(nonExistingId);
		doThrow(DatabaseException.class).when(service).delete(dependentId);
    }

    @Test
	public void findByIdShouldReturnAnimeWhenIdExists() throws Exception {
		ResultActions result = 
				mockMvc.perform(get("/animes/{id}", existingId)
					.accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.anime_id").exists());
		result.andExpect(jsonPath("$.description").exists());
		result.andExpect(jsonPath("$.picurl").exists());
	
    }
}
