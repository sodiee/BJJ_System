package Storage;

import Application.Model.Fighter;
import Application.Model.JiuClass;

import java.util.ArrayList;

public class Storage {

    private static Storage uniqueInstance;
    static ArrayList<JiuClass> jiuClasses = new ArrayList<>();

    static ArrayList<Fighter> fighters = new ArrayList<>();

    //__________________________________________________________________________________________________________________________

    private Storage() {}

    //__________________________________________________________________________________________________________________________

    public static Storage getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Storage();
        }
            return uniqueInstance;
    }

    //__________________________________________________________________________________________________________________________

    public void addJiuClass(JiuClass jiuClass) {
        jiuClasses.add(jiuClass);
    }

    public ArrayList<JiuClass> getJiuClasses() {
        return jiuClasses;
    }

    //__________________________________________________________________________________________________________________________



    //__________________________________________________________________________________________________________________________

    public void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    public ArrayList<Fighter> getFighters() {
        return fighters;
    }

    //__________________________________________________________________________________________________________________________
}
