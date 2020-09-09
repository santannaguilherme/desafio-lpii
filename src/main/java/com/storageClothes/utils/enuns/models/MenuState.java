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
        int opcao = scan.nextInt();
        switch (opcao)
        {
            case 0:
                Main.stateConsoleMachine = ConsoleStateEnum.WELCOME.getStateConsoleMachine();
                break;
            case 1:
                Main.stateConsoleMachine = ConsoleStateEnum.CADASTER.getStateConsoleMachine();
                break;
        }
        return false;
    }
}