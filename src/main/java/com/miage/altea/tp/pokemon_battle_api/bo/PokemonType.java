package com.miage.altea.tp.pokemon_battle_api.bo;

import lombok.Data;

import java.util.List;

@Data
public class PokemonType {

    private int id;
    private int baseExperience;
    private int height;
    private String name;
    private Sprites sprites;
    private Stats stats;
    private int weight;
    private List<String> types;

}