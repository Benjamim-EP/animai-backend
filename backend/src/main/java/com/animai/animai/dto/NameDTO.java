package com.animai.animai.dto;

import java.io.Serializable;

import com.animai.animai.entities.Name;

public class NameDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long name_id;
    private long anime_id;
    private String language;
    private String type;

    private String name;
    

    public NameDTO(){

    }

    public NameDTO(Name entity){
        this.name_id = entity.getName_id();
        this.anime_id = entity.getAnime_id();
        this.name = entity.getName();
        this.language = entity.getLanguage();
        this.type = entity.getType();
    }

    public long getName_id() {
        return name_id;
    }
    public void setName_id(long name_id) {
        this.name_id = name_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getAnime_id(){
        return anime_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    

}
