package com.animai.animai.dto;

import lombok.Data;
import com.animai.animai.entities.Name;

@Data
public class NameDTO {
    private Long name_id;
    private long anime_id;
    private String language;
    private String type;
    private String name;

    public NameDTO() {
    }

    public NameDTO(Name entity) {
        this.name_id = entity.getName_id();
        this.anime_id = entity.getAnime_id();
        this.name = entity.getName();
        this.language = entity.getLanguage();
        this.type = entity.getType();
    }
}
