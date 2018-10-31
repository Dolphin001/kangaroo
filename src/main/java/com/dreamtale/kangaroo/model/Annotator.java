package com.dreamtale.kangaroo.model;

import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
public class Annotator  {


	private String  id;

	private String content;

	private String quote;

	private List<AnnotatorRanges> ranges;

	private String pageId;

	private String text;


}
