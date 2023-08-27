package com.animai.animai.dto;

import java.io.Serializable;

import com.animai.animai.entities.Creators;

public class CreatorsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long creator_id;
    private long anime_id;
    private String name;
    private String type;


    public CreatorsDTO(){

    }

    public CreatorsDTO(Creators entity){

        this.creator_id = entity.getCreatorsId();
        this.anime_id  = entity.getAnime_id();
        this.name  = entity.getName();
        this.type      = entity.getType();
    }

    public long getcreators_id() {
        return this.creator_id;
    }

    public void setCreators_id(long creator_id) {
        this.creator_id = creator_id;
    }

    public long getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(long anime_id) {
        this.anime_id = anime_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    

}
