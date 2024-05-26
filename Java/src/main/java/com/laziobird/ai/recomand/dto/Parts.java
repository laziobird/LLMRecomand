package com.laziobird.ai.recomand.dto;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 2:22 PM
 */
public class Parts {
    private String text;
    private InlineData inlineData;
    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

    public InlineData getInlineData() {
        return inlineData;
    }

    public void setInlineData(InlineData inlineData) {
        this.inlineData = inlineData;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "text='" + text + '\'' +
                ", inlineData=" + inlineData +
                '}';
    }
}
