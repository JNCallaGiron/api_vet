
package com.jairo.api_veterniaria.service;

import com.jairo.api_veterniaria.model.Dueño;
import com.jairo.api_veterniaria.repository.IDuenioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuenioService implements IDuenioService{

    @Autowired
    private IDuenioRepository duenioRepo;
    
    @Override
    public void saveDuenio(Dueño duenio) {
        duenioRepo.save(duenio);
    }

    @Override
    public List<Dueño> getDuenios() {
        List<Dueño> listaDuenios = duenioRepo.findAll();
        return listaDuenios;
    }

    @Override
    public Dueño findDuenio(Long id_duenio) {
       Dueño due = duenioRepo.findById(id_duenio).orElse(null);
        return due;
    }

    @Override
    public void deleteDuenio(Long id_duenio) {
        duenioRepo.deleteById(id_duenio);
    }

    @Override
    public void editDuenio(Dueño duenio) {
        this.saveDuenio(duenio);
    }
    
}
