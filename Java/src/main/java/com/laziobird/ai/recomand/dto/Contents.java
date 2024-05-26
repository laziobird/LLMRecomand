package com.laziobird.ai.recomand.dto;

import java.util.List;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 2:22 PM
 */
public class Contents {
    private List<Parts> parts;
    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }
    public List<Parts> getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "Contents{" +
                "parts=" + parts +
                '}';
    }
}
