package com.animai.animai.entities;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "animes")
public class Anime implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_id")
    private Long animeId;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "year")
    private Integer year;
    
    @Column(name = "episode_count")
    private Integer episodeCount;

    @ManyToMany
	@JoinTable(name = "animetags",
		joinColumns = @JoinColumn(name = "anime_id"),
		inverseJoinColumns = @JoinColumn(name = "tag_id"))	
	Set<Tag> tags = new HashSet<>();

    public Anime(){
        
    }
    
    public Anime(Long animeId, String title, Integer year, Integer episodeCount) {
        this.animeId = animeId;
        this.title = title;
        this.year = year;
        this.episodeCount = episodeCount;
    }
   
    public Long getAnimeId() {
        return animeId;
    }
    public void setAnimeId(Long animeId) {
        this.animeId = animeId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Integer getEpisodeCount() {
        return episodeCount;
    }
    public void setEpisodeCount(Integer episodeCount) {
        this.episodeCount = episodeCount;
    }

    public Set<Tag> getTags() {
		return tags;
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
