package com.miage.altea.tp.pokemon_battle_api.bo;


import lombok.Data;

@Data
public class Pokemon {

    private int id;

    private int pokemonType;

    private PokemonType pokemonTypeObject;

    private int level;

    private Stats currentStates;

    public Pokemon() {
    }

    public Pokemon(int pokemonType, int level) {
        this.pokemonType = pokemonType;
        this.level = level;
    }

}