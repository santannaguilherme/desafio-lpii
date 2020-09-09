package com.storageClothes.repository;

import com.storageClothes.domain.entities.Brand;
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

public class BrandRepository {
    Connection con = null;

    public List<Brand> listAll(){
        List<Brand> list = new ArrayList<Brand>();
        String sql = "select * from brand";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                Brand b = new Brand();
                b.setId(result.getInt("id"));
                b.setName(result.getString("name"));

                list.add(b);
            }
            return list;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
    public Brand getById(int id){
        Brand b = new Brand();
        String sql = "select * from brand where code = " + id;

        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()){
                b.setId(result.getInt("id"));
                b.setName(result.getString("name"));
            }
            return b;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }

    public void deleteById(int id){
        String sql = "delete from brand where code = " + id;
        try{
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void update(int id,Brand brand){

    }
    public void insert(Brand brand){
        String sql = "insert into brand " +
                "(name)" +
                "values (?)";
        try{
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1,brand.getName());

            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
