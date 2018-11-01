package com.dreamtale.kangaroo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class AnnotatorRanges implements Serializable {
	@Id
	private String rangeId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "annotator_id")
	private Annotator annotator;

	private String parentPageId;

	private String end;

	private String start;

	private int startOffset;

	private int endOffset;


}
