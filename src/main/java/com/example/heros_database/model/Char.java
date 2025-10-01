package com.example.heros_database.model;

import java.util.Arrays;

public class Char {
    public int id;
    public String name;
    public String image;
    public String description;
    public String[] tags;
    public String lastUpdate;


    private String neutralize;
    private String threatLevel;
    private String observationLevel;

    // Construtor vazio necessário para JSON
    public Char() {}

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String[] getTags() { return tags; }
    public void setTags(String[] tags) { this.tags = tags; }

    public String getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(String lastUpdate) { this.lastUpdate = lastUpdate; }

    public String getNeutralize() { return neutralize; }
    public void setNeutralize(String neutralize) { this.neutralize = neutralize; }

    public String getThreatLevel() { return threatLevel; }
    public void setThreatLevel(String threatLevel) { this.threatLevel = threatLevel; }

    public String getObservationLevel() { return observationLevel; }
    public void setObservationLevel(String observationLevel) { this.observationLevel = observationLevel; }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }

}
