package com.dreamtale.kangaroo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class AnnotatorRanges implements Serializable {
	@Id
	private String rangeId;

	//private String pageId;
	private String annotatorId;

	private String end;

	private String start;

	private int startOffset;

	private int endOffset;
}
