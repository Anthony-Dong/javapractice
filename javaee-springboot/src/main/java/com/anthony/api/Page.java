package com.anthony.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页结果 ,统一的结果 不管你使用的插件是哪个
 *
 * @date:2019/9/20 22:09
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

@Data
@AllArgsConstructor
public class Page<T> implements Serializable {


    private static final long serialVersionUID = 8365280576021762056L;

    /**
     * 查询数据列表
     */
    private List<T> record = Collections.emptyList();
    /**
     * 总数
     */
    private long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    private long size = 10;
    /**
     * 当前页
     */
    private long current = 1;

}
