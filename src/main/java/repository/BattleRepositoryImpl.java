package repository;

import bo.Battle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
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
