package com.dreamtale.kangaroo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping
public class AnnotatorController extends BaseController{

	@RequestMapping(value = "/article")
	public String showArticle() throws IOException {
		return "article";
	}
}
