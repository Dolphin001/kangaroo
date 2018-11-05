package com.dreamtale.kangaroo.service.impl;

import com.dreamtale.kangaroo.dto.Result;
import com.dreamtale.kangaroo.enums.ResultEnum;
import com.dreamtale.kangaroo.model.Annotator;
import com.dreamtale.kangaroo.model.AnnotatorRanges;
import com.dreamtale.kangaroo.repository.AnnotatorRangesRepository;
import com.dreamtale.kangaroo.repository.AnnotatorRepository;
import com.dreamtale.kangaroo.service.IAnnotatorService;
import com.dreamtale.kangaroo.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnnotatorServiceImpl implements IAnnotatorService {
	@Autowired
	private AnnotatorRangesRepository annotatorRangesrepository;

	@Autowired
	private AnnotatorRepository annotatorRepository;

	@Override
	@Transactional
	public Result save(Annotator annotator) {

		List<AnnotatorRanges> rangesList = (List<AnnotatorRanges>) annotator.getRanges();
		if( rangesList != null){
			for(AnnotatorRanges ranges : rangesList){
				ranges.setRangeId(WebUtils.genUUID());
			}
			Annotator ann = annotatorRepository.save(annotator);
			if(ann != null){
				Map<String,String> idMap = new HashMap<>();
				idMap.put("id",annotator.getAnnotatorId());
				/**
				 *  Delete because the annotatorId is empty when
				 * updating the AnnotatorRanges table,
				 * the data is useless data at this time.
				 * */
				annotatorRangesrepository.deleteByAnnotatorId(null);

				return new Result(ResultEnum.INSERT_SUCCESS,idMap);
			}else{
				return new Result(ResultEnum.INSERT_DEFEAT);
			}
		}
		return new Result(ResultEnum.ANNOTATOR_RANGES_ERROR);
	}

	@Override
	public Result findAnnotationListByPageId(String pageId) {

		//List<Annotator>
		List<Annotator> annotatorList = annotatorRepository.findByPageId(pageId);

		return new Result(ResultEnum.SEARCH_ANNOTATION,annotatorList);
	}

	@Override
    @Transactional
	public void deleteAnnotationByAnnotationId(String annotatorId) {
        /**
         * First delete the data of the detail table.
         * */
	    //annotatorRangesrepository.deleteByAnnotatorId(annotatorId);
	    /**then delete the data of the annotator table*/
	    annotatorRepository.deleteByAnnotatorId(annotatorId);
	}

}
