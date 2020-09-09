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
        while (s.hasNext()){
            String[] k = s.next().split("|");
            Clothes c = new Clothes();
            c.setCode(Integer.valueOf(k[0]));
            c.setSize(SizeEnum.valueOf(k[7]));
            c.setColor(ColorEnum.valueOf(k[8]));
            c.setPriceTag(Double.valueOf(k[3]));
            c.setPaidPrice(Double.valueOf(k[4]));
            c.setSuggestedPrice(Double.valueOf(k[5]));

            BrandRepository b = new BrandRepository();
            c.setBrand(b.getById(Integer.valueOf(k[2])));

            Date date = new SimpleDateFormat("yyyy/MM/dd").parse(k[1]);
            c.setEntryDay(date);
            list.add(c);
        }

        s.close();
        return list;
    }
    public Clothes getById(int id){

        Clothes c = new Clothes();
        String sql = "select * from clothes where code = " + id;

            return c;


    }

    public void deleteById(int id){
        String sql = "delete from clothes where code = " + id;

    }

    public void update(int id,Clothes clothes){

    }
    public void insert(Clothes clothe){
        String c = clothe.getCode()+"|"+
                clothe.getEntryDay().toString()+"|"+
                clothe.getBrand().getId()+"|"+
                clothe.getPriceTag()+"|"+
                clothe.getPaidPrice()+"|"+
                clothe.getSuggestedPrice()+"|"+
                clothe.getColor().getColorName()+"|"+
                clothe.getSize().getSizeName()+"\n";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(c);

            writer.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
