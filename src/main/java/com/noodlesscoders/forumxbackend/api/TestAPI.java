package com.noodlesscoders.forumxbackend.api;

import com.noodlesscoders.forumxbackend.resource.rest.test.TestOB;

import java.util.List;

public interface TestAPI {
    List<TestOB> findAll();
}
