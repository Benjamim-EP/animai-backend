package com.animai.animai.repositories;

import org.springframework.stereotype.Repository;

import com.animai.animai.entities.Anime;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
 
}
