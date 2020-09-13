package no.satyam.spring.northwind.domain;


import java.util.UUID;

import org.springframework.data.annotation.Id;

/**
 *
 * @author srt
 */

public class Category {

    @Id
    private UUID id;
    private String name;
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
