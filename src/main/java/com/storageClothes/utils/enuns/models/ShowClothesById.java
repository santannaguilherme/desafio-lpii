package com.storageClothes.utils.enuns.models;

import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.service.ClotheService;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class ShowClothesById implements StateConsoleMachine {
    Scanner scan = new Scanner(System.in);
    public boolean execute() {
        System.out.println("Digite o código da roupa: ");
        int id = Integer.valueOf(scan.next());
        ClotheService c = new ClotheService();
        try{
            Clothes cl = c.getById(id);
            System.out.println(cl.getCode() + " "+ cl.getPaidPrice());
        } catch (Exception e) {
            System.out.println("Código Inválido");
        }

        return false;
    }
}
