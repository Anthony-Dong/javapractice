package com.javase.generic;

import java.util.ArrayList;
import java.util.List;

public class Test<T extends Fruit> {
 
  private static void test01() {
    Test<Fruit> t1 = new Test<Fruit>();
    Test<Apple> t2 = new Test<Apple>();
    Test<Pear> t3 = new Test<Pear>();
  }
 
  private static void test02(List<? extends Fruit> list) {
 
  }
 
  private static void test03(List<? super Apple> list) {
 
  }
 
  public static void main(String[] args) {




    // 调用test02(),测试 extends  <= Fruit
    test02(new ArrayList<>());
    test02(new ArrayList<Apple>());
    test02(new ArrayList<ReadApple>());


//      Object 不是 Fruit 的子类 ，编译不通过
    
//     调用test03() ,测试super >= apple      ReadApple < apple,所以不能放入
    test03(new ArrayList<Apple>());
    test03(new ArrayList<Fruit>());
//    test03(new ArrayList<ReadApple>());
  }
 
}
 
class Fruit {
 
}
 
class Apple extends Fruit {
 
}
 
class Pear extends Fruit {
 
}
 
class ReadApple extends Apple {
 
}