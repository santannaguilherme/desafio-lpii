package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CadasterClothe implements StateConsoleMachine {

    public boolean execute() {
        Scanner scan = new Scanner(System.in);
        Clothes clothes = new Clothes();

        try {
            System.out.println("Por favor, insira o código da roupa");
            clothes.setCode(scan.nextInt());
            System.out.println("Por favor, insira a data de entrada (dd/mm/aaaa)");
            clothes.setEntryDay(new SimpleDateFormat().parse(scan.next()));
            System.out.println("Por favor, insira o local da compra");

        } catch (Exception e) {

        }





        scan.next();

        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }
}
