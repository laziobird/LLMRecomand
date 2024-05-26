package com.laziobird.ai.recomand.service;

public interface GoogleGeminiService {

    /**
     * 通用请求封装方法
     *
     * @param url
     * @param requestBody
     * @param method
     * @return
     */
    String sendRequest(String url, String requestBody, String method);

    /**
     * 封装 Chat 模型的API
     * @return
     */
    String returnChatURL();

    String returnChatImageURL();
}
