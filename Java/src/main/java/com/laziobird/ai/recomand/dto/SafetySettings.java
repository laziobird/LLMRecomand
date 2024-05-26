package com.laziobird.ai.recomand.dto;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 2:22 PM
 */
public class SafetySettings {
    private String category;
    private String threshold;
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }
    public String getThreshold() {
        return threshold;
    }
}

