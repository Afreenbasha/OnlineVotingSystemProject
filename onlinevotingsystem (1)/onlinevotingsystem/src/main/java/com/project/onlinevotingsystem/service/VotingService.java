package com.project.onlinevotingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.onlinevotingsystem.Entity.Candidate;
import com.project.onlinevotingsystem.Entity.Vote;
import com.project.onlinevotingsystem.Entity.Voter;
import com.project.onlinevotingsystem.exception.ResourceNotFoundException;
import com.project.onlinevotingsystem.exception.VoteNotAllowedException;
import com.project.onlinevotingsystem.repository.CandidateRepository;
import com.project.onlinevotingsystem.repository.VoteRepository;
import com.project.onlinevotingsystem.repository.VoterRepository;

import jakarta.transaction.Transactional;

@Service
public class VotingService {

	private VoteRepository voteRepository;
	private CandidateRepository candidateRepository;
	private VoterRepository voterRepository;

	@Autowired
	public VotingService(VoteRepository voteRepository, CandidateRepository candidateRepository,
			VoterRepository voterRepository) {

		this.voteRepository = voteRepository;
		this.candidateRepository = candidateRepository;
		this.voterRepository = voterRepository;
	}
	
	@Transactional
	public Vote castVote(Long voterId,Long candidateId) {
		if(!voterRepository.existsById(voterId)) {
			throw new ResourceNotFoundException("voter not found with Id: " +voterId);
		}
		
		if(!candidateRepository.existsById(candidateId)) {
			throw new ResourceNotFoundException("candidate not found with Id: " +candidateId);
		}
		
		Voter voter=voterRepository.findById(voterId).get();
		
		if(voter.isHasVoted()) {
			throw new VoteNotAllowedException("Voter Id:" +voterId+ " has already casted vote");
			
		}
		
		Candidate candidate=candidateRepository.findById(candidateId).get();
		//change databse , record voted table data 
		Vote vote=new Vote();
		vote.setVoter(voter);
		vote.setCandidate(candidate);
		
		//voteRepository.save(vote);
		
		
		
		candidate.setVoteCount(candidate.getVoteCount()+1);
		candidateRepository.save(candidate);
		
		voter.setVote(vote);
		voter.setHasVoted(true);
		voterRepository.save(voter);
		
		return vote;
		
	}
	
	 public List<Vote>getAllVotes(){
		 return voteRepository.findAll();
	 }

}
