package com.project.onlinevotingsystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VoteRequestDTO {
	// recevieing from client
	
	@NotNull(message="Voter Id is Required")
	Long voterId;
	@NotNull(message="Candidate Id is Required")
	Long candidateId;
	

}
