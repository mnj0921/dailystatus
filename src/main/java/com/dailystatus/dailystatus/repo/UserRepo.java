package com.dailystatus.dailystatus.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailystatus.dailystatus.entity.User;

public interface UserRepo extends JpaRepository<User, String> {

}
