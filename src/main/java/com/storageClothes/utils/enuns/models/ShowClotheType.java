package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.ClotheType;
import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.service.ClotheService;
import com.storageClothes.service.ClotheTypeService;
import com.storageClothes.service.Crud;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.List;
import java.util.Scanner;

public class ShowClotheType implements StateConsoleMachine {

    public boolean execute() {
        Scanner scan = new Scanner(System.in);
        try {
            Crud clotheTypeService = new ClotheTypeService();
            List<ClotheType> clotheTypes = clotheTypeService.getAll();

            for (ClotheType clotheType : clotheTypes) {
                System.out.println("Código: " + clotheType.getId() + " | Nome: " + clotheType.getClotheTypeName());
            }

            System.out.println("Pressione qualquer tecla para continuar...");
            scan.next();
        } catch(Exception e) {
            System.out.println("Ocorreu algum erro :(");
        }
        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }

}
