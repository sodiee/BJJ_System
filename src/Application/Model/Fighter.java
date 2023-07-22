package Application.Model;

import java.util.ArrayList;

public class Fighter {

    private ArrayList<JiuClass> jiuClasses;
    private Belt belt;
    private int age;
    private String name;

    public Fighter(Belt belt, int age, String name) {
        this.jiuClasses = new ArrayList<>();
        this.belt = belt;
        this.age = age;
        this.name = name;
    }

    public void addClass(JiuClass jiuClass) {
        jiuClasses.add(jiuClass);
    }

    public ArrayList<JiuClass> getFighterJiuClasses() {
        return jiuClasses;
    }

    public int getTotalNumberOfClasses() {
        return jiuClasses.size();
    }

    public double getTotalDuration() {
        double total = 0;
        for (int i = 0; i < jiuClasses.size(); i++) {
            total += jiuClasses.get(i).getDuration();
        }
        return total;
    }

    public Belt getBelt() {
        return belt;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void promoteToNewBelt() {
        switch (belt) {
            case WHITE -> this.belt = Belt.WHITE1;
            case WHITE1 -> this.belt = Belt.WHITE2;
            case WHITE2 -> this.belt = Belt.WHITE3;
            case WHITE3 -> this.belt = Belt.WHITE4;
            case WHITE4 -> this.belt = Belt.BLUE;
            case BLUE -> this.belt = Belt.BLUE1;
            case BLUE1 -> this.belt = Belt.BLUE2;
            case BLUE2 -> this.belt = Belt.BLUE3;
            case BLUE3 -> this.belt = Belt.BLUE4;
            case BLUE4 -> this.belt = Belt.PURPLE;
            case PURPLE -> this.belt = Belt.PURPLE1;
            case PURPLE1 -> this.belt = Belt.PURPLE2;
            case PURPLE2 -> this.belt = Belt.PURPLE3;
            case PURPLE3 -> this.belt = Belt.PURPLE4;
            case PURPLE4 -> this.belt = Belt.BROWN;
            case BROWN -> this.belt = Belt.BROWN1;
            case BROWN1 -> this.belt = Belt.BROWN2;
            case BROWN2 -> this.belt = Belt.BROWN3;
            case BROWN3 -> this.belt = Belt.BROWN4;
            case BROWN4 -> this.belt = Belt.BLACK;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
