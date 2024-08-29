package com.jairo.api_veterniaria.service;

import com.jairo.api_veterniaria.dto.DtoMascotaDuenio;
import com.jairo.api_veterniaria.model.Mascota;
import com.jairo.api_veterniaria.repository.IMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private IMascotaRepository mascoRepo;

    @Override
    public void saveMascota(Mascota masco) {
        mascoRepo.save(masco);
    }

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = mascoRepo.findAll();
        return listaMascotas;
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        Mascota masco = mascoRepo.findById(id_mascota).orElse(null);
        return masco;
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        mascoRepo.deleteById(id_mascota);
    }

    @Override
    public void editMascota(Mascota masco) {
        this.saveMascota(masco);
    }

    @Override
    public List<Mascota> getSiames() {
        List<Mascota> listaMascota = this.getMascotas();
        List<Mascota> listaSiames = new ArrayList<Mascota>();

        for (Mascota masco : listaMascota) {
            if (masco.getEspecie().equalsIgnoreCase("gato")
                    && masco.getRaza().equalsIgnoreCase("siames")) {
                listaSiames.add(masco);
            }
        }
        return listaSiames;
    }

    @Override
    public List<DtoMascotaDuenio> getListaDTO() {
        List<Mascota> listaMascotas = this.getMascotas();
        List<DtoMascotaDuenio> listaDTO = new ArrayList<DtoMascotaDuenio>();
        DtoMascotaDuenio masco_duenio  = new DtoMascotaDuenio();
        
        for (Mascota masco:listaMascotas ){
            System.out.println(masco.getNombre());
            masco_duenio.setNombre_duenio(masco.getDuenio().getNombre());
            masco_duenio.setNombre_mascota(masco.getNombre());
            masco_duenio.setApellido_duenio(masco.getDuenio().getApellido());
            masco_duenio.setEspecie(masco.getEspecie());
            masco_duenio.setRaza(masco.getRaza());
            
            listaDTO.add(masco_duenio);
            masco_duenio = new DtoMascotaDuenio();   
        }
        return listaDTO;
    } 

}
