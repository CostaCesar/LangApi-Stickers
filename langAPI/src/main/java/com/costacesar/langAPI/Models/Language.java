package com.costacesar.langAPI.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mainLangs")
public class Language
{
    @Id
    private String id;
    private String title;
    private String image_url;
    private int ranking;
    
    public String getId()
    { return id; }
    public String getTitle()
    { return title; }
    public String getImage_url()
    { return image_url; }
    public int getRanking()
    { return ranking; }
    
    public Language() { }
    public Language(String title, String image_url, int ranking)
    {
        this.title = title;
        this.image_url = image_url;
        this.ranking = ranking;
    }
}
