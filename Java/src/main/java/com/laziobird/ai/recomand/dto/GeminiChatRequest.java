package com.laziobird.ai.recomand.dto;

import java.util.List;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 2:21 PM
 */
public class GeminiChatRequest {
    private List<Contents> contents;
    public void setContents(List<Contents> contents) {
        this.contents = contents;
    }
    public List<Contents> getContents() {
        return contents;
    }
    private List<SafetySettings> safetySettings;

    private GenerationConfig generationConfig;

    public List<SafetySettings> getSafetySettings() {
        return safetySettings;
    }

    public void setSafetySettings(List<SafetySettings> safetySettings) {
        this.safetySettings = safetySettings;
    }

    public GenerationConfig getGenerationConfig() {
        return generationConfig;
    }

    public void setGenerationConfig(GenerationConfig generationConfig) {
        this.generationConfig = generationConfig;
    }

    @Override
    public String toString() {
        return "GeminiChatRequest{" +
                "contents=" + contents +
                ", safetySettings=" + safetySettings +
                ", generationConfig=" + generationConfig +
                '}';
    }
}
