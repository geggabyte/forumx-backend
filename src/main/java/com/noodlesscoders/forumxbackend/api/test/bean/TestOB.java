package com.noodlesscoders.forumxbackend.api.test.bean;

public class TestOB {
    private Long id;

    private String name;

    private Integer time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TestOB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
