package com.animai.animai.dto;

import java.io.Serializable;

import com.animai.animai.entities.Tag;

public class TagDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long tag_id;
    private String tag_name;
    private String picurl;

    public TagDTO(){

    }

    public TagDTO(Long tag_id, String tag_name,String picurl) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
        this.picurl = picurl;
    }

    public TagDTO(Tag entity){
        this.tag_id = entity.getTag_id();
        this.tag_name = entity.getTag_name();
        this.picurl = entity.getPicurl();
    }

    public long getTag_id() {
        return tag_id;
    }
    public void setTag_id(long tag_id) {
        this.tag_id = tag_id;
    }
    public String getTag_name() {
        return tag_name;
    }
    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    

}
