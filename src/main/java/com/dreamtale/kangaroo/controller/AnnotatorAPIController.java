package com.dreamtale.kangaroo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dreamtale.kangaroo.dto.Result;
import com.dreamtale.kangaroo.enums.ResultEnum;
import com.dreamtale.kangaroo.model.Annotator;
import com.dreamtale.kangaroo.model.AnnotatorRanges;
import com.dreamtale.kangaroo.service.IAnnotatorService;
import com.dreamtale.kangaroo.utils.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class AnnotatorAPIController extends BaseController{

	@Resource
	private IAnnotatorService annotatorService;

	@GetMapping("/")
	public void root() throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json="";
		if(br !=null){
			json=br.readLine();
		}

		PrintWriter writer=null;
		try {
			JSONObject jsonData = new JSONObject();

			JSONArray jsonArray=new JSONArray();
			jsonData.put("name","Annotator API");
			jsonData.put("version","1.0.0");
			jsonData.put("author","Moxiaoxuan");

			jsonArray.add(jsonData);
			//writer=repository.getWriter();

			writer.print(jsonArray);
		}catch (Exception e){

		}finally{
			writer.flush();
			writer.close();
		}

	}


	@GetMapping("/annotations")
	public void index()throws IOException {

		Map<String,Object> responseMap=new HashMap<String,Object>();
		responseMap.put("status",200);
		JSONObject jsonData = new JSONObject();

		JSONArray jsonArray=new JSONArray();
		jsonData.put("status",200);
		jsonData.put("ranges",3);
		jsonArray.add(jsonData);
		PrintWriter wirte = null;
		try{
			wirte = response.getWriter();
			wirte.print(jsonArray);

		}catch (Exception e){
			e.printStackTrace();
		}finally{

			wirte.flush();
			wirte.close();
		}
		//return JSONObject.toJSON(responseMap);
	}

	@PostMapping("/annotations")
	public void indexPost() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		System.out.println("annotations post \t"+json);
	}

	/*@ResponseBody
	@RequestMapping(value = "/store",method = RequestMethod.POST)
	public Object create() throws IOException {
		Annotator annotator=new Annotator();
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String content = "";
		if(br != null){
			content = br.readLine();
		}
		System.out.println("json"+content);
		JSONObject data= new JSONObject();content
		//范围
		JSONArray ranges=data.getJSONArray("ranges");
		//生成id
		annotator.setId(WebUtils.genUUID());
		//将所有内容以json储存(测试)
		annotator.setContent(content);
		//概述
		annotator.setQuote(data.getString("quote"));
		//文章id
		annotator.setPageId(data.getString("pageId"));
		//注释内容
		annotator.setText(data.getString("text"));
		List<AnnotatorRanges> annotatorRanges=new ArrayList<AnnotatorRanges>();
		if(ranges.length() > 0){
			AnnotatorRanges annotatorItem=null;
			for(int i=0;i < ranges.length();i++){
				annotatorItem=new AnnotatorRanges();
				org.json.JSONObject rangesObject=ranges.getJSONObject(i);
				annotatorItem.setRangeId(WebUtils.generateUUID());
				// 文章id
				annotatorItem.setParentPageId(data.getString("pageId"));
				//
				annotatorItem.setEnd(rangesObject.getString("end"));
				annotatorItem.setStart(rangesObject.getString("start"));
				//注释的起始位置
				annotatorItem.setEndOffset(rangesObject.getInt("endOffset"));
				annotatorItem.setStartOffset(rangesObject.getInt("startOffset"));
				annotatorRanges.add(annotatorItem);
			}
		}

		int insertStatus=annotatorService.insert(annotator);
		int rangeStatus=annotatorService.insertAnnotatorRanges(annotatorRanges);
		System.out.println("insertStatus"+insertStatus);
		System.out.println("rangeStatus"+rangeStatus);
		Map<String,String> responseMap=new HashMap<String,String>();
		if(insertStatus >0 ){
			// insert success
			responseMap.put("status","success");
			responseMap.put("id",annotator.getId());
		}else{
			//fail
			responseMap.put("status","error");
			responseMap.put("message","there have some error");
		}

		*//*System.out.println(JSONObject.toJSON(responseMap));*//*
		return JSONObject.toJSON(responseMap);
	}*/
	@PostMapping("/create")
	public Result save( @RequestBody Annotator annotator) throws IOException {
		//set id
		if ( annotator != null){
			annotator.setAnnotatorId(WebUtils.genUUID());
			return annotatorService.save(annotator);
		}
		return new Result(ResultEnum.ANNOTATOR_RANGES_ERROR);
	}

	@PutMapping("/update/{pageId}")
	public void update(@PathVariable String pageId){
		System.out.println("update\t"+pageId);


	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody Annotator annotator){
		//deleteAnnotationByAn
		//
		if(annotator != null && annotator.getAnnotatorId() != null){

			annotatorService.deleteAnnotationByAnnotationId(annotator.getAnnotatorId());
		    return new Result(Result.SUCCESS);
		}
		return new Result(Result.ERROR);
	}

	@GetMapping("/search")
	public Result search(@RequestParam String searchId) throws IOException {

		//get articleId
		if( !StringUtils.isEmpty(searchId)){
			return annotatorService.findAnnotationListByPageId(searchId);
		}
		return null;
	}
}
