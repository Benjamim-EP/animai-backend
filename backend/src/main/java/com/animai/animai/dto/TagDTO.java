package com.animai.animai.dto;

import java.io.Serializable;

import com.animai.animai.entities.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long tag_id;
    private String tag_name;
    private String picurl;

    public TagDTO(Tag entity) {
        this.tag_id = entity.getTag_id();
        this.tag_name = entity.getTag_name();
        this.picurl = entity.getPicurl();
    }
}
