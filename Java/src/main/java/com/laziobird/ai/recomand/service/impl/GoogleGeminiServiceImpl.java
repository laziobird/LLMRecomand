package com.laziobird.ai.recomand.service.impl;

import com.laziobird.ai.recomand.Constant;
import com.laziobird.ai.recomand.service.GoogleGeminiService;
import com.laziobird.ai.recomand.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 1:22 PM
 */
@Service
@Slf4j
public class GoogleGeminiServiceImpl implements GoogleGeminiService {
    @Override
    public String sendRequest(String url, String requestBody, String method) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("Gemini.API.GetKey");
        Map<String, String> header = new HashMap<String, String>();
        String responseBody = null;
        try {
            if (method.equals(Constant.HTTP_PUT)) {
                responseBody = HttpUtil.put(url, header, requestBody);
            } else if (method.equals(Constant.HTTP_POST)) {
                responseBody = HttpUtil.post(url, header, requestBody);
            } else if (method.equals(Constant.HTTP_GET)) {
                responseBody = HttpUtil.get(url, header);
            } else if (method.equals(Constant.HTTP_PATCH)) {
                responseBody = HttpUtil.patch(url, header, requestBody);
            } else if (method.equals(Constant.HTTP_DELETE)) {
                responseBody = HttpUtil.delete(url, header, requestBody);
            }
            if (!StringUtils.hasText(responseBody)) {

            }
        } catch (Exception e) {
            log.error(" GoogleGeminiServiceImpl.sendRequest error : ", e.getMessage());
        } finally {
            stopWatch.stop();
            printTask(stopWatch);
        }
        return responseBody;
    }

    private void printTask(StopWatch taks) {
        for (StopWatch.TaskInfo taskInfo : taks.getTaskInfo()) {
            log.info("printTask name={} costs={}", taskInfo.getTaskName(), taskInfo.getTimeMillis());
        }
    }
    @Override
    public String returnChatURL() {
        return Constant.GOOGLE_GEMINI_CHAT_URL;
    }

    @Override
    public String returnChatImageURL() {
        return Constant.GOOGLE_GEMINI_CHAT_IMAGE_URL;
    }

}
