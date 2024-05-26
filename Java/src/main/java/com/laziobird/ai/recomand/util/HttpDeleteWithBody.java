package com.laziobird.ai.recomand.util;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 蒋志伟
 * @Date: 2023/12/20/16:57
 * @Description:
 * HttpClient中DELETE请求，是没有办法带参数的。
 * 因为setEntity()方法是抽象类HttpEntityEnclosingRequestBase类里的方法，
 * HttpPost继承了该类，而HttpDelete类继承的是HttpRequestBase类
 */

public class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "DELETE";

    /**
     * 获取方法（必须重载）
     *
     * @return
     */
    @Override
    public String getMethod() {
        return METHOD_NAME;
    }

    public HttpDeleteWithBody(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    public HttpDeleteWithBody(final URI uri) {
        super();
        setURI(uri);
    }

    public HttpDeleteWithBody() {
        super();
    }

}
