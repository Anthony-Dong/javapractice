package com.javase.Keyword.multiple_extend_package;

/**
 * Java5.0放宽了这一限制，
 * 只要子类方法与超类方法具有相同的方法签名，或者子类方法的返回值是超类方法的子类型，就可以覆盖。
 * 协变返回
 */
public class CovarianReturn {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        Mill m=new Mill();
        Grain g=m.process();
        System.out.println(g);
        m=new WheatMill();
        g=m.process();
        System.out.println(g);
    }
 
}
class Grain{
    public String toString(){
        return "Grain";
    }
}
class Wheat extends Grain{
    public String toString(){
        return "wheat";
    }
}
class Mill{
    Grain process(){
        return new Grain();
    }
}
class WheatMill extends Mill{

    /**
     * 只要子类方法与超类方法具有相同的方法签名
     * 子类方法的返回值是超类方法的子类型，就可以覆盖。
     * @return
     */
    @Override
    Wheat process(){
        return new Wheat();
    }
}