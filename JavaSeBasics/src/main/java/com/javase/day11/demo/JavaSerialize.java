package com.javase.day11.demo;



import java.io.*;
import java.util.Arrays;

/**
 * ClassName:JavaSerialize
 * Package:com.javase.day11.com.demo
 * Description:
 *
 * @date:2019/8/8 11:30
 * @author: 574986060@qq.com
 */

public class JavaSerialize {

    public static void main(String[] args) {
        Player player = new Player();
        player.setAge(10);
        player.setName("tom");
        player.setPlayerId(1000);
        player.setSkills(Arrays.asList(1, 2));
        try {
            byte[] bytes = toBytes(player);
            com.javase.day11.demo02.Player  o = (com.javase.day11.demo02.Player ) toPlay(bytes);
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }





    }
    public static byte[] toBytes(Object out) {
        try(ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(out);
            byte[] bs = byteArrayOutputStream.toByteArray();
            return bs;
        } catch (IOException e) {
            throw new RuntimeException("异常");
        }
    }

    public static Object toPlay(byte[] bs) {
        try (ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bs);
             ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream)
        ){
            return objectInputStream.readObject();
        } catch (IOException |ClassNotFoundException e) {
            throw new RuntimeException("异常");
        }
    }
}
