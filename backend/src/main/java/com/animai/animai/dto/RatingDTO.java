package com.animai.animai.dto;

import lombok.Data;
import com.animai.animai.entities.Rating;

@Data
public class RatingDTO {
    private long rating_id;
    private long anime_id;
    private int counting;
    private double note;

    public RatingDTO() {}

    public RatingDTO(Rating entity) {
        this.rating_id = entity.getRatingId();
        this.anime_id = entity.getAnime_id();
        this.counting = entity.getCounting();
        this.note = entity.getNote();
    }
}
