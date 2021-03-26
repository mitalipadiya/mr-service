package com.marketresearch.mits.web.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "verticals")
public class VerticalsDto {
    @Id
    private String id;
    private String name;
    private String category;

    public VerticalsDto(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}