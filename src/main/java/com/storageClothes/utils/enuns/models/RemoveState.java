package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class RemoveState implements StateConsoleMachine {

    public boolean execute() {

        System.out.println("O que deseja remover ?");
        System.out.println("0 - roupas");
        System.out.println("1 - marcas");
        System.out.println("2 - tipo de roupa");

        Scanner scan = new Scanner(System.in);

        int option = scan.nextInt();
        switch (option)
        {
            case 0:
                Main.stateConsoleMachine = ConsoleStateEnum.REMOVE_CLOTHE.getStateConsoleMachine();
                break;
            case 1:
                Main.stateConsoleMachine = ConsoleStateEnum.REMOVE_BRAND.getStateConsoleMachine();
                break;
            case 2:
                Main.stateConsoleMachine = ConsoleStateEnum.REMOVE_CLOTHE_TYPE.getStateConsoleMachine();
                break;
        }

        return false;
    }
}
