package com.storageClothes.repository;

import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.utils.enuns.ColorEnum;
import com.storageClothes.utils.enuns.SizeEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClothesRepository {
    Connection con = null;

    public List<Clothes> listAll(){
        List<Clothes> list = new ArrayList<Clothes>();
        String sql = "select * from clothes";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                Clothes c = new Clothes();
                c.setCode(result.getInt("code"));
                c.setSize(SizeEnum.valueOf(result.getString("size")));
                c.setColor(ColorEnum.valueOf(result.getString("color")));
                c.setPriceTag(result.getDouble("priceTag"));
                c.setPaidPrice(result.getDouble("paidPrice"));
                c.setSuggestedPrice(result.getDouble("suggestedPrice"));

                BrandRepository b = new BrandRepository();
                c.setBrand(b.getById(result.getInt("brandId")));

                Date date = new Date();
                date.setTime(result.getDate("entryDay").getTime());
                c.setEntryDay(date);

                list.add(c);
            }
            return list;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
    public Clothes getById(int id){
        Clothes c = new Clothes();
        String sql = "select * from clothes where code = " + id;

        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                c.setCode(result.getInt("code"));
                c.setSize(SizeEnum.valueOf(result.getString("size")));
                c.setColor(ColorEnum.valueOf(result.getString("color")));
                c.setPriceTag(result.getDouble("priceTag"));
                c.setPaidPrice(result.getDouble("paidPrice"));
                c.setSuggestedPrice(result.getDouble("suggestedPrice"));

                BrandRepository b = new BrandRepository();
                c.setBrand(b.getById(result.getInt("brandId")));

                Date date = new Date();
                date.setTime(result.getDate("entryDay").getTime());
                c.setEntryDay(date);
            }
            return c;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }

    public void deleteById(int id){
        String sql = "delete from clothes where code = " + id;
        try{
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void update(int id,Clothes clothes){

    }
    public void insert(Clothes clothe){
        String sql = "insert into clothes " +
                "(entryDay,brandId,priceTag,paidPrice,suggestedPrice,color,size)" +
                "values (?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1,clothe.getEntryDay().toString());
            stmt.setString(2,clothe.getBrand().getId().toString());
            stmt.setString(3,String.valueOf(clothe.getPriceTag()));
            stmt.setString(4,String.valueOf(clothe.getPaidPrice()));
            stmt.setString(5,String.valueOf(clothe.getSuggestedPrice()));
            stmt.setString(6,clothe.getColor().getColorName());
            stmt.setString(7,clothe.getSize().getSizeName());

            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
