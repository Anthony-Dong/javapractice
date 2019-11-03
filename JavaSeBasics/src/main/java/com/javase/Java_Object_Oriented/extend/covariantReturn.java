package com.javase.Java_Object_Oriented.extend;

public class covariantReturn {

    public static void main(String[] args) {

        MilK milK = new MilK();

        System.out.println("milK.process() = " + milK.process());

        WheatMilK wheatMilK = new WheatMilK();

        System.out.println("wheatMilK.process() = " + wheatMilK.process());

    }
 
}

class Grandparent{
    public String toString(){
        return "Grandparent";
    }
}
class Parent extends Grandparent{
    public String toString(){
        return "Parent";
    }
}


class MilK{
    Grandparent process(){
        return new Grandparent();
    }
}

class WheatMilK extends MilK{

    /**
     * 只要子类方法与超类方法具有相同的方法签名
     * 子类方法的返回值是超类方法的子类型，就可以覆盖。
     * @return
     */
    @Override
    Parent process(){
        return new Parent();
    }
}