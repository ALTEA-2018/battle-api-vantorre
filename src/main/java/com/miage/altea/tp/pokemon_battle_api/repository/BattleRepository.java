package com.miage.altea.tp.pokemon_battle_api.repository;

import com.miage.altea.tp.pokemon_battle_api.bo.Battle;

import java.util.List;

public interface BattleRepository {

    Battle getBattle(Integer id);

    List<Battle> getBattles();

    Integer create(Battle battle);
}
