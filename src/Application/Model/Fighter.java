package Application.Model;

public class Fighter {
    Belt belt;
    int age;
    String name;

    public Fighter(Belt belt, int age, String name) {
        this.belt = belt;
        this.age = age;
        this.name = name;
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
            case WHITE -> this.belt = Belt.BLUE;
            case BLUE -> this.belt = Belt.PURPLE;
            case PURPLE -> this.belt = Belt.BROWN;
            case BROWN -> this.belt = Belt.BLACK;
        }
        //TODO: Tilføj striber
    }

    @Override
    public String toString() {
        return name;
    }
}
