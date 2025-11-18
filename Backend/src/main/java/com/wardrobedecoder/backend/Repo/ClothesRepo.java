package com.wardrobedecoder.backend.Repo;

import com.wardrobedecoder.backend.Entity.ClothesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothesRepo extends JpaRepository<ClothesEntity, Long> {

    List<ClothesEntity> findByType(String type);
    List<ClothesEntity> findByColor(String color);
    List<ClothesEntity> findBySize(String size);
    List<ClothesEntity> findByMaterial(String material);
}
