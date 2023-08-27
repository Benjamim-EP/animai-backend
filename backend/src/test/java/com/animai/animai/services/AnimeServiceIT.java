package com.animai.animai.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.animai.animai.dto.AnimeDTO;
import com.animai.animai.repositories.AnimeRepository;

@SpringBootTest
public class AnimeServiceIT {

    // O serviço a ser testado
    @Autowired
    private AnimeService service;
    
    // O repositório usado para verificação e limpeza
    @Autowired
    private AnimeRepository repository;
    
    // Dados de exemplo para testes
    private Long existingId;         // Um ID de produto existente no banco de dados
    private Long nonExistingId;      // Um ID de produto que não existe no banco de dados
    private Long countTotalProducts; // Número total de produtos no banco de dados
    
    // Configurando os dados de teste
    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        countTotalProducts = 532L;
    }
    
    @Test
    public void findAllPagedShouldReturnPageWhenPage0Size10() {
        
        // Preparação: Configurar a solicitação de paginação (página 0, tamanho 10)
        PageRequest pageRequest = PageRequest.of(0, 10);
        
        // Ação: Obter a primeira página de produtos
        Page<AnimeDTO> result = service.findAllPaged(pageRequest);
        
        // Verificação: Verificar que a página retornada não está vazia, tem o número e tamanho corretos e contém todos os produtos
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(0, result.getNumber());
        Assertions.assertEquals(10, result.getSize());
        Assertions.assertEquals(countTotalProducts, result.getTotalElements());
    }
}
