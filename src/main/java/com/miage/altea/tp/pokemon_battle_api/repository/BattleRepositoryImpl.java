package com.miage.altea.tp.pokemon_battle_api.repository;

import com.miage.altea.tp.pokemon_battle_api.bo.Battle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BattleRepositoryImpl implements BattleRepository {

    private Integer index;

    private Map<Integer, Battle> battles;

    public BattleRepositoryImpl() {
        this.index = 0;
        this.battles = new HashMap<>();
    }

    public Battle getBattle(Integer id) {
        return this.battles.get(id);
    }

    public List<Battle> getBattles() {
        return new ArrayList<>(this.battles.values());
    }

    @Override
    public Integer create(Battle battle) {
        battle.setUuid(index);
        battles.put(index, battle);
        return index++;
    }
}
