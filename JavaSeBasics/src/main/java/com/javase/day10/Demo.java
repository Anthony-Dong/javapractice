package com.javase.day10;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * ClassName:Demo
 * Package:com.javase.day10
 * Description:
 *
 * @date:2019/7/25 12:55
 * @author: 574986060@qq.com
 */

public class Demo {

    public static void main(String[] args) {
        System.out.println(2 >> 1);
    }


    public static Integer valueOf(int i) {
        if (i >= Demo.IntegerCache.low && i <= Demo.IntegerCache.high)
            return Demo.IntegerCache.cache[i + (-Demo.IntegerCache.low)];
        return new Integer(i);
    }


    private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final Integer cache[];

        static {
            // high value may be configured by property
            int h = 127;
            String integerCacheHighPropValue =
                    sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = parseInt(integerCacheHighPropValue);
                    i = Math.max(i, 127);
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
                } catch( NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;

            cache = new Integer[(high - low) + 1];
            int j = low;
            for(int k = 0; k < cache.length; k++)
                cache[k] = new Integer(j++);

            // range [-128, 127] must be interned (JLS7 5.1.7)
//            assert Integer.IntegerCache.high >= 127;
        }

        private IntegerCache() {}
    }

}
