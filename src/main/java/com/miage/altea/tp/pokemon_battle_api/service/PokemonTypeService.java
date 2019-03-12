package com.miage.altea.tp.pokemon_battle_api.service;

import com.miage.altea.tp.pokemon_battle_api.bo.PokemonType;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public interface PokemonTypeService {

    List<PokemonType> listPokemonsTypes();

    PokemonType getPokemonType(int id);

    void setRestTemplate(RestTemplate restTemplate);
}