package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.service.ClotheService;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class CadasterState implements StateConsoleMachine {

    public boolean execute() {
        System.out.println("O que deseja cadastrar ?");
        System.out.println("0 - roupas");
        System.out.println("1 - marcas");
        System.out.println("2 - tipo de roupa");

        Scanner scan = new Scanner(System.in);

        int option = scan.nextInt();
        switch (option)
        {
            case 0:
                Main.stateConsoleMachine = ConsoleStateEnum.CADASTER_CLOTHE.getStateConsoleMachine();
                break;
            case 1:
                Main.stateConsoleMachine = ConsoleStateEnum.CADASTER_BRAND.getStateConsoleMachine();
                break;
            case 2:
                Main.stateConsoleMachine = ConsoleStateEnum.CADASTER_CLOTHE_TYPE.getStateConsoleMachine();
                break;
        }

        return false;
    }
}