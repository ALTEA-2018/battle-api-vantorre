package com.miage.altea.tp.pokemon_battle_api.bo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trainer { 

    private String name; 

    private List<Pokemon> team;


    public Trainer(String name) {
        this.name = name;
    }

    private String password;

    private Boolean nextTurn;

}