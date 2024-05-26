package com.laziobird.ai.recomand.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.laziobird.ai.recomand.Constant;
import com.laziobird.ai.recomand.dto.GeminiChatRequest;
import com.laziobird.ai.recomand.dto.GeminiChatRsp;
import com.laziobird.ai.recomand.service.ChatService;
import com.laziobird.ai.recomand.service.GoogleGeminiService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 2:04 PM
 */
@Service
@Slf4j
public class ChatServiceImpl implements ChatService {
    @Resource
    private GoogleGeminiService googleGeminiService;
    @Override
    public GeminiChatRsp sendChat(GeminiChatRequest geminiChatRequest) {
        String requestBody = JSONObject.toJSONString(geminiChatRequest);
        log.info("聊天请求参数:{}", requestBody);
        String responseBody = googleGeminiService.sendRequest(googleGeminiService.returnChatURL(),requestBody, Constant.HTTP_POST);
        log.info("聊天返回参数:{}", responseBody);
        return JSONObject.parseObject(responseBody,GeminiChatRsp.class);
    }

    @Override
    public GeminiChatRsp sendImageChat(GeminiChatRequest geminiChatRequest) {
        String requestBody = JSONObject.toJSONString(geminiChatRequest);
        //log.info("图片识别请求参数:{}", requestBody);
        String responseBody = googleGeminiService.sendRequest(googleGeminiService.returnChatImageURL(),requestBody, Constant.HTTP_POST);
        log.info("图片识别返回参数:{}", responseBody);
        return JSONObject.parseObject(responseBody,GeminiChatRsp.class);
    }
}
