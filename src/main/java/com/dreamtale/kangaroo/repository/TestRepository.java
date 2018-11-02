package com.dreamtale.kangaroo.repository;

import com.dreamtale.kangaroo.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,String> {
}
