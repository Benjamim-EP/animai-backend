package com.animai.animai.entities;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "ratingId")
@Entity
@Table(name = "rating")
public class Rating implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long ratingId;

    @Column(name = "anime_id", nullable = false, insertable = false, updatable = false)
    private Long animeId;

    @ManyToOne
    @JoinColumn(name = "anime_id", referencedColumnName = "anime_id", insertable = false, updatable = false)
    private Anime anime;

    @Column(name = "counting")
    private Integer counting;

    @Column(name = "note")
    private Double note;
}
