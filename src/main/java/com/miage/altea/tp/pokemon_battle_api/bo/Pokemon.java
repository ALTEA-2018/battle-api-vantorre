package com.miage.altea.tp.pokemon_battle_api.bo;


import lombok.Data;

@Data
public class Pokemon {

    private int id;

    private int pokemonType;

    private PokemonType pokemonTypeObject;

    private int level;

    private Stats currentStates;

    public void setCurrentStates(Stats baseStates, int level) {
        this.currentStates = new Stats();
        this.currentStates.setHp(10 + level + (baseStates.getHp() * level / 50));
        this.currentStates.setAttack(5 + (baseStates.getAttack() * level / 50));
        this.currentStates.setDefense(5 + (baseStates.getDefense() * level / 50));
        this.currentStates.setSpeed(5 + (baseStates.getSpeed() * level / 50));
    }


    public Pokemon() {
    }

    public Pokemon(int pokemonType, int level) {
        this.pokemonType = pokemonType;
        this.level = level;
    }

}