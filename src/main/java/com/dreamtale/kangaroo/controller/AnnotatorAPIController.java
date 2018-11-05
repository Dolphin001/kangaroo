package com.dreamtale.kangaroo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dreamtale.kangaroo.dto.Result;
import com.dreamtale.kangaroo.enums.ResultEnum;
import com.dreamtale.kangaroo.model.Annotator;
import com.dreamtale.kangaroo.service.IAnnotatorService;
import com.dreamtale.kangaroo.utils.WebUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class AnnotatorAPIController extends BaseController{

    @Value("${kangaroo.name}")
	private String name;

    @Value("${kangaroo.version}")
	private String version;

    @Value("${kangaroo.author}")
	private String author;

	@Resource
	private IAnnotatorService annotatorService;

	@GetMapping("")
	public Result root() throws IOException {

		Map <String,String> resultMap = new HashMap<>();
		resultMap.put("name",name);
		resultMap.put("version",version);
		resultMap.put("author",author);

		return new Result(ResultEnum.INIT_PAGE,resultMap);
	}
	/**
	 * Save  annotation
	 *
	 * */
	@PostMapping("/create")
	public Result save( @RequestBody Annotator annotator) throws IOException {
		//set id
		if ( annotator != null){
			annotator.setAnnotatorId(WebUtils.genUUID());
			return annotatorService.save(annotator);
		}
		return new Result(ResultEnum.ANNOTATOR_RANGES_ERROR);
	}

	/**
	 * update annotator
	 * */
	@PutMapping("/update")
	public Result update(@RequestBody Annotator annotator){

		if(annotator != null && !StringUtils.isEmpty(annotator.getAnnotatorId())){
			return annotatorService.save(annotator);
		}
		return new Result(ResultEnum.UPDATE_DEFEAT);
	}
	/**
	 * Delete annotator
	 * */
	@DeleteMapping("/delete")
	public Result delete(@RequestBody Annotator annotator){
		//deleteAnnotationByAn
		//
		if(annotator != null && !StringUtils.isEmpty(annotator.getAnnotatorId())){

			annotatorService.deleteAnnotationByAnnotationId(annotator.getAnnotatorId());
		    return new Result(Result.SUCCESS);
		}
		return new Result(Result.ERROR);
	}

	/**
	 * Search annotation
	 * */
	@GetMapping("/search")
	public Result search(@RequestParam String searchId) throws IOException {

		//get articleId
		if( !StringUtils.isEmpty(searchId)){
			return annotatorService.findAnnotationListByPageId(searchId);
		}
		//TODO
		return null;
	}
}
