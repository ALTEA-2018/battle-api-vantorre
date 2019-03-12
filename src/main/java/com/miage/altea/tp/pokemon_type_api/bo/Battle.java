package com.miage.altea.tp.pokemon_type_api.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Battle {

    private Integer uuid;

    private Trainer trainer1;

    private Trainer trainer2;
}
