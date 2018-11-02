package com.dreamtale.kangaroo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Article
 * Now used for testing annotation.js
 * */
@Data
@Entity
public class Articles implements Serializable{
	/**
	 * article id
	 * */
	@Id
	private Integer id;

	private  String articleContent;

}
