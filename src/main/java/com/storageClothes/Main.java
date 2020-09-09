package com.storageClothes;

import com.storageClothes.domain.entities.Brand;
import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.repository.ClothesRepository;
import com.storageClothes.repository.DAO.ConnectionFactory;
import com.storageClothes.utils.enuns.ConsoleStateEnum;
import com.storageClothes.utils.enuns.models.interfaces.StateConsoleMachine;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static StateConsoleMachine stateConsoleMachine;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        stateConsoleMachine = ConsoleStateEnum.MENU.getStateConsoleMachine();
        boolean exit = false;

        while(!exit) {
            exit = stateConsoleMachine.execute();
        }
    }
}
