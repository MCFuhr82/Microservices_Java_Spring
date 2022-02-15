package com.blinkspace.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blinkspace.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
