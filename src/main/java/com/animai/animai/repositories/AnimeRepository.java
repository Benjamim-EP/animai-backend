package com.animai.animai.repositories;

import org.springframework.stereotype.Repository;

import com.animai.animai.entities.Anime;
import com.animai.animai.entities.Tag;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

    @Query("SELECT DISTINCT obj FROM Anime obj INNER JOIN obj.tags cats WHERE "
            + "(COALESCE(:tags) IS NULL OR cats IN :tags) AND "
            + "(LOWER(obj.title) LIKE LOWER(CONCAT('%',:title,'%'))) ")
    Page<Anime> find(List<Tag> tags, String title, Pageable pageable);

    @Query("SELECT obj FROM Anime obj JOIN FETCH obj.tags WHERE obj IN :animes")
    List<Anime> findAnimesWithTags(List<Anime> animes);

}
