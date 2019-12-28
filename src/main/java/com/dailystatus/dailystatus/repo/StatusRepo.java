package com.dailystatus.dailystatus.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailystatus.dailystatus.entity.Status;


public interface StatusRepo extends JpaRepository<Status, Long>  {

}
