package com.javase.day11;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.*;

import static com.javase.day11.demo.JavaSerialize.toBytes;
import static com.javase.day11.demo.JavaSerialize.toPlay;

/**
 * ClassName:Demo11
 * Package:com.javase.day11
 * Description:
 *
 * @date:2019/8/8 12:24
 * @author: 574986060@qq.com
 */

public class DemoJNDI {
    public static void main(String[] args) throws Exception {
/*
        try {
            Context context = new InitialContext();
//            Object lookup = context.lookup();

        } catch (NamingException e) {
            e.printStackTrace();

        }*/
/*
        Object o1 = 1;

        byte[] bytes = toBytes(o1);

        Object o = toPlay(bytes);
        System.out.println(o);
*/

        Object o1 = 1;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);

        oos.writeObject(o1);

        byte[] bytes = byteArrayOutputStream.toByteArray();

        System.out.println(bytes);




            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            Object o = objectInputStream.readObject();

            System.out.println(o);
            Integer i = (Integer) o;

            Integer i2 = 1;


            System.out.println(i.equals(i2));
            System.out.println(o);


//        Integer integer = 1;
//
//        Integer integer1 = (Integer) o;
//
//        System.out.println(integer.equals(integer1));
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
