package com.dreamtale.kangaroo.service.impl;

import com.dreamtale.kangaroo.dto.Result;
import com.dreamtale.kangaroo.model.Annotator;
import com.dreamtale.kangaroo.model.AnnotatorRanges;
import com.dreamtale.kangaroo.repository.AnnotatorRangesRepository;
import com.dreamtale.kangaroo.repository.AnnotatorRepository;
import com.dreamtale.kangaroo.service.IAnnotatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnotatorServiceImpl implements IAnnotatorService {
	@Autowired
	private AnnotatorRangesRepository annotatorRangesrepository;

	@Autowired
	private AnnotatorRepository annotatorRepository;

	@Override
	public Result save(Annotator annotator) {
		//annotatorDao.save(articles);
		return null;
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

		return null;//annotatorRepository.findListById(uuid).get();
	}

	@Override
	public int insertAnnotatorRanges(List<AnnotatorRanges> annotatorRanges) {
		return 0;
	}
}
