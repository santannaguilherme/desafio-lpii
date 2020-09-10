package com.storageClothes.utils.enuns.models;

import com.storageClothes.domain.entities.Brand;
import com.storageClothes.service.BrandService;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class ShowBrandById implements StateConsoleMachine {
    Scanner scan = new Scanner(System.in);
    public boolean execute() {
        System.out.println("Digite o código da marca: ");
        int id = Integer.valueOf(scan.next());
        BrandService c = new BrandService();
        try{
            Brand cl = c.getById(id);
            System.out.println(cl.getId() + " "+ cl.getName());
        } catch (Exception e) {
            System.out.println("Código Inválido");
        }

        return false;
    }
}
