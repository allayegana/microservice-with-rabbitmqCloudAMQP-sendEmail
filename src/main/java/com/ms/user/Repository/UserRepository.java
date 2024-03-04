package com.ms.user.Repository;

import com.ms.user.models.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<UserModels, UUID> {
}
