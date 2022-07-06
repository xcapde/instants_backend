package com.xevicorp1.marketplace.repositories;

import com.xevicorp1.marketplace.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
