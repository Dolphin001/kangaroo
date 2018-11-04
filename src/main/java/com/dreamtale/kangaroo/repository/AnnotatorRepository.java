package com.dreamtale.kangaroo.repository;

import com.dreamtale.kangaroo.model.Annotator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnotatorRepository extends JpaRepository<Annotator,String> {

    List<Annotator> findByPageId(String pageId);

    void  deleteByAnnotatorId(String annotatorId);
}
