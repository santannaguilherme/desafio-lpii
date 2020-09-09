package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.service.BrandService;
import com.storageClothes.service.ClotheTypeService;
import com.storageClothes.service.Crud;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class RemoveClotheType implements StateConsoleMachine {

    public boolean execute() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Por favor, insira o id do tipo de roupa que deseja remover.");

            int id = scan.nextInt();

            Crud clotheTypeService = new ClotheTypeService();

            clotheTypeService.remove(id);

            System.out.println("O tipo de roupa foi deletado com sucesso :)");

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao deletar o tipo de roupa :(");
        }

        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }
}
