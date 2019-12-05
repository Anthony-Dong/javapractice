package com.javase.annotation_test;


import java.lang.annotation.Annotation;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;
@IsInheritedAnnotation
public class MyInheritedClassTest {
 


    public static void main(String[] args) {
        Annotation[] annotations = MyInheritedClass.class.getAnnotations();
        assertTrue("", Arrays.stream(annotations).anyMatch(l -> l.annotationType().equals(IsInheritedAnnotation.class)));
        assertTrue("", Arrays.stream(annotations).noneMatch(l -> l.annotationType().equals(NoInherritedAnnotation.class)));
    }
}