package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.Brand;
import com.storageClothes.service.BrandService;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ShowBrands implements StateConsoleMachine {

    public boolean execute() {
        Scanner scan = new Scanner(System.in);
        try {
            BrandService brandService = new BrandService();
            List<Brand> brands = brandService.getAll();

            for (Brand brand : brands) {
                System.out.println("Código: " + brand.getId() + " | Nome: " + brand.getName());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não existem marcas cadastradas...");
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
