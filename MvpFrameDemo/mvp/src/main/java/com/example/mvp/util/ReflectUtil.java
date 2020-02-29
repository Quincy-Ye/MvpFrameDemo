package com.example.mvp.util;

import java.lang.reflect.ParameterizedType;

/**
 * @author Quincy
 * @Date 2020/2/16
 * @Description 用到了反射技术 TODO 好处是什么？
 */

public class ReflectUtil {
    public static <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType)
                    (o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
