package com.storageClothes.service;

import com.storageClothes.domain.entities.Brand;
import com.storageClothes.domain.entities.ClotheType;
import com.storageClothes.repository.ClotheTypeRepository;

import java.util.List;

public class ClotheTypeService implements Crud<ClotheType> {

    private ClotheTypeRepository clotheTypeRepository;
    public ClotheTypeService() {
        this.clotheTypeRepository = new ClotheTypeRepository();
    }
    public void add(ClotheType clotheType) throws Exception {
        List<ClotheType> clotheTypes = this.clotheTypeRepository.listAll();

        for (ClotheType auxClotheType : clotheTypes) {
            if (auxClotheType.getId() == clotheType.getId()) {
                throw new Exception("Já existe um tipo de roupa com esse id...");
            }
        }
        this.clotheTypeRepository.insert(clotheType);
    }

    public void remove(int id) throws Exception {
        this.clotheTypeRepository.deleteById(id);
    }

    public void update(ClotheType model) throws Exception {
        this.clotheTypeRepository.update(model.getId(), model);
    }

    public List<ClotheType> getAll() throws Exception {
        return this.clotheTypeRepository.listAll();
    }

    public ClotheType getById(int id) throws Exception {
        return this.clotheTypeRepository.getById(id);
    }
}
