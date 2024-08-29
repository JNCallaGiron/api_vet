
package com.jairo.api_veterniaria.repository;

import com.jairo.api_veterniaria.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Long> {
    
    
    
}
