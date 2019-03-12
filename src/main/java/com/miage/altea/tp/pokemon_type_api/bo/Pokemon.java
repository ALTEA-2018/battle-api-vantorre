package com.miage.altea.tp.pokemon_type_api.bo;

import lombok.Data;


// TODO
@Data
public class Pokemon {

    private int id; 

    private int pokemonType; 

    private int level; 

    public Pokemon() {
    }

    public Pokemon(int pokemonType, int level) {
        this.pokemonType = pokemonType;
        this.level = level;
    }

}