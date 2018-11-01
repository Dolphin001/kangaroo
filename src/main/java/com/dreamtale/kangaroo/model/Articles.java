package com.dreamtale.kangaroo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 文章
 * 现在用于测试annotation.js
 * */
@Data
@Entity
public class Articles implements Serializable{
	/**
	 * 文章id
	 * */
	@Id
	private Integer id;
	/**
	 * 文章内容
	 * */
	private  String articleContent;

}
