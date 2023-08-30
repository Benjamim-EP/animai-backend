package com.animai.animai.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "names")
@Data
@EqualsAndHashCode(of = "name_id")
public class Name implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name_id")
    private long name_id;

    @Column(name = "anime_id", nullable = false, insertable = false, updatable = false)
    private Long anime_id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "language")
    private String language;

    @ManyToOne
    @JoinColumn(name = "anime_id")
    private Anime anime;
}
