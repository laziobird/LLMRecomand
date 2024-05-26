package com.laziobird.ai.recomand.dto;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 2:29 PM
 */
public class SafetyRatings {
    private String category;
    private String probability;
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }
    public String getProbability() {
        return probability;
    }
}
