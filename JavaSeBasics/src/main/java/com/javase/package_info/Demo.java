package com.javase.package_info;



/**
 * package_info的作用
 *
 * @date:2019/9/15 12:29
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {


    public static void main(String[] args) {
        Package p = Package.getPackage("com.javase.package_info");
        MyAnnotation annotation = p.getAnnotation(MyAnnotation.class);
        String value = annotation.value();
        System.out.println("value = " + value);
        System.out.println("p.getName() = " + p.getName());


        PackageInfo packageInfo = new PackageInfo();
        packageInfo.common();

        System.out.println("Constant.value = " + Constant.value);

        System.out.println("Enumeration.CONSTANT = " + Enumeration.CONSTANT);
    }
}
