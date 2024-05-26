package com.laziobird.ai.recomand.dto;

import java.util.List;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 2:30 PM
 */
public class PromptFeedback {
    private List<SafetyRatings> safetyRatings;
    public void setSafetyRatings(List<SafetyRatings> safetyRatings) {
        this.safetyRatings = safetyRatings;
    }
    public List<SafetyRatings> getSafetyRatings() {
        return safetyRatings;
    }
}
