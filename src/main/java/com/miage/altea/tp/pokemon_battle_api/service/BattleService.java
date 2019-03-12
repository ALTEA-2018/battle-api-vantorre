package com.miage.altea.tp.pokemon_battle_api.service;

import com.miage.altea.tp.pokemon_battle_api.bo.Battle;
import com.miage.altea.tp.pokemon_battle_api.exceptions.BattleFinishedException;
import com.miage.altea.tp.pokemon_battle_api.exceptions.NotYourTurnException;

import java.util.List;

public interface BattleService {
    List<Battle> getAllBattles();

    Battle getBattle(Integer id);

    Integer createBattle(String trainer1, String trainer2);

    Battle attack(Integer id, String trainerName) throws NotYourTurnException, BattleFinishedException;
}
