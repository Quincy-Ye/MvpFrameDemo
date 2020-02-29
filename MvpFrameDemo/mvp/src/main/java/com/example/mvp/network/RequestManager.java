package com.example.mvp.network;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.mvp.app.MyApp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Quincy
 * @Date 2020/2/1
 * @Description 用于管理网络请求
 */

public class RequestManager {
    private RequestQueue queue;
    private static volatile RequestManager instance;

    private RequestManager(){
        queue = Volley.newRequestQueue(MyApp.getInstance());
    }

    public static RequestManager getInstance(){
        if (instance ==null){
            synchronized (RequestManager.class){
                if (instance==null){
                    instance = new RequestManager();
                }
            }
        }
        return instance;
    }

    /**
     * 请求队列
     * @return
     */
    public RequestQueue getRequestQueue(){
        return queue;
    }

    /**
     *
     * @param url 请求的api
     * @param clazz 因为使用的是泛型，所以需要指定类型，通过参数指定
     * @param listener 监听回调
     * @param <T>
     *
     */
    public <T> void sendGet(String url,Class<T> clazz,final MyListener<T> listener){
        MyRequest<T> request = new MyRequest<>(url, clazz, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error.getMessage());
            }
        });
        addToRequestQueue(request);//添加到请求队列中
    }
    public <T> void sendPost(String url, Class<T> clazz, final HashMap<String, String> map, final MyListener<T> listener) {
        MyRequest<T> request = new MyRequest<T>(Request.Method.POST, url, clazz, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        addToRequestQueue(request);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
