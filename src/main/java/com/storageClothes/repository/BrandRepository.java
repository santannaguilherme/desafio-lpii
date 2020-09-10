package com.storageClothes.repository;

import com.storageClothes.domain.entities.Brand;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BrandRepository {
    static final String FILE_NAME = "brand.txt";

    public List<Brand> listAll() throws FileNotFoundException, ParseException {
        List<Brand> list = new ArrayList<Brand>();

        Scanner s = new Scanner(new File(FILE_NAME));
        while (s.hasNext()) {
            String[] k = s.nextLine().split(";");
            Brand b = new Brand();
            b.setId(Integer.valueOf(k[0]));
            b.setName(k[1]);
            list.add(b);
        }

        s.close();
        return list;
    }

    public Brand getById(int id) throws FileNotFoundException, ParseException {

        List<Brand> l = listAll();
        Brand b = null;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getId() == id) {
                b = l.get(i);
                break;
            }
        }
        return b;

    }

    public void deleteById(int id) throws FileNotFoundException, ParseException {
        List<Brand> l = listAll();
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

    public void update(int id, Brand brand) throws FileNotFoundException, ParseException {
        List<Brand> l = listAll();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).getId() == id) {
                l.remove(i);
                break;
            }
        }
        l.add(brand);
        deleteFile();
        for (int i = 0; i < l.size(); i++) {
            insert(l.get(i));
        }

    }

    public void insert(Brand brand) {
        String c = brand.getId() + ";" +
                brand.getName() + "\n";

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

