package com.project.onlinevotingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.onlinevotingsystem.Entity.Vote;

public interface VoteRepository extends JpaRepository<Vote,Long> {
	
	

}
