package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.Brand;
import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.service.BrandService;
import com.storageClothes.service.ClotheService;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class CadasterBrand implements StateConsoleMachine {

    public boolean execute() {
        try {
            String intialMessage = "Por favor, insira ";
            Brand brand = new Brand();
            Scanner scan = new Scanner(System.in);

            System.out.println(intialMessage + "o código da marca");
            brand.setId(scan.nextInt());

            System.out.println(intialMessage + "o nome da marca");
            brand.setName(scan.next());

            BrandService brandService = new BrandService();
            brandService.add(brand);

            System.out.println("Produto cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o produto!");
        }

        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }
}
