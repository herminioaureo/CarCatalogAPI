package com.herminio.carcatalog.repository;

import com.herminio.carcatalog.entity.CarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<CarsEntity, Long> {
}
