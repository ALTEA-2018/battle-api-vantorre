package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.Battle;
import com.miage.altea.tp.pokemon_type_api.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.miage.altea.tp.pokemon_type_api.repository.BattleRepository;

import java.util.List;

@Service
public class BattleServiceImpl implements BattleService {

    private RestTemplate trainerApiRestTemplate;
    private String trainerServiceUrl;

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    public void setRestTemplate(RestTemplate trainerApiRestTemplate) {
        this.trainerApiRestTemplate = trainerApiRestTemplate;
    }

    @Value("${trainer.service.url}")
    public void setTrainerServiceUrl(String trainerServiceUrl) {
        this.trainerServiceUrl = trainerServiceUrl;
    }



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
        return this.trainerApiRestTemplate.getForObject(this.trainerServiceUrl + "/trainers/" + name, Trainer.class);
    }
}
