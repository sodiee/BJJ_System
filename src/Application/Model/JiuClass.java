package Application.Model;

public class JiuClass {
    private static int totalNumber;
    private int number;
    private int rating;
    private String gym;
    private Wear gear;
    private String topic;
    private Fighter fighter;


    public JiuClass(int number, int rating, String gym, Wear gear, String topic, Fighter fighter) {
        this.number = number;
        totalNumber++;
        this.rating = rating;
        this.gym = gym;
        this.gear = gear;
        this.topic = topic;
        this.fighter = fighter;
    }

    public int getTotalNumber() {
        return totalNumber;
    }
    public int getNumber() {
        return number;
    }

    public int getRating() {
        return rating;
    }

    public String getGym() {
        return gym;
    }

    public Wear getWear() {
        return gear;
    }

    public String getTopic() {
        return topic;
    }

    public String toString() {
        return number + " / " + totalNumber + " " + fighter.belt;
    }
}
