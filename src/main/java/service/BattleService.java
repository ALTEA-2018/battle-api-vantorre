package service;

import bo.Battle;

import java.util.List;

public interface BattleService {
    List<Battle> getAllBattles();

    Battle getBattle(Integer id);

    Integer createBattle(String trainer1, String trainer2);
}
