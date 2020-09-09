package com.storageClothes;

import com.storageClothes.repository.DAO.ConnectionFactory;
import com.storageClothes.utils.enuns.ColorEnum;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.SizeEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {


    public static StateConsoleMachine stateConsoleMachine;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();
        boolean exit = false;

        System.out.println(SizeEnum.valueOf("M"));


        while(!exit) {
            exit = stateConsoleMachine.execute();
        }
    }
}
