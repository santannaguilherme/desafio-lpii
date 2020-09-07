package com.storageClothes;

import com.storageClothes.repository.DAO.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = new ConnectionFactory().getConnection();
        System.out.println("Show");
        con.close();
    }
}
