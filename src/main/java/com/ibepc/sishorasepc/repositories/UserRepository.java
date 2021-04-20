package com.ibepc.sishorasepc.repositories;

import com.ibepc.sishorasepc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/* GUILHERME 20/04/21 */

public interface UserRepository extends JpaRepository<User, Integer> {
}
