package Dto;

import lombok.Data;

@Data
public class TodosDto {
	private int userid;
	private int id;
	private String title;
	private boolean completed;
}
