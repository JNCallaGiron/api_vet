
package com.jairo.api_veterniaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_mascota;
    private String nombre;
    private String especie;
    private String raza;
    private String color;

    @OneToOne
    @JoinColumn(name="id_duenio",referencedColumnName="id_duenio")
    private Dueño duenio;
            
    public Mascota() {
    }

    public Mascota(Long id_mascota, String nombre, String especie, String raza, String color, Dueño duenio) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.duenio = duenio;
    }

   
}
