package test;

import java.awt.*;

public class main {
    public static void main(String[] args) {
        Robot r1 = new Robot("Tom", "blue", 200);
        Robot r2 = new Robot("Jerry", "red", 200);
        r1.introduceSelf();
        r2.introduceSelf();
        Person p1 = new Person("Alice", "agrssive", false);
        Person p2 = new Person("Bob", "talkative", true);
        p1.robotOwned = r2;
        p2.robotOwned = r1;
        p1.robotOwned.introduceSelf();
        r1.lookingAt = r2;
        r2.lookingAt = r1;
        r1.lookingAt.introduceSelf();
        r2.lookingAt.introduceSelf();
    }
}
