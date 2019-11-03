package com.jvm.trace_class_load;

/**
 * TODO
 *
 * @date:2019/11/2 14:15
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TraceClassLoading {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.jvm.trace_class_load.C");
    }
}


interface InterP{

}
interface InterC extends InterP{

}

class P implements  InterC{

}

class C extends P{

}