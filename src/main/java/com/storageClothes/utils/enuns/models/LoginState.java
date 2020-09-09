package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class LoginState implements StateConsoleMachine {

    public boolean execute() {



        // Acesso acesso = new Acesso();
        // boolean senhaValida = acesso.validaUsuario(user);
        /* if (senhaValida)
            CRUD.estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
        else {
            System.out.println("Dados inválidos!");
        } */
        // TODO: Implementar lógica de login
        if (true) {
            Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();
        }
        return false;
    }
}