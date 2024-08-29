
package com.jairo.api_veterniaria.service;

import com.jairo.api_veterniaria.model.Dueño;
import java.util.List;


public interface IDuenioService {
    
    //guardar 
    public void saveDuenio (Dueño duenio);
    
    //traer un listado de dueños
    public List<Dueño> getDuenios();
    
    //traer un solo dueño
    public Dueño findDuenio(Long id_duenio);
    
    //borrar dueño
    public void deleteDuenio(Long id_duenio);
    
    //editar duenio
    public void editDuenio (Dueño duenio);
    
}
