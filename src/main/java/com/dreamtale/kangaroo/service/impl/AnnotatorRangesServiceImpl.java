package com.dreamtale.kangaroo.service.impl;

import com.dreamtale.kangaroo.repository.AnnotatorRangesRepository;
import com.dreamtale.kangaroo.service.AnnotatorRangesService;
import org.springframework.stereotype.Service;

/**
 * Created by Dreamtale
 * Create date 2018/11/4
 */
@Service
public class AnnotatorRangesServiceImpl implements AnnotatorRangesService {


    private AnnotatorRangesRepository annotatorRangesRepository;
    @Override
    public void deleteByAnnotatorId(String annotatorId) {

        annotatorRangesRepository.deleteByAnnotatorId(annotatorId);
    }
}
