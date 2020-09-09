package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.Brand;
import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.service.BrandService;
import com.storageClothes.service.ClotheService;
import com.storageClothes.service.Crud;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ShowClothes implements StateConsoleMachine {

    public boolean execute() {
        Scanner scan = new Scanner(System.in);
        try {
            Crud clotheService = new ClotheService();
            List<Clothes> clothes = clotheService.getAll();

            for (Clothes clothe : clothes) {
                System.out.println("Código: " + clothe.getCode() + " | Cor: " + clothe.getColor() +
                        " | Data de entrada: " + clothe.getEntryDay() + " | Preço pago: " + clothe.getPaidPrice() +
                        " | Preço de etiqueta: " + clothe.getPriceTag());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Não existem roupas cadastradas...");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ocorreu algum erro :(");
        }
        System.out.println("Pressione qualquer tecla para continuar...");
        scan.nextLine();

        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }

}
