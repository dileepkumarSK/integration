package com.jsonAll.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data

public class Emp {
	private int id;
	private String name;
	private boolean permanent;
	@JsonIgnore
	private String role;
}
