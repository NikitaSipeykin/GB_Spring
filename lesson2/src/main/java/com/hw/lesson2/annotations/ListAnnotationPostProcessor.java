package com.hw.lesson2.annotations;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;


public class ListAnnotationPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();

        for (var field : declaredFields) {
            ListAnnotation annotation = field.getAnnotation(ListAnnotation.class);
            if (annotation != null) {

            }
        }

        return bean;
    }
}
