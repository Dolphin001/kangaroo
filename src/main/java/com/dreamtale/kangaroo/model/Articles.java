package com.dreamtale.kangaroo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 文章
 * 现在用于测试annotation.js
 * */
@Data
public class Articles implements Serializable{
	/**
	 * 文章id
	 * */
	private Integer id;
	/**
	 * 文章内容
	 * */
	private  String articleContent;

}
