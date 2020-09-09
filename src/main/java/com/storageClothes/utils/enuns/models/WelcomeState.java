package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class WelcomeState implements StateConsoleMachine {

    public boolean execute() {
        boolean exit = false;
        System.out.println("Bem-vindo!");
        System.out.println("Indique a opção desejada!");
        System.out.println("0 - Sair");
        System.out.println("1 - Login");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch (option)
        {
            case 0:
                exit = true;
                break;
            case 1:
                Main.stateConsoleMachine = ConsoleStateEnum.LOGIN.getStateConsoleMachine();
                break;
        }
        return exit;
    }

}
