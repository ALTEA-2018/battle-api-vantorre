package com.miage.altea.tp.pokemon_type_api.bo;

import lombok.Data;

import java.util.List;


@Data
public class Trainer { 

    private String name; 

    private List<Pokemon> team;

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
    }

    private String password;

}