
package com.jairo.api_veterniaria.controller;

import com.jairo.api_veterniaria.dto.DtoMascotaDuenio;
import com.jairo.api_veterniaria.model.Mascota;
import com.jairo.api_veterniaria.service.IMascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {
    
    @Autowired
    private IMascotaService mascoSer;
    
    //crear mascota
    @PostMapping("/crear/mascota")
    public ResponseEntity<String> saveMascota(@RequestBody Mascota masco){
        try{
            mascoSer.saveMascota(masco);
            return ResponseEntity.ok("Mascota Creada Correctamente");
        }catch(Exception error){
            return ResponseEntity.badRequest().body("Error al crear mascota");
        }
    }
   
    //borrar mascota
    @DeleteMapping("/borrar/mascota/{id}")
    public ResponseEntity<String> deleteMascota(@PathVariable Long id){
        try{
            mascoSer.deleteMascota(id);
            return ResponseEntity.ok("Mascota borrada correctamente");
        }catch(Exception error){
            return ResponseEntity.badRequest().body("Error al eliminar mascota");
        }
    }
    
    //traer listado de mascotas
    @GetMapping("/traer/mascotas")
    public List<Mascota> getMascotas(){
        List<Mascota> listaMasco = mascoSer.getMascotas();
        return listaMasco;
    }
    
    //editar mascotas
    @PutMapping("/editar/mascota/")
    public Mascota editMascota(@RequestBody Mascota masco){
        mascoSer.editMascota(masco);
        return mascoSer.findMascota(masco.getId_mascota());
    }
    
    //una mascota
    @GetMapping("/buscar/mascota/{id}")
    public ResponseEntity<Mascota> findMascota(@PathVariable Long id){
        Mascota masco = mascoSer.findMascota(id);
        if(masco == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(masco);
    }
    
    //retornar una lista de gatos con la raza siames
    @GetMapping("/traer/gatos/siames")
    public List<Mascota> listaSiames(){
       return  mascoSer.getSiames();
    }
    
    //lista dto
    @GetMapping("/traer/dto")
    public List<DtoMascotaDuenio> getDTO(){
     return   mascoSer.getListaDTO();
    }
}
