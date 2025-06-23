package com.project.onlinevotingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.onlinevotingsystem.Entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
	
	List<Candidate>findAllByOrderByVoteCountDesc();

}
