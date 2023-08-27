package com.animai.animai.tests;


import com.animai.animai.dto.AnimeDTO;
import com.animai.animai.entities.Anime;

public class Factory {
	
	public static Anime creatAnime() {
		Anime anime = new Anime(17L, "","221428.jpg");
		return anime;		
	}
	
	public static AnimeDTO createAnimeDTO() {
		Anime anime = creatAnime();
		return new AnimeDTO(anime);
	}
}
