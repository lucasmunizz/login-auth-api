package com.lucas.loginauthapi.repositories;

import com.lucas.loginauthapi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
