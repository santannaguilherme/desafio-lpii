package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.Brand;
import com.storageClothes.service.BrandService;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class UpdateBrand implements StateConsoleMachine {

    public boolean execute() {
        Scanner scan = new Scanner(System.in);
        try {
            Brand brand = new Brand();
            System.out.println("Por favor insira o id da marca que você deseja alterar.");
            brand.setId(scan.nextInt());
            System.out.println("Por favor, digite o novo nome da marca.");
            brand.setName(scan.next());

            BrandService brandService = new BrandService();

            brandService.update(brand);
            System.out.println("Marca atualizada com sucesso :)");
            System.out.println("Pressione qualquer tecla para continuar...");

            scan.next();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao atualizar a marca :(");
        }

        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }
}
