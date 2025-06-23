package com.project.onlinevotingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.onlinevotingsystem.Entity.ElectionResult;

public interface ElectionResultRepository extends JpaRepository<ElectionResult,Long> {
            Optional<ElectionResult> findByElectionName(String electionName);
}
