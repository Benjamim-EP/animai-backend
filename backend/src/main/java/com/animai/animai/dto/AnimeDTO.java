package com.animai.animai.dto;

import java.io.Serializable;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

import com.animai.animai.entities.Anime;
import com.animai.animai.entities.Tag;

public class AnimeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
    

	private long anime_id;
	private String title;
	private Integer year;
	private Integer episodeCount;

	private List<TagDTO> tags = new ArrayList<>();

	// contructors
	public AnimeDTO(){
	}

	public AnimeDTO(Anime entity, Set<Tag> tags) {
		this(entity);
		tags.forEach(tag -> this.tags.add(new TagDTO(tag)));
	}

	public AnimeDTO(long anime_id, String title, Integer year, Integer episodeCount) {
		this.anime_id = anime_id;
		this.title = title;
		this.year = year;
		this.episodeCount = episodeCount;
	}

	public AnimeDTO(Anime entity) {
		this.anime_id = entity.getAnimeId();
		this.title = entity.getTitle();
		this.year = entity.getYear();
		this.episodeCount = entity.getEpisodeCount();
	}


	// get and setters
	public long getAnime_id() {
		return anime_id;
	}
	public void setAnime_id(long anime_id) {
		this.anime_id = anime_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getEpisodeCount() {
		return episodeCount;
	}
	public void setEpisodeCount(Integer episodeCount) {
		this.episodeCount = episodeCount;
	}

	public List<TagDTO> getCategories() {
		return tags;
	}

	public void setCategories(List<TagDTO> tags) {
		this.tags = tags;
	}

}
