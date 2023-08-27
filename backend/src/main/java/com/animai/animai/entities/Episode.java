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
@Table(name = "episodes")
public class Episode implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id")
    private long episode_id;

    @Column(name = "anime_id", nullable = false,insertable=false,updatable=false)
    private Long anime_id;

    @Column(name = "title_x_jat")
    private String title_x_jat;

    @Column(name = "title_ja")
    private String title_ja;
    
    @Column(name = "title_en")
    private String title_en;

    @Column(name = "rating")
    private double rating;

    @Column(name = "summary")
    private String summary;

    @Column(name = "length")
    private int length;

    @Column(name = "epno")
    private String epno;

    @Column(name = "airdate")
    private String airdate;

    @ManyToOne
    @JoinColumn(name = "anime_id")
    private Anime anime;

    public Episode(){

    }

    public Episode(Episode entity){
        this.episode_id = entity.getEpisode_id();

        this.title_en = entity.getTitle_en();
        this.title_ja = entity.getTitle_ja();
        this.title_x_jat  = entity.getTitle_x_jat();

        this.rating = entity.getRating();
        this.length = entity.getLength();
        this.epno   = entity.getEpno();
    }


    public long getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(long episode_id) {
        this.episode_id = episode_id;
    }

    public Long getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(Long anime_id) {
        this.anime_id = anime_id;
    }

    public String getTitle_x_jat() {
        return title_x_jat;
    }

    public void setTitle_x_jat(String title_x_jat) {
        this.title_x_jat = title_x_jat;
    }

    public String getTitle_ja() {
        return title_ja;
    }

    public void setTitle_ja(String title_ja) {
        this.title_ja = title_ja;
    }

    public String getTitle_en() {
        return title_en;
    }

    public void setTitle_en(String title_en) {
        this.title_en = title_en;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getEpno() {
        return epno;
    }

    public void setEpno(String epno) {
        this.epno = epno;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }
    
    public String getAirdate() {
        return airdate;
    }

    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (episode_id ^ (episode_id >>> 32));
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
        Episode other = (Episode) obj;
        if (episode_id != other.episode_id)
            return false;
        return true;
    }


    
    
}