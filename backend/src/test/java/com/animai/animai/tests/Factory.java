package com.animai.animai.tests;


import com.animai.animai.dto.AnimeDTO;
import com.animai.animai.entities.Tag;
import com.animai.animai.entities.Anime;

public class Factory {
	
	public static Anime creatAnime() {
		Anime anime = new Anime(1L, "One Piece 2",  1999,  1000);
		anime.getTags().add(new Tag(1L, "hentai"));
		return anime;		
	}
	
	public static AnimeDTO createAnimeDTO() {
		Anime anime = creatAnime();
		return new AnimeDTO(anime, anime.getTags());
	}
}
