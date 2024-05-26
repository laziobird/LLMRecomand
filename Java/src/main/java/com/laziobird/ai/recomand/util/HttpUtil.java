package com.laziobird.ai.recomand.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import io.micrometer.common.util.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

/**
 * @author jiangzhiwei greentim2049@gmail.com
 * @date 2024/2/19 1:39 PM
 */
public class HttpUtil {
    public static String post(String url, Map<String, String> headers, String body) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        String respEntity = null;
        for (int i = 0; i < 2; i++) {
            //设置请求头
            HttpPost post = new HttpPost(url);
            headers.put(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            for (String key : headers.keySet()) {
                post.setHeader(key, headers.get(key));
            }
            //设置请求体
            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
            pairs.add(new BasicNameValuePair("key", "value"));
            HttpEntity urlEncodedFormEntity = new UrlEncodedFormEntity(pairs);
            //2.StringEntity 字符串参数
            if (StringUtils.isNotBlank(body)) {
                HttpEntity entity = new StringEntity(body, "UTF-8");
                //包括但不限于以下许多种HttpEntity
                post.setEntity(entity);
            }
            response = httpClient.execute(post);
            respEntity = EntityUtils.toString(response.getEntity());
            //状态码50X或者超时则返回
            if (!(response.getStatusLine().getStatusCode() >= 500 && response.getStatusLine().getStatusCode() < 600) && (response.getStatusLine().getStatusCode() != 408)) {
                break;
            }
            if (i == 0) {
                Thread.sleep(1000);
            }
        }
        //关闭连接
        httpClient.close();
        response.close();
        return respEntity;
    }

    public static String put(String url, Map<String, String> headers, String body) throws Exception {
        String respEntity = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        for (int i = 0; i < 2; i++) {
            //设置请求头
            HttpPut put = new HttpPut(url);
            headers.put(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            for (String key : headers.keySet()) {
                put.setHeader(key, headers.get(key));
            }
            //设置请求体
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("key", "value"));
            HttpEntity urlEncodedFormEntity = new UrlEncodedFormEntity(pairs);
            //2.StringEntity 字符串参数
            if (StringUtils.isNotBlank(body)) {
                HttpEntity entity = new StringEntity(body, "UTF-8");
                put.setEntity(entity);
            }
            response = httpClient.execute(put);
            respEntity = EntityUtils.toString(response.getEntity());
            //状态码50X或者超时则返回
            if (!(response.getStatusLine().getStatusCode() >= 500 && response.getStatusLine().getStatusCode() < 600) && (response.getStatusLine().getStatusCode() != 408)) {
                break;
            }
            if (i == 0) {
                Thread.sleep(1000);
            }

        }
        //关闭连接
        httpClient.close();
        response.close();
        return respEntity;

    }

    public static String get(String url, Map<String, String> headers, Map<String, Object> params) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder(url);
        // 构建请求参数
        if (!CollectionUtils.isEmpty(params)) {
            params.forEach((k, v) -> {
                if (Objects.nonNull(v)) {
                    uriBuilder.addParameter(k, v.toString());
                }
            });
        }
        HttpGet get = new HttpGet(uriBuilder.build());
        //设置请求头
        headers.put(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        if (!CollectionUtils.isEmpty(params)) {
            for (String key : headers.keySet()) {
                get.setHeader(key, headers.get(key));
            }
        }
        CloseableHttpResponse response = httpClient.execute(get);
        String respEntity = EntityUtils.toString(response.getEntity());
        //关闭连接
        httpClient.close();
        response.close();
        return respEntity;
    }

    public static String get(String url, Map<String, String> headers) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        String respEntity = null;
        for (int i = 0; i < 2; i++) {
            //设置请求头
            HttpGet get = new HttpGet(url);
            headers.put(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            for (String key : headers.keySet()) {
                get.setHeader(key, headers.get(key));
            }
            response = httpClient.execute(get);
            respEntity = EntityUtils.toString(response.getEntity());
            //状态码50X或者超时则返回
            if (!(response.getStatusLine().getStatusCode() >= 500 && response.getStatusLine().getStatusCode() < 600) && (response.getStatusLine().getStatusCode() != 408)) {
                break;
            }
            if (i == 0) {
                Thread.sleep(1000);
            }
        }
        //关闭连接
        httpClient.close();
        response.close();
        return respEntity;
    }

    public static String patch(String url, Map<String, String> headers, String body) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        String respEntity = null;
        for (int i = 0; i < 2; i++) {
            //设置请求头
            HttpPatch patch = new HttpPatch(url);
            headers.put(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            for (String key : headers.keySet()) {
                patch.setHeader(key, headers.get(key));
            }
            //2.StringEntity 字符串参数
            if (StringUtils.isNotBlank(body)) {
                HttpEntity entity = new StringEntity(body, "UTF-8");
                patch.setEntity(entity);
            }
            response = httpClient.execute(patch);
            respEntity = EntityUtils.toString(response.getEntity());
            //状态码50X或者超时则返回
            if (!(response.getStatusLine().getStatusCode() >= 500 && response.getStatusLine().getStatusCode() < 600) && (response.getStatusLine().getStatusCode() != 408)) {
                break;
            }
            if (i == 0) {
                Thread.sleep(1000);
            }
        }

        //关闭连接
        httpClient.close();
        response.close();
        return respEntity;
    }

    /**
     * 支持 Delete 带Body Json
     *
     * @param url
     * @param headers
     * @param body
     * @return
     * @throws Exception
     */
    public static String delete(String url, Map<String, String> headers, String body) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //设置请求头
        HttpDeleteWithBody delete = new HttpDeleteWithBody(url);
        headers.put(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        for (String key : headers.keySet()) {
            delete.setHeader(key, headers.get(key));
        }
        //设置请求体
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("key", "value"));
        HttpEntity urlEncodedFormEntity = new UrlEncodedFormEntity(pairs);
        //2.StringEntity 字符串参数
        if (StringUtils.isNotBlank(body)) {
            HttpEntity entity = new StringEntity(body, "UTF-8");
            delete.setEntity(entity);
        }
        CloseableHttpResponse response = httpClient.execute(delete);
        String respEntity = EntityUtils.toString(response.getEntity());
        //关闭连接
        httpClient.close();
        response.close();
        return respEntity;
    }

}
