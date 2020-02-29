package com.example.mvp.network;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * @author Quincy
 * @Date 2020/2/1
 * @Description
 * 重写 Request 类的 parseNetworkResponse() 和 ** deliverResponse()** 方法，
 * 前者用于解析请求到的响应（也就是返回数据），后者用于将响应传递给回调接口 mListener。
 * 解析时我们采用了 Gson，它会强制我们处理 UnsupportedEncodingException，
 * 最终返回的便是我们想要的 Java 对象

 */

public class MyRequest<T> extends Request<T> {

    private Gson mGSon;
    private Class<T> mClass;
    private Response.Listener<T> mListener;

    /**
     * 默认GET方法请求
     * @param url  请求的api
     * @param clazz 因为使用的是泛型，所以需要指定类型，通过参数指定
     * @param listener 成功回调
     * @param errorListener 失败回调
     */
    public MyRequest(String url,Class<T> clazz,
                     Response.Listener<T> listener,Response.ErrorListener errorListener){
        this(Request.Method.GET,url,clazz,listener,errorListener);
    }

    /**
     * @param method 指定请求方法 POST/GET
     */
    public MyRequest(int method, String url, Class<T> clazz,
                     Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mGSon = new Gson();
        mClass = clazz;
        mListener = listener;
    }

    /**
     *
     * @param response
     * @return
     */
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(mGSon.fromJson(json,mClass),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }

    }

    /**
     *
     * @param response
     */
    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }
}
