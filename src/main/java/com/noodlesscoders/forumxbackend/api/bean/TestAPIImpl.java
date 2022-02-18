package com.noodlesscoders.forumxbackend.api.bean;

import com.noodlesscoders.forumxbackend.api.TestAPI;
import com.noodlesscoders.forumxbackend.repository.test.TestEntity;
import com.noodlesscoders.forumxbackend.repository.test.TestRepository;
import com.noodlesscoders.forumxbackend.resource.rest.test.TestOB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestAPIImpl implements TestAPI {

    @Autowired
    private TestRepository testRepository;

    @Override
    public List<TestOB> findAll() {
        return mapTest(testRepository.findAll());
    }

    private List<TestOB> mapTest(List<TestEntity> source) {
        return source.stream().map(this::mapTest).collect(Collectors.toList());
    }

    private TestOB mapTest(TestEntity source) {
        TestOB result = new TestOB();
        result.setId(source.getId());
        result.setName(source.getName());
        result.setTime(source.getTime());
        return result;
    }
}
