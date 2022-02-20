package com.company;

import java.lang.reflect.Field;

public class UtilsT<T> {
    public Object deepClone(Class<T> T, T obj) throws InstantiationException, IllegalAccessException {
        T result = (T) obj.getClass().newInstance(); //throws exception here, found no solvation so far
        System.out.println("Start");

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            if (field.getType().isPrimitive()) {
                setPrimitive(field, obj, result);
            } else {
                setComplex(field, obj, result);
            }
        }


        for (Field field : result.getClass().getDeclaredFields()) {
            System.out.println(field.getType() + " " + field.get(result));
        }

        System.out.println("End");

        return obj;
    }

    private void setPrimitive(Field field, T source, T obj) throws IllegalAccessException {
        field.set(obj, field.get(source));
    }

    private void setComplex(Field field, T source, T obj) throws IllegalAccessException {
        field.set(obj, field.get(Utils.deepClone(source)));
    }
}
