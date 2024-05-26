package com.laziobird.ai.recomand.dto;

import java.util.List;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 2:22 PM
 */
public class GenerationConfig {
    private double temperature;
    private int topK;
    private int topP;
    private int maxOutputTokens;
    private List<String> stopSequences;
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public double getTemperature() {
        return temperature;
    }

    public void setTopK(int topK) {
        this.topK = topK;
    }
    public int getTopK() {
        return topK;
    }

    public void setTopP(int topP) {
        this.topP = topP;
    }
    public int getTopP() {
        return topP;
    }

    public void setMaxOutputTokens(int maxOutputTokens) {
        this.maxOutputTokens = maxOutputTokens;
    }
    public int getMaxOutputTokens() {
        return maxOutputTokens;
    }

    public void setStopSequences(List<String> stopSequences) {
        this.stopSequences = stopSequences;
    }
    public List<String> getStopSequences() {
        return stopSequences;
    }
}

