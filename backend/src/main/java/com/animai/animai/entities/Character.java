package com.animai.animai.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "characters")
@Data
@EqualsAndHashCode(of = "character_id")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private long character_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "picurl")
    private String picurl;

    @Column(name = "gender")
    private String gender;

    @Column(name = "rating")
    private double rating;

    @Column(name = "seiyuu")
    private String seiyuu;

    @Column(name = "seiyuu_pic")
    private String seiyuu_pic;

    @Column(name = "description")
    private String description;
}
