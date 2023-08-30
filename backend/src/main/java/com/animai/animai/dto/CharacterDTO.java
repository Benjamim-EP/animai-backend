package com.animai.animai.dto;

import java.io.Serializable;

import com.animai.animai.entities.Character;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long character_id;
    private String name;
    private double rating;
    private String seiyuu;
    private String seiyuu_pic;
    private String description;
    private String picurl;

    public CharacterDTO(Long character_id, String name, String picurl) {
        this.character_id = character_id;
        this.name = name;
        this.picurl = picurl;
    }

    public CharacterDTO(Character entity) {
        this.character_id = entity.getCharacter_id();
        this.name = entity.getName();
        this.picurl = entity.getPicurl();
    }
}
