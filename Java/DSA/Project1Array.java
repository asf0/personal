
import java.util.Scanner;
public class Project1Array {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("How many days temperature?");
    int days = sc.nextInt();
    int[] temp = new int[days];
    int sum = 0;
    for (int i = 0; i < days; i++) {
      System.out.print("Day " + (i + 1) + "'s high temp: ");
      temp[i] = sc.nextInt();
      sum += temp[i];
    }
    sc.close();
    double avg = (double) sum / days;
    int count = 0;
    for (int i = 0; i < days; i++) {
      if (temp[i] > avg) {
        count++;
      }
    }
    System.out.println("Average = " + avg);
    System.out.println(count + " days above average");
  }
}
