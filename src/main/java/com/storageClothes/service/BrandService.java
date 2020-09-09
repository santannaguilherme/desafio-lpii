package com.storageClothes.service;

import com.storageClothes.domain.entities.Brand;
import com.storageClothes.repository.BrandRepository;

import java.util.List;

public class BrandService implements Crud<Brand> {

    BrandRepository brandRepository;
    public BrandService() {
        this.brandRepository = new BrandRepository();
    }

    public void add(Brand brand) {
        if (brand == null) {
            return;
        }

        this.brandRepository.insert(brand);
    }

    public void remove(int id) {

        this.brandRepository.deleteById(id);
    }

    public void update(Brand brand) {

        this.brandRepository.update(brand.getId(), brand);
    }

    public List<Brand> getAll() {
        return this.brandRepository.listAll();
    }

    public Brand getById(int id) {

        return this.brandRepository.getById(id);
    }
}
