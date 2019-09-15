package com.javase.day08.stringUtils;

import com.sun.scenario.effect.impl.prism.ps.PPSBlend_ADDPeer;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:DoStringUtils
 * Package:com.javase.day08.stringUtils
 * Description:
 *
 * @date:2019/7/15 16:04
 * @author: 574986060@qq.com
 */

public class DoStringUtils {

    @Test
    public void test01() {
        String img = "http://image.leyou.com/images/12/15/1524297315534.jpg,http://image.leyou.com/images/9/5/1524297314398.jpg";
        String s = StringUtils.substringBefore(img, ",");
        System.out.println(s);
    }

    @Test
    public void test(){
        Person person = null;
        boolean blank = org.springframework.util.StringUtils.isEmpty(person);

        System.out.println(blank);
    }
    public static void main(String[] args) {
        Map<String, Object> skusInfo = new HashMap<>();
        try {
            skusInfo.put("1", 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(skusInfo.get("1"));
    }
    @Test
    public void test03(){
        int sum =0;
        for (int i=1;i<100;i++){
            method();
            sum++;
        }
        System.out.println(sum);
    }

    public void method(){
        try {
            int i = 1 / 0;
        } catch (Exception e) {
           throw  new RuntimeException("-------");
        }finally {
            System.out.println("-------------->");
        }
    }

}
