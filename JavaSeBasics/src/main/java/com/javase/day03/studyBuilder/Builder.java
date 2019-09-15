package com.javase.day03.studyBuilder;



/**
 * ClassName:Builder
 * Package:com.javase.day03
 * Description:
 *
 * @date:2019/7/1 20:18
 * @author: 574986060@qq.com
 */

public class Builder {
    public int  b=0;

    IService creat(){
        if (b == 1) {
            b++;
            return this.creat();
        }
        return null;
    }
}
