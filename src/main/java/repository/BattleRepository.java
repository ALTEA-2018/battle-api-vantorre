package repository;

import bo.Battle;

import java.util.List;

public interface BattleRepository {

    Battle getBattle(Integer id);

    List<Battle> getBattles();

    Integer create(Battle battle);
}
