@MyAnnotation("测试一哈")
package com.javase.package_info;

class PackageInfo{
    public void common(){
        System.out.println("我在package-info内部");
    }
}

interface Constant{
    String value = "测试";
}

enum Enumeration{
    CONSTANT("CONSTANT");


    private String value;

    Enumeration(String value) {
        this.value = value;
    }
}
