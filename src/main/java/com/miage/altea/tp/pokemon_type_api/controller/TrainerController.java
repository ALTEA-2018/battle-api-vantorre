package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.Battle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.miage.altea.tp.pokemon_type_api.service.BattleService;

import java.util.List;

@RestController
@RequestMapping("/battles")
public class TrainerController {

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
    Integer createBattle(@PathVariable String trainer1, @PathVariable String trainer2) {
        return this.battleService.createBattle(trainer1, trainer2);
    }


}