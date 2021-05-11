package com.axxiome.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axxiome.springboot.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long>{

}
