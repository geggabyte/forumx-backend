package com.noodlesscoders.forumxbackend.api.test;

import com.noodlesscoders.forumxbackend.api.test.bean.TestOB;

import java.util.List;

public interface TestAPI {
    List<TestOB> findAll();
}
