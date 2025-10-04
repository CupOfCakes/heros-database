package com.example.heros_database;

import com.example.heros_database.model.Char;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class helper {
    public List<Char> loadCharacters(){
        ObjectMapper mapper = new ObjectMapper();
        List<Char> characters = new ArrayList<>();
        try {
            JsonNode root = mapper.readTree(new File("src/main/resources/jsons/characters.json"));

            JsonNode monstrosNode = root.get("monstros");
            JsonNode heroisNode = root.get("herois");
            JsonNode viloesNode = root.get("viloes");

            List<Char> monstros = mapper.convertValue(monstrosNode, new TypeReference<List<Char>>() {});
            List<Char> herois = mapper.convertValue(heroisNode, new TypeReference<List<Char>>() {});
            List<Char> viloes = mapper.convertValue(viloesNode, new TypeReference<List<Char>>() {});

            characters = new ArrayList<>();
            characters.addAll(monstros);
            characters.addAll(herois);
            characters.addAll(viloes);

            return characters;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
