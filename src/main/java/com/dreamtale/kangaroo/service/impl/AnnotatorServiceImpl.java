package com.dreamtale.kangaroo.service.impl;

import com.dreamtale.kangaroo.dto.ResponseModel;
import com.dreamtale.kangaroo.model.Annotator;
import com.dreamtale.kangaroo.model.AnnotatorRanges;
import com.dreamtale.kangaroo.response.AnnotatorRangesrepository;
import com.dreamtale.kangaroo.response.AnnotatorRepository;
import com.dreamtale.kangaroo.service.IAnnotatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnotatorServiceImpl implements IAnnotatorService {
	@Autowired
	private AnnotatorRangesrepository annotatorRangesrepository;

	@Autowired
	private AnnotatorRepository annotatorRepository;

	@Override
	public ResponseModel save(Annotator annotator) {
		//annotatorDao.save(articles);
		return new ResponseModel(0,"success",0);
	}

	@Override
	public Annotator selectAnnotationArticleById(Integer id) {
		//return annotatorDao.findById(id);
		return  null;
	}

	@Override
	public void delete(Integer articleId) {

	}

	@Override
	public int insert(Annotator annotator) {
		//return annotatorDao.insert(annotator);
		return 0;

	}

	@Override
	public int update(Annotator annotator) {
		return 0;
	}

	@Override
	public List<Annotator> selectByUUID(String uuid) {

		return annotatorRepository.findListById(uuid).get();
	}

	@Override
	public int insertAnnotatorRanges(List<AnnotatorRanges> annotatorRanges) {
		return 0;
	}
}
