package com.javase.annotation_test.test;

import java.lang.annotation.Annotation;

/**
 * TODO
 *
 * @date:2019/11/9 16:28
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Parent implements Child,Child2{


    @Override
    public String value() {
        return null;
    }

    @Override
    public int get() {
        return 0;
    }

    /**
     * Returns the annotation type of this annotation.
     *
     * @return the annotation type of this annotation
     */
    @Override
    public Class<? extends Annotation> annotationType() {
        return Child.class;
    }
}
