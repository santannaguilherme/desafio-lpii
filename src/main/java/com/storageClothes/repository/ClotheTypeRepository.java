package com.storageClothes.repository;

import com.storageClothes.domain.entities.Brand;
import com.storageClothes.domain.entities.ClotheType;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClotheTypeRepository {
    static final String FILE_NAME = "clothe_type.txt";

    public List<ClotheType> listAll() throws FileNotFoundException, ParseException {
        List<ClotheType> list = new ArrayList<ClotheType>();

        Scanner s = new Scanner(new File(FILE_NAME));
        while (s.hasNext()) {
            String[] k = s.nextLine().split(";");
            ClotheType c = new ClotheType();
            c.setId(Integer.valueOf(k[0]));
            c.setClotheTypeName(k[1]);
            list.add(c);
        }

        s.close();
        return list;
    }

    public ClotheType getById(int id) throws FileNotFoundException, ParseException {

        List<ClotheType> l = listAll();
        ClotheType c = null;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getId() == id) {
                c = l.get(i);
                break;
            }
        }
        return c;

    }

    public void deleteById(int id) throws FileNotFoundException, ParseException {
        List<ClotheType> l = listAll();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getId() == id) {
                l.remove(i);
                break;
            }
        }
        deleteFile();
        for (int i = 0; i < l.size(); i++) {
            insert(l.get(i));
        }


    }

    public void update(int id, ClotheType clotheType) throws FileNotFoundException, ParseException {
        List<ClotheType> l = listAll();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getId() == id) {
                l.remove(i);
                break;
            }
        }
        l.add(clotheType);
        deleteFile();
        for (int i = 0; i < l.size(); i++) {
            insert(l.get(i));
        }
    }

    public void insert(ClotheType clotheType) {
        String c = clotheType.getId() + ";" +
                clotheType.getClotheTypeName() + "\n";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
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

