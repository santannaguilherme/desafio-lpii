package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.Brand;
import com.storageClothes.service.BrandService;
import com.storageClothes.service.Crud;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.List;
import java.util.Scanner;

public class UpdateBrand implements StateConsoleMachine {

    public boolean execute() {
        Scanner scan = new Scanner(System.in);

        try {
            Brand brand = new Brand();
            System.out.println("Por favor insira o id de uma das seguintes marcas que você deseja alterar.");
            this.showBrands();
            brand.setId(scan.nextInt());
            System.out.println("Por favor, digite o novo nome da marca.");
            brand.setName(scan.next());

            Crud brandService = new BrandService();

            brandService.update(brand);
            System.out.println("Marca atualizada com sucesso :)");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao atualizar a marca :(");
        }
        System.out.println("Pressione qualquer tecla para continuar...");
        scan.nextLine();


        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }

    private void showBrands() {
        Crud brandService = new BrandService();

        try {
            List<Brand> brands = brandService.getAll();
            for (Brand brand : brands) {
                System.out.println("Código: " + brand.getId() + " | Nome da marca: " + brand.getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
