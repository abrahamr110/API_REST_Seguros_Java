package com.es.segurosinseguros.Repository;

import com.es.segurosinseguros.Entities.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {
}
