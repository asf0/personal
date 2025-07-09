package poly;

public class Camera {
    public void takePicture(String mode){
        System.out.println("Taking picture in " + mode + " mode.");
    }
    public void takePicture(int resolution){
        System.out.println("Taking picture in " + resolution + "p resolution.");
    }
    public void takePicture(String mode, int resolution){
        System.out.println("Taking picture in " + mode + " mode with " + resolution + "p resolution.");
    }
}
