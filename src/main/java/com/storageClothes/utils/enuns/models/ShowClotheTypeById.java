package com.storageClothes.utils.enuns.models;

import com.storageClothes.domain.entities.Brand;
import com.storageClothes.domain.entities.ClotheType;
import com.storageClothes.service.BrandService;
import com.storageClothes.service.ClotheTypeService;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.Scanner;

public class ShowClotheTypeById implements StateConsoleMachine {
    Scanner scan = new Scanner(System.in);
    public boolean execute() {
        System.out.println("Digite o código do tipo da roupa: ");
        int id = Integer.valueOf(scan.next());
        ClotheTypeService c = new ClotheTypeService();
        try{
            ClotheType cl = c.getById(id);
            System.out.println(cl.getId() + " "+ cl.getClotheTypeName());
        } catch (Exception e) {
            System.out.println("Código Inválido");
        }

        return false;
    }
}
