package com.animai.animai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.animai.animai.entities.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    
}
