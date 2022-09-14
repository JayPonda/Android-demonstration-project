package com.demo.labpracticals.data;

public class Animals {

    private final Integer imgRes;
    private final String name;
    private final String description;

    public Animals(Integer imgRes, String name, String description) {
        this.imgRes = imgRes;
        this.name = name;
        this.description = description;
    }

    public Integer getImgRes() {
        return imgRes;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
