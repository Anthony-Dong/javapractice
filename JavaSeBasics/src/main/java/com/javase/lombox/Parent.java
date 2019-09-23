package com.javase.lombox;

import lombok.*;


public class Parent {





  public static void main(String[] args) {
    Child build = Child.builder().a("testA").b("testB").build();


    System.out.println(build.hashCode());


    Child build1 = Child.builder().a("11").b("aaaaaa").build();


    Child build2 = Child.builder().b("1").build();

    System.out.println(build2);
    System.out.println(build1);
  }
}

@EqualsAndHashCode(callSuper = false)
@Data

@Builder
class Child extends Parent {

  private String b;

  private String a;


}