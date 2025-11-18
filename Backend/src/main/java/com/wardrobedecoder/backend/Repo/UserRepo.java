package com.wardrobedecoder.backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wardrobedecoder.backend.Entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

    // You can add custom query methods if needed, e.g.:
    UserEntity findByEmail(String email);
}
