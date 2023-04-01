package com.example.northwind.core.utilities.logging.dataAccess;

import com.example.northwind.core.utilities.logging.entities.Logg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogDao extends JpaRepository<Logg, Integer> {

}
