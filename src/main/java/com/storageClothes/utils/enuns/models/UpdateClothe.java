package com.storageClothes.utils.enuns.models;

import com.storageClothes.Main;
import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.service.ClotheService;
import com.storageClothes.utils.enuns.ColorEnum;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.SizeEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.util.List;
import java.util.Scanner;

public class UpdateClothe implements StateConsoleMachine {

    public boolean execute() {
        ClotheService clotheService = new ClotheService();
        Scanner scan = new Scanner(System.in);
        Clothes clothe = new Clothes();

        try {
            System.out.println("Selecione o id de uma das seguintes roupas que você deseja alterar.");
            this.showClothes();
            clothe.setCode(scan.nextInt());

            System.out.println("Por favor, insira o novo código da cor.");
            System.out.println("Cor: Amarelo | Código: 1");
            System.out.println("Cor: Azul | Código: 2");
            System.out.println("Cor: Vermelho | Código: 3");

            int color = scan.nextInt();

            for (ColorEnum colorEnum : ColorEnum.values()) {
                if (colorEnum.getId() == color) {
                    clothe.setColor(colorEnum);
                }
            }

            System.out.println("Por favor, insira o novo tamanho.");
            String size = scan.next().toUpperCase();

            clothe.setSize(SizeEnum.valueOf(size.toUpperCase()));

            System.out.println("Por favor, insira o novo preço pago da roupa.");
            clothe.setPaidPrice(scan.nextDouble());
            System.out.println("Por favor, insira o novo preço de etiqueta da roupa.");
            clothe.setPriceTag(scan.nextDouble());
            System.out.println("Por favor, insira o novo dia de entrada da roupa.");
            clothe.setEntryDay(scan.next());

            clotheService.update(clothe);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Pressione qualquer tecla para continuar...");
        scan.nextLine();
        Main.stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();

        return false;
    }

    private void showClothes() {
        ClotheService clotheService = new ClotheService();

        try {
            List<Clothes> clothes = clotheService.getAll();
            for (Clothes clothe : clothes) {
                System.out.println("Código: " + clothe.getCode() + " | Cor: " + clothe.getColor() +
                        " | Data de entrada: " + clothe.getEntryDay() + " | Preço pago: " + clothe.getPaidPrice() +
                        " | Preço de etiqueta: " + clothe.getPriceTag());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
