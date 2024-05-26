package com.laziobird.ai.recomand;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 1:26 PM
 */
public class Constant {

    public static final String HTTP_POST = "POST";
    public static final String HTTP_GET = "GET";
    public static final String HTTP_PUT = "PUT";
    public static final String HTTP_PATCH = "PATCH";

    public static final String HTTP_DELETE = "DELETE";

    /**
     * Google Gemini AI API KEY
     * https://aistudio.google.com/app/apikey
     */
    public static final String GOOGLE_GEMINI_API_KEY = "输入自己的Google Gemini API KEY";
    /**
     * Gemini Chat 模型下访问 API
     */
    public static final String GOOGLE_GEMINI_CHAT_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key="+GOOGLE_GEMINI_API_KEY;

    /**
     * Gemini Chat 模型下访问 API
     */
    public static final String GOOGLE_GEMINI_CHAT_IMAGE_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.0-pro-vision-latest:generateContent?key="+GOOGLE_GEMINI_API_KEY;
    //curl https://generativelanguage.googleapis.com/v1beta/models/gemini-pro-vision:generateContent?key=${API_KEY} \
    //        -H 'Content-Type: application/json' \
    //        -d @request.json 2> /dev/null | grep "text"

    //public static final String GOOGLE_GEMINI_CHAT_IMAGE_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro-vision:generateContent?key="+GOOGLE_GEMINI_API_KEY;

    //https://generativelanguage.googleapis.com/v1beta/models/gemini-1.0-pro-vision-latest:generateContent?key=${API_KEY}
}
