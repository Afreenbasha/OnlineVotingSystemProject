package com.project.onlinevotingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.onlinevotingsystem.Entity.Voter;

public interface VoterRepository extends JpaRepository<Voter,Long> {
           boolean existsByEmail(String email);
}
