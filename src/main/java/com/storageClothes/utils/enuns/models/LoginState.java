package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.User;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class LoginState implements StateConsoleMachine {

    public boolean execute() {
        User user = new User();
        Scanner scan = new Scanner(System.in);
        System.out.println("**** LOGIN ****");
        System.out.println("Digite seu usuário");
        user.setUsername(scan.nextLine());
        System.out.println("Digite sua senha");
        user.setPassword(scan.nextLine());


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