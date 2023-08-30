package com.animai.animai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.animai.animai.entities.Anime;
import com.animai.animai.entities.Tag;
import com.animai.animai.entities.Name;
import com.animai.animai.entities.Rating;
import com.animai.animai.entities.Creators;
import com.animai.animai.entities.Character;
import com.animai.animai.entities.Episode;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long anime_id;
    private String description;
    private String picurl;

    private List<TagDTO> tags = new ArrayList<>();
    private List<NameDTO> names = new ArrayList<>();
    private List<RatingDTO> ratings = new ArrayList<>();
    private List<CreatorsDTO> creators = new ArrayList<>();
    private List<CharacterDTO> characters = new ArrayList<>();
    private List<EpisodeDTO> episodes = new ArrayList<>();

    public AnimeDTO(Anime entity) {
        this.anime_id = entity.getAnimeId();
        this.description = entity.getDescription();
        this.picurl = entity.getPicUrl();
    }

    public AnimeDTO(Anime entity, Set<Tag> tags, Set<Name> names, Set<Rating> ratings, Set<Creators> creators, Set<Character> characters, Set<Episode> episodes) {
        this(entity);
        tags.forEach(tag -> this.tags.add(new TagDTO(tag)));
        names.forEach(name -> this.names.add(new NameDTO(name)));
        ratings.forEach(rating -> this.ratings.add(new RatingDTO(rating)));
        creators.forEach(creator -> this.creators.add(new CreatorsDTO(creator)));
        characters.forEach(character -> this.characters.add(new CharacterDTO(character)));
        episodes.forEach(episode -> this.episodes.add(new EpisodeDTO(episode)));
    }
}
