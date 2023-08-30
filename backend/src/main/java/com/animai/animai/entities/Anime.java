package com.animai.animai.entities;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "animeId")
@Entity
@Table(name = "animes")
public class Anime implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_id")
    private Long animeId;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "picurl")
    private String picUrl;

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Name> names = new HashSet<>();

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Episode> episodes = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "animetags",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    Set<Tag> tags = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "animecharacters",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    Set<Character> characters = new HashSet<>();

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rating> ratings = new HashSet<>();

    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Creators> creators = new HashSet<>();

    

    public Anime(Long animeId, String description, String picUrl) {
        this.animeId = animeId;
        this.description = description;
        this.picUrl = picUrl;
    }
}
