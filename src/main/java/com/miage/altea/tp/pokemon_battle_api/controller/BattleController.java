package com.miage.altea.tp.pokemon_battle_api.controller;

import com.miage.altea.tp.pokemon_battle_api.bo.Battle;
import com.miage.altea.tp.pokemon_battle_api.exceptions.BattleFinishedException;
import com.miage.altea.tp.pokemon_battle_api.exceptions.NotYourTurnException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.miage.altea.tp.pokemon_battle_api.service.BattleService;

import java.util.List;

@RestController
@RequestMapping("/battles")
public class BattleController {

    @Autowired
    private BattleService battleService;


    @GetMapping(value = "/")
    List<Battle> getAllBattles() {
        return this.battleService.getAllBattles();
    }

    @GetMapping(value = "/{id}")
    Battle getBattle(@PathVariable Integer id) {
        return this.battleService.getBattle(id);
    }

    @PostMapping(value = "/{trainer1}/{trainer2}")
    Battle createBattle(@PathVariable String trainer1, @PathVariable String trainer2) {
        return this.battleService.createBattle(trainer1, trainer2);
    }

    @PostMapping(value = "/{id}/{trainer}/attack")
    Battle attack(@PathVariable Integer id, @PathVariable String trainer) throws NotYourTurnException, BattleFinishedException {
        return this.battleService.attack(id, trainer);
    }


}