package com.spring.core.springCore;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(includeFieldNames = true)
@NoArgsConstructor
@Component
public class MarksList {

	private Integer stno;
	private Integer totalMarks;
}
