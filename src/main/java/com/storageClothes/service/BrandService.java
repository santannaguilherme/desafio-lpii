package com.storageClothes.service;

import com.storageClothes.domain.entities.Brand;
import com.storageClothes.domain.entities.Clothes;
import com.storageClothes.repository.BrandRepository;

import java.util.List;

public class BrandService implements Crud<Brand> {

    BrandRepository brandRepository;
    public BrandService() {
        this.brandRepository = new BrandRepository();
    }

    public void add(Brand brand) throws Exception {
        List<Brand> brands = this.brandRepository.listAll();

        for (Brand auxBrand : brands) {
            if (auxBrand.getId() == brand.getId()) {
                throw new Exception("Já existe uma marca com esse id...");
            }
        }

        this.brandRepository.insert(brand);
    }

    public void remove(int id) throws Exception {
        this.brandRepository.deleteById(id);
    }

    public void update(Brand brand) throws Exception {
        this.brandRepository.update(brand.getId(), brand);
    }

    public List<Brand> getAll() throws Exception {
        return this.brandRepository.listAll();
    }

    public Brand getById(int id) throws Exception {
        return this.brandRepository.getById(id);
    }
}
