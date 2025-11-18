package com.wardrobedecoder.backend.Repo;

import com.wardrobedecoder.backend.Entity.WardrobeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardrobeRepo extends JpaRepository<WardrobeEntity, Long> {
}
