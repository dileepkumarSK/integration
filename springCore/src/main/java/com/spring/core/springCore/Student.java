package com.spring.core.springCore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
@Component
public class Student {
	@NonNull
	private Integer no;
	@NonNull
	private String stname;
	
	private MarksList marsk;
}
