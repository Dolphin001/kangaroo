package com.dreamtale.kangaroo.response;

import com.dreamtale.kangaroo.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,String> {
}
