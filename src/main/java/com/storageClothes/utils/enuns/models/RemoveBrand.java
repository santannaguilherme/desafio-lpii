package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.service.BrandService;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class RemoveBrand implements StateConsoleMachine {

    public boolean execute() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Por favor, insira o id da marca que vocÊ deseja remover.");

            int id = scan.nextInt();

            BrandService brandService = new BrandService();

            brandService.remove(id);

            System.out.println("A roupa foi deletada com sucesso :)");
            System.out.println("Pressione qualquer tecla para continuar...");

            scan.next();

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao deletar a marca :(");
            System.out.println("Pressione qualquer tecla para continuar...");
        }

        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }
}
