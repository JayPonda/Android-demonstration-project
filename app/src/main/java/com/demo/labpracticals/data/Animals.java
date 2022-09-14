package com.demo.labpracticals.data;

public class Animals {

    private final Integer imgRes;
    private final String name;

    public Animals(Integer imgRes, String name) {
        this.imgRes = imgRes;
        this.name = name;
    }

    public Integer getImgRes() {
        return imgRes;
    }

    public String getName() {
        return name;
    }
}
