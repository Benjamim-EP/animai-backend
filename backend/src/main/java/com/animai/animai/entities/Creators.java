package com.animai.animai.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "creators")
public class Creators implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "anime_id", nullable = false,insertable=false,updatable=false)
    private Long anime_id;

    @ManyToOne
    @JoinColumn(name = "anime_id", referencedColumnName = "anime_id", insertable = false, updatable = false)
    private Anime anime;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    public Creators(){
        
    }

    public Creators(Creators entity){
        this.creatorId = entity.getCreatorsId();
        this.name = entity.getName();
        this.type = entity.getType();
        this.name = entity.getName();
    }

    public Long getCreatorsId() {
        return creatorId;
    }

    public void setCreatorsId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(long anime) {
        this.anime_id = anime;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((creatorId == null) ? 0 : creatorId.hashCode());
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
        Creators other = (Creators) obj;
        if (creatorId == null) {
            if (other.creatorId != null)
                return false;
        } else if (!creatorId.equals(other.creatorId))
            return false;
        return true;
    }

}