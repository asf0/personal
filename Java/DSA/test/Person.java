package test;
class Person {
    String name;
    String personality;
    boolean isSitting;
    Robot robotOwned;

    Person(String name, String personality, boolean isSitting) {
        this.name = name;
        this.personality = personality;
        this.isSitting = isSitting;
    }

    void sitDown() {
        isSitting = true;
    }
    void standUp() {
        isSitting = false;
    }

}
