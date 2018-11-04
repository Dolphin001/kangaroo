package com.dreamtale.kangaroo.service;


import com.dreamtale.kangaroo.dto.Result;
import com.dreamtale.kangaroo.model.Annotator;
import com.dreamtale.kangaroo.model.AnnotatorRanges;

import java.util.List;

public interface IAnnotatorService {

	Result save(Annotator annotator);

	Result findAnnotationListByPageId(String pageId);

	void  deleteAnnotationByAnnotationId(String annotatorId);

}
