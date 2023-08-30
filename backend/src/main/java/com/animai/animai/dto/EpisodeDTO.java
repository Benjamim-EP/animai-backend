package com.animai.animai.dto;

import java.io.Serializable;
import com.animai.animai.entities.Episode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public EpisodeDTO(Episode entity) {
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
}
