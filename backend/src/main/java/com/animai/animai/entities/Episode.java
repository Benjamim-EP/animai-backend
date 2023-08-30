package com.animai.animai.entities;

import java.io.Serializable;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "episodes")
@Data
public class Episode implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id")
    private long episode_id;

    @Column(name = "anime_id", nullable = false, insertable = false, updatable = false)
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
}
