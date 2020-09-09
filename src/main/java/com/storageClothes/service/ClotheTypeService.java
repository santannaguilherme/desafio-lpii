package com.storageClothes.service;

import com.storageClothes.domain.entities.ClotheType;
import com.storageClothes.repository.ClotheTypeRepository;

import java.util.List;

public class ClotheTypeService implements Crud<ClotheType> {

    private ClotheTypeRepository clotheTypeRepository;
    public ClotheTypeService() {
        this.clotheTypeRepository = new ClotheTypeRepository();
    }
    public void add(ClotheType model) {
        this.clotheTypeRepository.insert(model);
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
