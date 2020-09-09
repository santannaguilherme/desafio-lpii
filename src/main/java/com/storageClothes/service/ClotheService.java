package com.storageClothes.service;

import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.repository.ClothesRepository;

import java.util.List;

public class ClotheService implements Crud<Clothes>  {

    ClothesRepository clothesRepository;
    public ClotheService() {
        this.clothesRepository = new ClothesRepository();
    }

    public void add(Clothes clothe) {
        if (clothe == null) {
            return;
        }

        this.clothesRepository.insert(clothe);
    }

    public void remove(int id) {

       this.clothesRepository.deleteById(id);
    }

    public void update(Clothes clothe) {
        this.clothesRepository.update(clothe.getCode(), clothe);
    }

    public List<Clothes> getAll() {
        return this.clothesRepository.listAll();
    }

    public Clothes getById(int id) {
        return this.clothesRepository.getById(id);
    }
}
