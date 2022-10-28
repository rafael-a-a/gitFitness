import java.util.Scanner;
public class User {
    public String name, email, password, phone, gender;
    public int age;
    public double weight, height, bodyFat, imcValue;
    public WorkoutItem[] woItem;
    public Workout[] Wo;

    public void login(){
        Scanner in = new Scanner(System.in);
        System.out.println("Insert Name:");
        name = in.nextLine();
        System.out.println("Insert Email:");
        email = in.nextLine();
        System.out.println("Insert Password:");
        password = in.nextLine();
        System.out.println("Insert Phone Number:");
        phone = in.nextLine();
    }
}