package com.javase.day11.demo02;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Player
 * Package:com.javase.day11
 * Description:
 *
 * @date:2019/8/8 11:29
 * @author: 574986060@qq.com
 */

public class Player implements Serializable {

    private static final long serialVersionUID = -2655074090487140496L;
    private long playerId;

    private int age;


    private String name;

    private List<Integer> skills = new ArrayList<>();


    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", skills=" + skills +
                '}';
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getSkills() {
        return skills;
    }

    public void setSkills(List<Integer> skills) {
        this.skills = skills;
    }
}
