package com.jairo.api_veterniaria.controller;

import com.jairo.api_veterniaria.model.Dueño;
import com.jairo.api_veterniaria.service.IDuenioService;
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
public class DuenioController {

    @Autowired
    private IDuenioService duenioServ;

    //para crear un dueño
    @PostMapping("/crear/dueño")
    public ResponseEntity<String> saveDuenio(@RequestBody Dueño duenio) {
        try {
            duenioServ.saveDuenio(duenio);
            return ResponseEntity.ok("Dueño creado Correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear dueño");
        }
    }

    //borrar dueño
    @DeleteMapping("/eliminar/dueño/{id}")
    public ResponseEntity<String> deleteDuenio(@PathVariable Long id) {
        try {
            duenioServ.deleteDuenio(id);
            return ResponseEntity.ok("Dueño borrado correctamente");
        } catch (Exception error) {
            return ResponseEntity.badRequest().body("Error al borrar dueño, id no encontrada");
        }
    }
    
    //traer lista de dueños
    @GetMapping("/traer/dueños")
    public List<Dueño> getDuenios(){
        List<Dueño> listaDuenios = duenioServ.getDuenios();
        return listaDuenios;
    }
    
    //editar dueño
    @PutMapping("/editar/dueño")
    public Dueño editDuenio (@RequestBody Dueño due){
        duenioServ.editDuenio(due);
        return  duenioServ.findDuenio(due.getId_duenio());
    }
    
    //encontrar un solo dueño
    @GetMapping("/buscar/dueño/{id}")
    public ResponseEntity<Dueño> findDuenio (@PathVariable Long id){
        Dueño due = duenioServ.findDuenio(id);
        if (due == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(due);
    }
}
