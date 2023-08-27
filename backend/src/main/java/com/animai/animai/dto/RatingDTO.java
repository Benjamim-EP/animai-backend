package com.animai.animai.dto;

import java.io.Serializable;

import com.animai.animai.entities.Rating;

public class RatingDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long rating_id;
    private long anime_id;
    private int counting;
    private double note;


    public RatingDTO(){

    }

    public RatingDTO(Rating entity){
        this.rating_id = entity.getRatingId();
        this.anime_id  = entity.getAnime_id();
        this.counting  = entity.getCounting();
        this.note      = entity.getNote();
    }

    public long getRating_id() {
        return rating_id;
    }

    public void setRating_id(long rating_id) {
        this.rating_id = rating_id;
    }

    public long getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(long anime_id) {
        this.anime_id = anime_id;
    }

    public int getCounting() {
        return counting;
    }

    public void setCounting(int counting) {
        this.counting = counting;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    

}
