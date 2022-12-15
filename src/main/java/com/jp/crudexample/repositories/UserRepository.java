package com.jp.crudexample.repositories;

import com.jp.crudexample.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
