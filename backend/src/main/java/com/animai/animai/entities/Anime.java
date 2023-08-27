package com.animai.animai.entities;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "animes")
public class Anime implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_id")
    private Long animeId;
    
    @Column(name = "description", nullable = false)
    private String description;
       
    @Column(name = "picurl")
    private String picUrl;

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Name> names = new HashSet<>();

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Episode> episodes = new HashSet<>();

    @ManyToMany
	@JoinTable(name = "animetags",
		joinColumns = @JoinColumn(name = "anime_id"),
		inverseJoinColumns = @JoinColumn(name = "tag_id"))	
	Set<Tag> tags = new HashSet<>();

    @ManyToMany
	@JoinTable(name = "animecharacters",
		joinColumns = @JoinColumn(name = "anime_id"),
		inverseJoinColumns = @JoinColumn(name = "character_id"))	
	Set<Character> characters = new HashSet<>();

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rating> ratings = new HashSet<>();

    
    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Creators> creators = new HashSet<>();



    public Anime(){
        
    }
    
    public Anime(Long animeId, String description, String picUrl) {
        this.animeId = animeId;
        this.description = description;
        this.picUrl = picUrl;
    }
   
    public Long getAnimeId() {
        return animeId;
    }
    public void setAnimeId(Long animeId) {
        this.animeId = animeId;
    }
    public String getDescription() {
        return description;
    }
    public void setdescription(String description) {
        this.description = description;
    }

    public String getPicurl() {
        return picUrl;
    }
    public void setPicurl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public Set<Name> getNames() {
        return names;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }
    
    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public Set<Creators> getCreators() {
        return creators;
    }
    
    public void setCreators(Set<Creators> creators) {
        this.creators = creators;
    }

    

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((animeId == null) ? 0 : animeId.hashCode());
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
        Anime other = (Anime) obj;
        if (animeId == null) {
            if (other.animeId != null)
                return false;
        } else if (!animeId.equals(other.animeId))
            return false;
        return true;
    }

    


}
