package com.storageClothes.repository;

import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.utils.enuns.ColorEnum;
import com.storageClothes.utils.enuns.SizeEnum;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ClothesRepository {
    static final String FILE_NAME = "clothes.txt";

    public List<Clothes> listAll() throws FileNotFoundException, ParseException {
        List<Clothes> list = new ArrayList<Clothes>();

        Scanner s = new Scanner(new File(FILE_NAME));
        while (s.hasNext()) {
           String[] k = s.nextLine().split(";");
            for(int i = 0;i<k.length;i++){
                System.out.println(k[i]);
            }
            Clothes c = new Clothes();
            c.setCode(Integer.valueOf(k[0]));
            c.setSize(SizeEnum.valueOf(k[7]));
            c.setColor(ColorEnum.valueOf(k[6].trim()));
            c.setPriceTag(Double.valueOf(k[3]));
            c.setPaidPrice(Double.valueOf(k[4]));
            c.setSuggestedPrice(Double.valueOf(k[5]));

            BrandRepository b = new BrandRepository();
            //c.setBrand(b.getById(Integer.valueOf(k[2])));
            c.setEntryDay(k[1]);
            list.add(c);
        }

        s.close();
        return list;
    }

    public Clothes getById(int id) throws FileNotFoundException, ParseException {

        List<Clothes> l = listAll();
        Clothes c = null;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getCode() == id) {
                c = l.get(i);
                break;
            }
        }
        return c;

    }

    public void deleteById(int id) throws FileNotFoundException, ParseException {
        List<Clothes> l = listAll();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getCode() == id) {
                l.remove(id);
                break;
            }
        }
        deleteFile();
        for (int i = 0; i < l.size(); i++) {
            insert(l.get(i));
        }


    }

    public void update(int id, Clothes clothes) throws FileNotFoundException, ParseException {
        List<Clothes> l = listAll();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getCode() == id) {
                l.remove(id);
                break;
            }
        }
        l.add(clothes);
        deleteFile();
        for (int i = 0; i < l.size(); i++) {
            insert(l.get(i));
        }

    }

    public void insert(Clothes clothe) {
        String c = clothe.getCode() + ";" +
                clothe.getEntryDay() + ";" +
                clothe.getBrand().getId() + ";" +
                clothe.getPriceTag() + ";" +
                clothe.getPaidPrice() + ";" +
                clothe.getSuggestedPrice() + ";" +
                clothe.getColor() + ";" +
                clothe.getSize().getSizeName() + "\n";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME,true));
            writer.write(c);

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteFile() {
        try {
            File f = new File(FILE_NAME);
            f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
