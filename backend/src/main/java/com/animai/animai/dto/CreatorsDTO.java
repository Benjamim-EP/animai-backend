package com.animai.animai.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.animai.animai.entities.Creators;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatorsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long creator_id;
    private long anime_id;
    private String name;
    private String type;

    public CreatorsDTO(Creators entity){
        this.creator_id = entity.getCreatorId();
        this.anime_id  = entity.getAnime_id();
        this.name  = entity.getName();
        this.type      = entity.getType();
    }
}
