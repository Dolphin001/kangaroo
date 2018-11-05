package com.dreamtale.kangaroo.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Annotator  {

	@Id
	private String annotatorId;

	private String pageId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "annotatorId")//pageId
	private Collection<AnnotatorRanges> ranges = new ArrayList<>();

	private String quote;

	private String text;

	@Transient
	private Annotator rows;


}
