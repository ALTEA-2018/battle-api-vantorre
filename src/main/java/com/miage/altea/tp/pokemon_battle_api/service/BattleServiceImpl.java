package com.miage.altea.tp.pokemon_battle_api.service;

import com.miage.altea.tp.pokemon_battle_api.bo.Battle;
import com.miage.altea.tp.pokemon_battle_api.bo.Pokemon;
import com.miage.altea.tp.pokemon_battle_api.bo.Trainer;
import com.miage.altea.tp.pokemon_battle_api.exceptions.BattleFinishedException;
import com.miage.altea.tp.pokemon_battle_api.exceptions.NotYourTurnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.miage.altea.tp.pokemon_battle_api.repository.BattleRepository;

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


    @Autowired
    private PokemonTypeService pokemonTypeService;


    @Override
    public List<Battle> getAllBattles() {
        return battleRepository.getBattles();
    }

    @Override
    public Battle getBattle(Integer id) {
        return battleRepository.getBattle(id);
    }

    @Override
    public Integer createBattle(String trainer1Name, String trainer2Name) {
        Trainer trainer1= getTrainer(trainer1Name);
        Trainer trainer2= getTrainer(trainer2Name);
        trainer1.getTeam().forEach(pokemon -> pokemon.setCurrentStates(pokemon.getPokemonTypeObject().getStats().toBuilder().build(), pokemon.getLevel()));
        trainer2.getTeam().forEach(pokemon -> pokemon.setCurrentStates(pokemon.getPokemonTypeObject().getStats().toBuilder().build(), pokemon.getLevel()));
        return battleRepository.create(Battle.builder().currentTrainer(1).trainer1(trainer1).trainer2(trainer2).build());
    }

    @Override
    public Battle attack(Integer id, String trainerName) throws NotYourTurnException, BattleFinishedException {
        Battle battle = getBattle(id);
        if(!itIsHisTurn(battle, trainerName)){
            throw new NotYourTurnException("reviens plus tard");
        }

        Pokemon attaquant = getAttaquant(battle);
        Pokemon defenseur = getDefenseur(battle);
        if(attaquant == null || defenseur == null){
            throw new BattleFinishedException("the battle is alreadyFinished");
        }

        doFight(attaquant, defenseur);

        battle.setCurrentTrainer((battle.getCurrentTrainer() == 1) ? 2 : 1);
        return battle;
    }

    private void doFight(Pokemon attaquant, Pokemon defenseur) {
        //TODO: calcul compliqué pour pas grand chose
        defenseur.getCurrentStates().setHp(defenseur.getCurrentStates().getHp() - attaquant.getCurrentStates().getAttack());
    }

    private boolean itIsHisTurn(Battle battle, String trainerName) {
        int current = battle.getCurrentTrainer();
        if(current == 1 && trainerName.equals(battle.getTrainer1().getName())) return true;
        if(current == 2 && trainerName.equals(battle.getTrainer2().getName())) return true;
        return false;
    }

    private Pokemon getAttaquant(Battle battle) {
        Trainer trainer = (battle.getCurrentTrainer() == 1) ? battle.getTrainer1() : battle.getTrainer2();
        return trainer.getTeam().stream().filter(pokemon -> pokemon.getCurrentStates().getHp() > 0).findFirst().orElse(null);
    }

    private Pokemon getDefenseur(Battle battle) {
        Trainer trainer = (battle.getCurrentTrainer() == 1) ? battle.getTrainer2() : battle.getTrainer1();
        return trainer.getTeam().stream().filter(pokemon -> pokemon.getCurrentStates().getHp() > 0).findFirst().orElse(null);
    }

    private Trainer getTrainer(String name){
        Trainer res = this.trainerApiRestTemplate.getForObject(this.trainerServiceUrl + "/trainers/" + name, Trainer.class);
        res.getTeam().forEach(pokemon -> pokemon.setPokemonTypeObject(pokemonTypeService.getPokemonType(pokemon.getPokemonType())));
        return res;
    }
}
