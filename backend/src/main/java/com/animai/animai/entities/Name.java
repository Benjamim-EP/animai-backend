package com.animai.animai.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "names")
public class Name implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name_id")
    private long name_id;

    @Column(name = "anime_id", nullable = false,insertable=false,updatable=false)
    private Long anime_id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;
    
    @Column(name = "language")
    private String language;

    @ManyToOne
    @JoinColumn(name = "anime_id")
    private Anime anime;

    public Name(){
        
    }
    public Name(Name entity){
        this.name_id = entity.getName_id();
        this.name = entity.getName();
        this.type = entity.getType();
        this.name = entity.getName();
        this.language = entity.getLanguage();
        
    }

    public long getName_id() {
        return name_id;
    }
    public void setName_id(long name_id) {
        this.name_id = name_id;
    }
    public Long getAnime_id() {
        return anime_id;
    }
    public void setAnime_id(Long anime_id) {
        this.anime_id = anime_id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (name_id ^ (name_id >>> 32)); // Calculate hash code for long
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
        Name other = (Name) obj;
        if (name_id != other.name_id)
            return false;
        return true;
    } 
}