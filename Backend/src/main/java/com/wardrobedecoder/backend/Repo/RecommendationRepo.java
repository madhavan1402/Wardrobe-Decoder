package com.wardrobedecoder.backend.Repo;

import com.wardrobedecoder.backend.Entity.RecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepo extends JpaRepository<RecommendationEntity, Long> {
}
