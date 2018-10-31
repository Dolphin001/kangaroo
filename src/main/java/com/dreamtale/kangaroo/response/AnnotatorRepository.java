package com.dreamtale.kangaroo.response;

import com.dreamtale.kangaroo.model.Annotator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnnotatorRepository extends JpaRepository<Annotator,String> {

    Optional<List<Annotator>> findListById(String uuid);
}
