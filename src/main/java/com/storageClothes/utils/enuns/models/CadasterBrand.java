package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.Brand;
import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.service.BrandService;
import com.storageClothes.service.ClotheService;
import com.storageClothes.service.Crud;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class CadasterBrand implements StateConsoleMachine {

    public boolean execute() {
        Scanner scan = new Scanner(System.in);

        try {
            String intialMessage = "Por favor, insira ";
            Brand brand = new Brand();

            System.out.println(intialMessage + "o código da marca");
            brand.setId(scan.nextInt());

            System.out.println(intialMessage + "o nome da marca");
            brand.setName(scan.next());

            Crud brandService = new BrandService();
            brandService.add(brand);

            System.out.println("Produto cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o produto!");
        }

        System.out.println("Pressione qualquer tecla para continuar...");
        scan.nextLine();
        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }
}
