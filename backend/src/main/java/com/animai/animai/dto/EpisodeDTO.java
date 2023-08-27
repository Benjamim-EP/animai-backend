package com.animai.animai.dto;

import java.io.Serializable;

import com.animai.animai.entities.Episode;

public class EpisodeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long episode_id;
    private Long anime_id;

    private String title_x_jat;
    private String title_ja;  
    private String title_en;

    private double rating;
    private String summary;
    private int length;
    private String epno;

    private String airdate;
    

    public EpisodeDTO(){

    }

    public EpisodeDTO(Episode entity){
        this.episode_id = entity.getEpisode_id();
        this.anime_id = entity.getAnime_id();
        this.title_x_jat = entity.getTitle_x_jat();
        this.title_en = entity.getTitle_en();
        this.title_ja = entity.getTitle_ja();

        this.rating = entity.getRating();
        this.summary = entity.getSummary();
        this.length  = entity.getLength();
        this.epno   = entity.getEpno(); 
        
        this.airdate = entity.getAirdate();
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

    public String getAirdate() {
        return airdate;
    }

    public void setAirdate(String airdate) {
        this.airdate = airdate;
    }

   
    

}
