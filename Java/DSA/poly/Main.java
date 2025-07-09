package poly;

public class Main {
    public static void main(String[] args) {
        Camera camera = new Camera();
        camera.takePicture("landscape");
        camera.takePicture(10);
        camera.takePicture("portrait", 10);
    }
}
