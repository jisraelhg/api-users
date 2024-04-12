package com.jisrael.services.users.repositories;

import com.jisrael.services.users.entity.UserPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPhoneRepository extends JpaRepository<UserPhone, Long> {
}
