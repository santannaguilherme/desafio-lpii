package com.storageClothes;

import com.storageClothes.domain.entities.Brand;
import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.repository.ClothesRepository;
import com.storageClothes.repository.DAO.ConnectionFactory;
import com.storageClothes.utils.enuns.ColorEnum;
import com.storageClothes.utils.enuns.SizeEnum;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        Clothes c = new Clothes();
        c.setCode(1);
        c.setEntryDay("2020-10-10");
        c.setBrand(new Brand());
        c.setPaidPrice(1.11);
        c.setSuggestedPrice(1.12);
        c.setPriceTag(1.13);
        c.setSize(SizeEnum.G);
        c.setColor(ColorEnum.RED);

        ClothesRepository cr = new ClothesRepository();
        //cr.insert(c);
        //Clothes cl = cr.getById(1);
        cr.update(1,c);


    }
}
