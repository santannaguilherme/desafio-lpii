package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class CadasterState implements StateConsoleMachine {

    public boolean execute() {
        String intialMessage = "Por favor, insira ";
        Clothes clothe = new Clothes();
        Scanner scan = new Scanner(System.in);
        // System.out.println(intialMessage + "a data (dd/MM/yyyy)");
        // TODO: Fazer lógica de exibir todas as marcas para o usuário visualizar e escolher uma
        // Chamar a classe DAO de marcas e exibir os dados para o usuário selecionar a marca
        /*
        TODO: Fazer lógica da marca
        System.out.println(intialMessage + "a marca");
        Brand brand = getBrand(scan.nextInt());
        clothe.setBrand(brand); */
        System.out.println(intialMessage + "o valor de etiqueta");
        clothe.setPriceTag(scan.nextDouble());
        System.out.println(intialMessage + "o valor sugerido");
        clothe.setSuggestedPrice(scan.nextDouble());

        // TODO: Exibir feedback de produto cadastrado após chamar o service que cadastra a roupa no Banco
        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }
}