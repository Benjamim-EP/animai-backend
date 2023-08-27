package com.animai.animai.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "characters")
public class Character implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private long character_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "picurl")
    private String picurl;

    @Column(name = "gender")
    private String gender;
    
    @Column(name = "rating")
    private double rating;

    @Column(name = "seiyuu")
    private String seiyuu;

    @Column(name = "seiyuu_pic")
    private String seiyuu_pic;

    @Column(name = "description")
    private String description;

    public Character(){
        
    }

    public Character(Character entity){
        this.character_id = entity.getCharacter_id();
        this.name = entity.getName();
        this.picurl = entity.getPicurl();
    }

    public Character(long character_id, String name) {
        this.character_id = character_id;
        this.name = name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (character_id ^ (character_id >>> 32)); // Calculate hash code for long
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Character other = (Character) obj;
        if (character_id != other.character_id)
            return false;
        return true;
    } 

    

}
