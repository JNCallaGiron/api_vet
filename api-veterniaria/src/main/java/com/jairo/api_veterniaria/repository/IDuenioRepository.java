
package com.jairo.api_veterniaria.repository;

import com.jairo.api_veterniaria.model.Dueño;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuenioRepository extends JpaRepository<Dueño, Long> {
    
}
