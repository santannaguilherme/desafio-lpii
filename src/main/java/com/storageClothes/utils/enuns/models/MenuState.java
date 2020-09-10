package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class MenuState implements StateConsoleMachine {

    public boolean execute() {
        System.out.println("*** Menu Principal");
        Scanner scan = new Scanner(System.in);
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Remover");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Visualizar");
        int option = scan.nextInt();
        switch (option)
        {
            case 0:
                return true;
            case 1:
                Main.stateConsoleMachine = ConsoleStateEnum.CADASTER.getStateConsoleMachine();
                break;
            case 2:
                Main.stateConsoleMachine = ConsoleStateEnum.REMOVE.getStateConsoleMachine();
                break;
            case 3:
                Main.stateConsoleMachine = ConsoleStateEnum.UPDATE.getStateConsoleMachine();
                break;
            case 4:
                Main.stateConsoleMachine = ConsoleStateEnum.SHOW.getStateConsoleMachine();
                break;

            case 5:
                Main.stateConsoleMachine = ConsoleStateEnum.SHOW_BY_ID.getStateConsoleMachine();
                break;
        }
        return false;
    }
}