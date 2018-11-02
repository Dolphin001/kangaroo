package com.dreamtale.kangaroo.test;

import com.dreamtale.kangaroo.KangarooApplicationTests;
import com.dreamtale.kangaroo.model.Test;
import com.dreamtale.kangaroo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class TestKangaroo  extends KangarooApplicationTests {
    @Autowired
    private TestRepository testRepository;

    @org.junit.Test
    public  void insert(){
        Test test = new Test();
        test.setTestId(UUID.randomUUID().toString());
        test.setTestItem("Page");
        test.setTestMessage("error");
        Test result = testRepository.save(test);
        System.out.println(result.getTestId());
    }
}
