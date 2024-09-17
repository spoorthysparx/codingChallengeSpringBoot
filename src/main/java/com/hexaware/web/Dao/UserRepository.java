package com.hexaware.web.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.web.Entity.User;
import com.hexaware.web.Enums.UserRole;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 Optional<User> findFirstByEmail(String email);

	    User findByUserRole(UserRole userRole);
}
