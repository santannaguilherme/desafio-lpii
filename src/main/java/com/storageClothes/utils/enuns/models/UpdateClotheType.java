package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.Brand;
import com.storageClothes.domain.entities.ClotheType;
import com.storageClothes.service.BrandService;
import com.storageClothes.service.ClotheTypeService;
import com.storageClothes.service.Crud;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class UpdateClotheType implements StateConsoleMachine {

    public boolean execute() {

        Scanner scan = new Scanner(System.in);
        try {
            ClotheType clotheType = new ClotheType();
            System.out.println("Por favor insira o id do tipo de roupa que você deseja alterar.");
            clotheType.setId(scan.nextInt());
            System.out.println("Por favor, digite o novo nome do tipo de roupa.");
            clotheType.setClotheTypeName(scan.next());

            Crud clotheTypeService = new ClotheTypeService();

            clotheTypeService.update(clotheType);
            System.out.println("Tipo de roupa atualizado com sucesso :)");
            System.out.println("Pressione qualquer tecla para continuar...");

            scan.next();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao atualizar o tipo de roupa :(");
        }

        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }
}
