
package com.jairo.api_veterniaria.service;

import com.jairo.api_veterniaria.dto.DtoMascotaDuenio;
import com.jairo.api_veterniaria.model.Mascota;
import java.util.List;


public interface IMascotaService {
    //guardar mascota
    public void saveMascota(Mascota masco);
    
    //traer lista de mascotas
    public List<Mascota> getMascotas();
    
    //buscar una sola mascota
    public Mascota findMascota(Long id_mascota);
    
    //borrar mascota
    public void deleteMascota(Long id_mascota);
    
    //edit
    public void editMascota(Mascota masco);
    
    //lista de siameses
    public List<Mascota> getSiames();
    
    //lista DTO
    public List<DtoMascotaDuenio> getListaDTO();
    

    
}
