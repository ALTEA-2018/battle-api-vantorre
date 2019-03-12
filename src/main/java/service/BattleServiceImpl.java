package service;

import bo.Battle;
import bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BattleRepository;

import java.util.List;

@Service
public class BattleServiceImpl implements BattleService {


    @Autowired
    private BattleRepository battleRepository;


    @Override
    public List<Battle> getAllBattles() {
        return battleRepository.getBattles();
    }

    @Override
    public Battle getBattle(Integer id) {
        return battleRepository.getBattle(id);
    }

    @Override
    public Integer createBattle(String trainer1, String trainer2) {
        return battleRepository.create(Battle.builder().trainer1(getTrainer(trainer1)).trainer2(getTrainer(trainer2)).build());
    }

    private Trainer getTrainer(String name){
        //TODO: call service
        return new Trainer();
    }
}
