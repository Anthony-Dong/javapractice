package com.javase.lombox.study;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * ClassName:XiaomiTv
 * Package:com.javase.lombox.study
 * Description:
 *
 * @date:2019/8/16 0:32
 * @author: 574986060@qq.com
 */
@Data

//@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class XiaomiTv extends TV {
    private Long price;

    public XiaomiTv(String name, Long price) {
        super(name);
        this.price = price;
    }

    public XiaomiTv(Long price) {
        this.price = price;
    }
}
