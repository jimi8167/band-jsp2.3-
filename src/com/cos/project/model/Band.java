package com.cos.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Band {
	private int id;
	private int userId;
	private String bandName;
	private String bandInfo;
	private String boardTitle;
	private String boardContent;
	private String eventTitle;
	private String eventContent;
	private String attachment;
	
}
