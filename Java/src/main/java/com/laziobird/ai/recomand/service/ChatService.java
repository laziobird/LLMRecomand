package com.laziobird.ai.recomand.service;

import com.laziobird.ai.recomand.dto.GeminiChatRequest;
import com.laziobird.ai.recomand.dto.GeminiChatRsp;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 2:04 PM
 */
public interface ChatService {
    /**
     * 通过Chat 模式获取返回对话结果
     * @param geminiChatRequest
     * @return
     */
    GeminiChatRsp sendChat(GeminiChatRequest geminiChatRequest);

    /**
     * 通过Text-and-image input 模式返回图片识别结果
     * @param geminiChatRequest
     * @return
     */
    GeminiChatRsp sendImageChat(GeminiChatRequest geminiChatRequest);
}
