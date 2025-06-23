package com.project.onlinevotingsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ElectionResultRequestDTO {
	@NotBlank(message="Election name Requried")
    private String electionName;
}
