package com.miage.altea.tp.pokemon_battle_api.bo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Stats {

    private Integer speed;
    private Integer defense;
    private Integer attack;
    private Integer hp;


}