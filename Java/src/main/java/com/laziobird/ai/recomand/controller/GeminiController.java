package com.laziobird.ai.recomand.controller;

import com.laziobird.ai.recomand.dto.*;
import com.laziobird.ai.recomand.service.ChatService;
import com.laziobird.ai.recomand.util.PromptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/gemini")
public class GeminiController {
    @Autowired
    private ChatService chatService;

    @PostMapping ("/chat")
    public ResultDto chat(@RequestBody ChatRequest chat) {
        GeminiChatRequest req = new GeminiChatRequest();
        List<Contents> contents = new ArrayList<>();
        Contents contentObj = new Contents();
        List<Parts> parts = new ArrayList<>();
        Parts part = new Parts();
        part.setText(chat.getMessage());
        parts.add(part);
        contentObj.setParts(parts);
        contents.add(contentObj);
        req.setContents(contents);
        GeminiChatRsp rsp = chatService.sendChat(req);
        ResultDto result = new ResultDto();
        result.success(rsp.getCandidates().get(0).getContent().getParts().get(0).getText());
        log.info("返回的聊天记录JSON:{}",result);
        return result;
    }


    @PostMapping ("/bookRecommendation")
    public ResultDto bookRecommendation(@RequestBody ChatRequest chat) {
        GeminiChatRequest req = new GeminiChatRequest();
        List<Contents> contents = new ArrayList<>();
        Contents contentObj = new Contents();
        List<Parts> parts = new ArrayList<>();
        Parts part = new Parts();
        part.setText(PromptUtil.getByBookCosineSimilarity(chat.getMessage()));
        parts.add(part);
        contentObj.setParts(parts);
        contents.add(contentObj);
        req.setContents(contents);
        GeminiChatRsp rsp = chatService.sendChat(req);
        ResultDto result = new ResultDto();
        result.success(rsp.getCandidates().get(0).getContent().getParts().get(0).getText());
        log.info("返回的聊天记录JSON:{}",result);
        return result;
    }


    @PostMapping ("/movieRecommendation")
    public ResultDto movieRecommendation(@RequestBody ChatRequest chat) {
        GeminiChatRequest req = new GeminiChatRequest();
        List<Contents> contents = new ArrayList<>();
        Contents contentObj = new Contents();
        List<Parts> parts = new ArrayList<>();
        Parts part = new Parts();
        part.setText(PromptUtil.getByMovieCollaborativeFiltering(chat.getMessage()));
        parts.add(part);
        contentObj.setParts(parts);
        contents.add(contentObj);
        req.setContents(contents);
        GeminiChatRsp rsp = chatService.sendChat(req);
        ResultDto result = new ResultDto();
        result.success(rsp.getCandidates().get(0).getContent().getParts().get(0).getText());
        log.info("返回的聊天记录JSON:{}",result);
        return result;
    }

    @PostMapping ("/mallRecommendation")
    public ResultDto mallRecommendation(@RequestBody ChatRequest chat) {
        GeminiChatRequest req = new GeminiChatRequest();
        List<Contents> contents = new ArrayList<>();
        Contents contentObj = new Contents();
        List<Parts> parts = new ArrayList<>();
        Parts part = new Parts();
        part.setText(PromptUtil.getByOrderCollaborativeFiltering(chat.getMessage()));
        parts.add(part);
        contentObj.setParts(parts);
        contents.add(contentObj);
        req.setContents(contents);
        GeminiChatRsp rsp = chatService.sendChat(req);
        ResultDto result = new ResultDto();
        result.success(rsp.getCandidates().get(0).getContent().getParts().get(0).getText());
        log.info("返回的聊天记录JSON:{}",result);
        return result;
    }

    @PostMapping ("/mallRecommendationAssociationRule")
    public ResultDto mallRecommendationAssociationRule(@RequestBody ChatRequest chat) {
        GeminiChatRequest req = new GeminiChatRequest();
        List<Contents> contents = new ArrayList<>();
        Contents contentObj = new Contents();
        List<Parts> parts = new ArrayList<>();
        Parts part = new Parts();
        part.setText(PromptUtil.getByOrderAssociationRules(chat.getMessage()));
        parts.add(part);
        contentObj.setParts(parts);
        contents.add(contentObj);
        req.setContents(contents);
        GeminiChatRsp rsp = chatService.sendChat(req);
        ResultDto result = new ResultDto();
        result.success(rsp.getCandidates().get(0).getContent().getParts().get(0).getText());
        log.info("返回的聊天记录JSON:{}",result);
        return result;
    }

    @PostMapping ("/textAndImage")
    public ResultDto textAndImage(@RequestParam("file") MultipartFile file) throws IOException {


        // 编码为 Base64 字符串
        String base64 = new String(Base64.getEncoder().encode(file.getBytes()), StandardCharsets.UTF_8);
        //log.info("base64图片格式: {}",base64);

        GeminiChatRequest req = new GeminiChatRequest();
        List<Contents> contents = new ArrayList<>();
        Contents contentObj = new Contents();
        List<Parts> parts = new ArrayList<>();
        Parts part = new Parts();
        Parts part2 = new Parts();
        part.setText(PromptUtil.getByChatImage());
        InlineData inlineData = new InlineData();
        inlineData.setMimeType("image/jpeg");
        inlineData.setData(base64);
        part2.setInlineData(inlineData);
        parts.add(part);
        parts.add(part2);
        contentObj.setParts(parts);
        contents.add(contentObj);
        req.setContents(contents);
        GeminiChatRsp rsp = chatService.sendImageChat(req);
        ResultDto result = new ResultDto();
        result.success(rsp.getCandidates().get(0).getContent().getParts().get(0).getText());
        log.info("返回的图文聊天记录JSON:{}",result);
        return result;
    }




}
