package com.jvm.heap_memory;

import java.util.ArrayList;

/**
 * TODO
 *
 * @date:2019/11/2 17:51
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestDumpOutOfMemory {


    public static void main(String[] args) {


        ArrayList<Object> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            // 创建一块 1M 大小的 空间
            list.add(new byte[3 * 1024 * 1024]);
        }

    }

}
