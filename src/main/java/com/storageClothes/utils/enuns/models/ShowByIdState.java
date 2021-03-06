package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class ShowByIdState implements StateConsoleMachine {

    public boolean execute() {
        System.out.println("O que deseja exibir ?");
        System.out.println("0 - roupas");
        System.out.println("1 - marcas");
        System.out.println("2 - tipo de roupa");

        Scanner scan = new Scanner(System.in);

        int option = scan.nextInt();
        switch (option)
        {
            case 0:
                Main.stateConsoleMachine = ConsoleStateEnum.SHOW_CLOTHES_BY_ID.getStateConsoleMachine();
                break;
            case 1:
                Main.stateConsoleMachine = ConsoleStateEnum.SHOW_BRAND_BY_ID.getStateConsoleMachine();
                break;
            case 2:
                Main.stateConsoleMachine = ConsoleStateEnum.SHOW_CLOTHE_TYPE_BY_ID.getStateConsoleMachine();
                break;
        }

        return false;
    }


}
