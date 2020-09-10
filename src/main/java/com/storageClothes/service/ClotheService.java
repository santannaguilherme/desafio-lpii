package com.storageClothes.service;

import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.repository.ClothesRepository;

import java.util.List;

public class ClotheService implements Crud<Clothes>  {

    ClothesRepository clothesRepository;
    public ClotheService() {
        this.clothesRepository = new ClothesRepository();
    }

    public void add(Clothes clothe) throws Exception {

        List<Clothes> clothes = this.clothesRepository.listAll();

        for (Clothes auxClothe : clothes) {
            if (auxClothe.getCode() == clothe.getCode()) {
                throw new Exception("Já existe uma roupa com esse id...");
            }
        }

        this.clothesRepository.insert(clothe);
    }

    public void remove(int id) throws Exception {

       this.clothesRepository.deleteById(id);
    }

    public void update(Clothes clothe) throws Exception {
        this.clothesRepository.update(clothe.getCode(), clothe);
    }

    public List<Clothes> getAll() throws Exception {
        return this.clothesRepository.listAll();
    }

    public Clothes getById(int id) throws Exception {
        return this.clothesRepository.getById(id);
    }
}
