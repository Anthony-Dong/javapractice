package com.javase.design_pattern.decorate;

/**
 * 超类  component 组件及时 把 公共的地方 提取出来
 *
 * @date:2019/9/7 17:56
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public abstract class Drink {

    private String desc;

    private float price;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    abstract float cost();
}
