package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.service.ClotheService;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class RemoveClothe implements StateConsoleMachine {

    public boolean execute() {

        try {
            Scanner scan = new Scanner(System.in);
            ClotheService clotheService = new ClotheService();

            System.out.println("Por favor, insira o código da roupa que você gostaria de deletar.");
            int id = scan.nextInt();

            clotheService.remove(id);

            System.out.println("A roupa foi deletada com sucesoo :)");
            System.out.println("Pressione qualquer tecla para continuar...");

            scan.next();

        } catch(Exception e) {
            System.out.println("Ocorreu um erro ao deletar a roupa :(");
            System.out.println("Pressione qualquer tecla para continuar...");
        }
        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }
}
