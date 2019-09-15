package com.javase.day10;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.javase.day10.constant.Constant.*;

/**
 * ClassName:DoStaticConstant
 * Package:com.javase.day10
 * Description:
 *  静态导入  很强  必须是 静态变量
 * @date:2019/7/22 19:24
 * @author: 574986060@qq.com
 */

public class DoStaticConstant {

    public static void main(String[] args) {

       /* String s = CONSTANT;
        System.out.println(s);

        talk();*/


        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format1 = format.format(new Date());
        System.out.println(format1);

    }


}
