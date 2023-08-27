package com.animai.animai.dto;

import java.io.Serializable;

import com.animai.animai.entities.Character;

public class CharacterDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long character_id;
    private String name;
    private double rating;
    private String seiyuu;
    private String seiyuu_pic;
    private String description;
    private String picurl;


    public CharacterDTO(){

    }

    public CharacterDTO(Long character_id, String name,String picurl) {
        this.character_id = character_id;
        this.name = name;
        this.picurl = picurl;
    }

    public CharacterDTO(Character entity){
        this.character_id = entity.getCharacter_id();
        this.name = entity.getName();
        this.picurl = entity.getPicurl();
    }

    public long getCharacter_id() {
        return character_id;
    }
    public void setCharacter_id(long character_id) {
        this.character_id = character_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSeiyuu() {
        return seiyuu;
    }

    public void setSeiyuu(String seiyuu) {
        this.seiyuu = seiyuu;
    }

    public String getSeiyuu_pic() {
        return seiyuu_pic;
    }

    public void setSeiyuu_pic(String seiyuu_pic) {
        this.seiyuu_pic = seiyuu_pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

}
