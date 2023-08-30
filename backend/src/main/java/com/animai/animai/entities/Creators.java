package com.animai.animai.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "creators")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Creators implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "creator_id")
    @EqualsAndHashCode.Include
    private Long creatorId;

    @Column(name = "anime_id", nullable = false, insertable = false, updatable = false)
    private Long anime_id;

    @ManyToOne
    @JoinColumn(name = "anime_id", referencedColumnName = "anime_id", insertable = false, updatable = false)
    private Anime anime;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;
}
