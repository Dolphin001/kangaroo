package com.dreamtale.kangaroo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnnotatorRanges implements Serializable {
	private String rangeId;
	private String parentPageId;
	private String end;
	private String start;
	private int startOffset;
	private int endOffset;


}
