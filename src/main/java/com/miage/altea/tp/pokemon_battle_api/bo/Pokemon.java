package com.miage.altea.tp.pokemon_battle_api.bo;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
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


    @JsonProperty("alive")
    public boolean alive(){
        return currentStates.getHp() >= 0;
    }

    @JsonProperty("ko")
    public boolean ko(){
        return !alive();
    }

}