package com.laziobird.ai.recomand.dto;

import java.util.List;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 2:28 PM
 */
public class Candidates {
    private Content content;
    private String finishReason;
    private int index;
    private List<SafetyRatings> safetyRatings;
    public void setContent(Content content) {
        this.content = content;
    }
    public Content getContent() {
        return content;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }
    public String getFinishReason() {
        return finishReason;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }

    public void setSafetyRatings(List<SafetyRatings> safetyRatings) {
        this.safetyRatings = safetyRatings;
    }
    public List<SafetyRatings> getSafetyRatings() {
        return safetyRatings;
    }
}
