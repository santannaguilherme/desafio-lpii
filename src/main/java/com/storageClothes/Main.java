package com.storageClothes;

import com.storageClothes.repository.DAO.ConnectionFactory;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {


    public static StateConsoleMachine stateConsoleMachine;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        if (false) {
            Connection con = new ConnectionFactory().getConnection();
            System.out.println("Show");
            con.close();
        }


        stateConsoleMachine = ConsoleStateEnum.WELCOME.getStateConsoleMachine();
        boolean exit = false;

        while(!exit) {
            exit = stateConsoleMachine.execute();
        }
    }
}
