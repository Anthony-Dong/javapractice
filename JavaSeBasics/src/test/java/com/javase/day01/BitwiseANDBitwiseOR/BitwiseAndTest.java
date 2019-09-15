package com.javase.day01.BitwiseANDBitwiseOR;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName:BitwiseAndTest
 * Package:com.javase.day01.BitwiseANDBitwiseOR
 * Description:
 * 。实现高质量的 。实现高质量的 。实现高质量的 equals equalsequalsequals方法的诀窍包括：
 * 方法的诀窍包括： 方法的诀窍包括： 方法的诀窍包括：
 * 1. 1. 使用 == 操作符检查
 *
 * 2. 2. 使用 instanceof 参数是否为正确的类型
 * 3. 3. 对于类中的关键属性，检查参数传入象 检查参数传入象 的属性是否与之相匹配；
 * 4. 4. 编写完 编写完 equals equals equals equals 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 方法后，问自己它是否满足对称性、传递一致； 5. 5. 5. 重写 equals equals equals equals 时 总是要重写 hashCodehashCodehashCode hashCode hashCode；6. 6. 不要将 不要将 不要将 equals equals equals equals 方法参数中的 Object Object Object 对象替换为其他的类型，在重写时不要忘掉 对象替换为其他的类型，在重写时不要忘掉 对象替换为其他的类型，在重写时不要忘掉 @Override @Override @Override @Override @Override @Override @Override @Override @Override 注解。 注
 *
 * @date:2019/6/28 9:56
 * @author: 574986060@qq.com
 */

public class BitwiseAndTest {

    @Test
    public void test01() {

        String s1 = null;

//        正常写法
        if (s1 != null && !s1.equals("")) {
            System.out.println("success");
        }

//       会出现空指针异常
/*        if (!s1.equals("") && s1 != null) {
            System.out.println("success");
        }*/


    }
}