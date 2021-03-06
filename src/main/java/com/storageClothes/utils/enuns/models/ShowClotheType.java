package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.ClotheType;
import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.service.ClotheService;
import com.storageClothes.service.ClotheTypeService;
import com.storageClothes.service.Crud;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ShowClotheType implements StateConsoleMachine {

    public boolean execute() {
        Scanner scan = new Scanner(System.in);
        try {
            Crud clotheTypeService = new ClotheTypeService();
            List<ClotheType> clotheTypes = clotheTypeService.getAll();

            for (ClotheType clotheType : clotheTypes) {
                System.out.println("Código: " + clotheType.getId() + " | Nome: " + clotheType.getClotheTypeName());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Não existem tipos de roupa cadastrados...");
        }
        catch(Exception e) {
            System.out.println("Ocorreu algum erro :(");
        }

        System.out.println("Pressione qualquer tecla para continuar...");
        scan.nextLine();
        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }

}
