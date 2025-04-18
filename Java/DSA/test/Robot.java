package test;

class Robot {
    String name;
    String color;
    int weight;
    Robot lookingAt;

    Robot(String name, String color, int weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }
    void introduceSelf() {
        System.out.printf("My name is %s.\n", name);
    }
}
