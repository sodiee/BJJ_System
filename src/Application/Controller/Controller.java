package Application.Controller;

import Application.Model.Belt;
import Application.Model.Class;
import Application.Model.Fighter;
import Application.Model.JiuClass;
import Application.Model.Wear;
import Storage.Storage;

import java.util.ArrayList;

public class Controller {
    private Storage storage;

    //__________________________________________________________________________________________________________________________

    public Controller() {
        this.storage = this.storage.getUniqueInstance();
    }

    //__________________________________________________________________________________________________________________________


    //__________________________________________________________________________________________________________________________

    public JiuClass createJiuClass(int number, int rating, String gym, Wear gear, String topic, Belt belt, Fighter fighter, Class typeOfClass) {
        JiuClass jiuClass = new JiuClass(number, rating, gym, gear, topic, fighter, typeOfClass);
        storage.addJiuClass(jiuClass);
        return jiuClass;
    }

    public ArrayList<JiuClass> getJiuClasses() {
        return storage.getJiuClasses();
    }

    //__________________________________________________________________________________________________________________________

    public Fighter createFighter(Belt belt, int age, String name) {
        Fighter fighter = new Fighter(belt, age, name);
        storage.addFighter(fighter);
        return fighter;
    }

    public ArrayList<Fighter> getFighters() {
        return storage.getFighters();
    }

    public void promoteJiuBelt(Fighter fighter) {
        fighter.promoteToNewBelt();
    }

    //__________________________________________________________________________________________________________________________

    public void initStorage() {
        Fighter fighter = createFighter(Belt.WHITE, 22, "Mathias Sode-Carlsen");
        createJiuClass(1, 7, "The Grappling Lab", Wear.NOGI, "Can't remember", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(2, 7, "The Grappling Lab", Wear.NOGI, "Open guard", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(3, 7, "The Grappling Lab", Wear.NOGI, "Can't remember", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(4, 8, "The Grappling Lab", Wear.NOGI, "Turtle", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(5, 7, "The Grappling Lab", Wear.NOGI, "Can't remember", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(6, 7, "The Grappling Lab", Wear.NOGI, "Can't remember", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(7, 7, "The Grappling Lab", Wear.NOGI, "Can't remember", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(8, 7, "The Grappling Lab", Wear.NOGI, "Can't remember", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(9, 7, "The Grappling Lab", Wear.NOGI, "Standing takedown", Belt.WHITE, fighter, Class.BASICS);
        createJiuClass(10, 8, "The Grappling Lab", Wear.GI, "Sprawling, single leg lock, double leg lock", Belt.WHITE, fighter, Class.BASICS);
    }
}

