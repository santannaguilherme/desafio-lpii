package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.Brand;
import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.service.BrandService;
import com.storageClothes.service.ClotheService;
import com.storageClothes.service.Crud;
import com.storageClothes.utils.enuns.ColorEnum;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.SizeEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class CadasterClothe implements StateConsoleMachine {

    public boolean execute() {
        Scanner scan = new Scanner(System.in);
        Clothes clothes = new Clothes();

        try {
            System.out.println("Por favor, insira o código da roupa");
            clothes.setCode(scan.nextInt());
            System.out.println("Por favor, insira a data de entrada (dd/mm/aaaa)");
            clothes.setEntryDay(new SimpleDateFormat().parse(scan.next()));
            System.out.println("Por favor, insira o local da compra");
            Crud brandService = new BrandService();
            Crud clotheService = new ClotheService();

            System.out.println("Por favor, insira o código de uma das seguintes marcas...");
            List<Brand> brands = brandService.getAll();
            for (Brand brand : brands) {
                System.out.println("código: " + brand.getId() + " | nome: " + brand.getName());
            }
            Brand selectedBrand = (Brand) brandService.getById(scan.nextInt());
            clothes.setBrand(selectedBrand);

            System.out.println("Por favor, insira o preço pago.");
            clothes.setPaidPrice(scan.nextDouble());

            System.out.println("Por favor, insira o preço de etiqueta.");
            clothes.setPriceTag(scan.nextDouble());

            System.out.println("Por favor, insira o código da cor.");
            System.out.println("Cor: Amarelo | Código: 1");
            System.out.println("Cor: Azul | Código: 2");
            System.out.println("Cor: Vermelho | Código: 3");

            int color = scan.nextInt();

            for (ColorEnum colorEnum : ColorEnum.values()) {
                if (colorEnum.getId() == color) {
                    clothes.setColor(colorEnum);
                }
            }

            if (clothes.getColor() == null) {
                throw new Exception("Cor inválida!");
            }

            System.out.println("Por favor, insira o tamanho.");
            String size = scan.next().toUpperCase();

            clothes.setSize(SizeEnum.valueOf(size.toUpperCase()));
            clotheService.add(clothes);

            System.out.println("Roupa adicionada com sucesso.");

        } catch (Exception e) {
            System.out.println("Ocorreu algum erro!");
            System.out.println(e.getMessage());
        }


        scan.next();

        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }
}
