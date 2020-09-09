package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.ClotheType;
import com.storageClothes.service.ClotheTypeService;
import com.storageClothes.service.Crud;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class CadasterClotheType implements StateConsoleMachine {

    public boolean execute() {
        Scanner scan = new Scanner(System.in);
        try {
            ClotheType clotheType = new ClotheType();
            System.out.println("Por favor, insira o código do tipo de roupa.");
            clotheType.setId(scan.nextInt());
            System.out.println("Por favor, insira o nome do tipo de roupa.");
            clotheType.setClotheTypeName(scan.next());

            Crud clotheTypeService = new ClotheTypeService();

            clotheTypeService.add(clotheType);
            System.out.println("Tipo de roupa cadastrado com sucesso :)");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o tipo de roupa :(");
        }
        System.out.println("Pressione qualquer tecla para continuar...");
        scan.nextLine();

        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }
}
