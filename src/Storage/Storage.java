package Storage;

import Application.Model.Fighter;
import Application.Model.JiuClass;

import java.util.ArrayList;

public class Storage {
    static ArrayList<JiuClass> jiuClasses = new ArrayList<>();

    static ArrayList<Fighter> fighters = new ArrayList<>();

//__________________________________________________________________________________________________________________________

    public void addJiuClass(JiuClass jiuClass) {
        jiuClasses.add(jiuClass);
    }

    public ArrayList<JiuClass> getJiuClasses() {
        return jiuClasses;
    }

    //__________________________________________________________________________________________________________________________

    public void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    public ArrayList<Fighter> getFighters() {
        return fighters;
    }

    //__________________________________________________________________________________________________________________________
}
