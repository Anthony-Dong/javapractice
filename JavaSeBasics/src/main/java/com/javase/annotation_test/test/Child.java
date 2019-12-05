package com.javase.annotation_test.test;

import java.lang.annotation.Annotation;

/**
 * TODO
 *
 * @date:2019/11/9 16:27
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public interface Child extends Annotation {

    public abstract String value();


    public abstract int get();

}
