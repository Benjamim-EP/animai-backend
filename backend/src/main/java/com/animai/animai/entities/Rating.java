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
@Table(name = "rating")
public class Rating implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long ratingId;

    @Column(name = "anime_id", nullable = false,insertable=false,updatable=false)
    private Long anime_id;

    @ManyToOne
    @JoinColumn(name = "anime_id", referencedColumnName = "anime_id", insertable = false, updatable = false)
    private Anime anime;

    @Column(name = "counting")
    private Integer counting;

    @Column(name = "note")
    private Double note;

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Long getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(long anime) {
        this.anime_id = anime;
    }

    public Integer getCounting() {
        return counting;
    }

    public void setCounting(Integer counting) {
        this.counting = counting;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ratingId == null) ? 0 : ratingId.hashCode());
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
        Rating other = (Rating) obj;
        if (ratingId == null) {
            if (other.ratingId != null)
                return false;
        } else if (!ratingId.equals(other.ratingId))
            return false;
        return true;
    }

}