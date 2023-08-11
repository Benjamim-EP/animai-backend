package com.animai.animai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.animai.animai.entities.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
