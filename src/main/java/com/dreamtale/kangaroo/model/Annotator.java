package com.dreamtale.kangaroo.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Annotator  {


	@Id
	private String  annotatorId;

	private String content;

	private String quote;

	private String pageId;

	private String text;


}
