package com.laziobird.ai.recomand.dto;

import java.util.List;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 2:28 PM
 */
public class GeminiChatRsp {
    private List<Candidates> candidates;
    private PromptFeedback promptFeedback;
    public void setCandidates(List<Candidates> candidates) {
        this.candidates = candidates;
    }
    public List<Candidates> getCandidates() {
        return candidates;
    }

    public void setPromptFeedback(PromptFeedback promptFeedback) {
        this.promptFeedback = promptFeedback;
    }
    public PromptFeedback getPromptFeedback() {
        return promptFeedback;
    }


}
