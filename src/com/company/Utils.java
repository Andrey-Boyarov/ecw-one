package com.company;

import java.lang.reflect.Field;

public class Utils {
    public static <T> Object deepClone(T obj){
        try {
            return (T)deepCloneUnhandled(obj);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static <T> Object deepCloneUnhandled(T obj) throws InstantiationException, IllegalAccessException {
        UtilsT<T> utils = new UtilsT<>();
        return utils.deepClone((Class<T>) obj.getClass(), obj);
    }
}
