
package com.jairo.api_veterniaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Dueño {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_duenio;
    private String dni;
    private String nombre;
    private String apellido;
    private String celular;

    public Dueño() {
    }

    public Dueño(Long id_duenio, String dni, String nombre, String apellido, String celular) {
        this.id_duenio = id_duenio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
    }

 

    
    
    
    
}
