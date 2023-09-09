package com.rose.crud.units.repository;

import com.rose.crud.units.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit,Long> {
    Unit findByUnitName(String unitName);
}
