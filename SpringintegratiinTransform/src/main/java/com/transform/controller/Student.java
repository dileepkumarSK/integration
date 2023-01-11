package com.transform.controller;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@AllArgsConstructor
@ToString(includeFieldNames = true)
@NoArgsConstructor
public class Student {

	String name;
	Integer id;
}
