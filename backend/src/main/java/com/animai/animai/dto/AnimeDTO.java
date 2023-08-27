package com.animai.animai.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.animai.animai.entities.Anime;
import com.animai.animai.entities.Character;
import com.animai.animai.entities.Name;
import com.animai.animai.entities.Rating;
import com.animai.animai.entities.Creators;
import com.animai.animai.entities.Episode;
import com.animai.animai.entities.Tag;

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
	private List<EpisodeDTO> episodes      = new ArrayList<>();
	

	// contructors
	public AnimeDTO(){
	}


	public AnimeDTO(long anime_id, String description, String picurl) {
		this.anime_id = anime_id;
		this.description = description;
		this.picurl = picurl;
	}

	public AnimeDTO(Anime entity) {
		this.anime_id = entity.getAnimeId();
		this.description = entity.getDescription();
		this.picurl = entity.getPicurl();
	}

	public AnimeDTO(Anime entity, Set<Tag> tags,Set<Name> names, Set<Rating> ratings, Set<Creators> creators, Set<Character> characters,Set<Episode> episodes){
		this(entity);
		tags.forEach(tag -> this.tags.add(new TagDTO(tag)));
		names.forEach(name -> this.names.add(new NameDTO(name)));
		ratings.forEach(rating -> this.ratings.add(new RatingDTO(rating)));
		creators.forEach(creator -> this.creators.add(new CreatorsDTO(creator)));
		characters.forEach(character -> this.characters.add(new CharacterDTO(character)));
		episodes.forEach(episode -> this.episodes.add(new EpisodeDTO(episode)));
	}
	

	// get and setters
	public long getAnime_id() {
		return anime_id;
	}
	public void setAnime_id(long anime_id) {
		this.anime_id = anime_id;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}

	public String getPicurl() {
		return picurl;
	}
	public void setpicurl(String picurl) {
		this.picurl = picurl;
	}


	public List<TagDTO> getTags() {
		return tags;
	}


	public void setTags(List<TagDTO> tags) {
		this.tags = tags;
	}


	public List<NameDTO> getNames() {
		return names;
	}


	public void setNames(List<NameDTO> names) {
		this.names = names;
	}
	
	public List<RatingDTO> getRatings() {
		return ratings;
	}


	public void setRatings(List<RatingDTO> ratings) {
		this.ratings = ratings;
	}
	
	public List<CreatorsDTO> getCreators() {
		return creators;
	}


	public void setCreators(List<CreatorsDTO> creators) {
		this.creators = creators;
	}


	public List<CharacterDTO> getCharacters() {
		return characters;
	}


	public void setCharacters(List<CharacterDTO> characters) {
		this.characters = characters;
	}


	public List<EpisodeDTO> getEpisodes() {
		return episodes;
	}


	public void setEpisodes(List<EpisodeDTO> episodes) {
		this.episodes = episodes;
	}

}
