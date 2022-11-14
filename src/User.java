import java.util.Scanner;
public class User {
    public String name, email, password, phone, gender;
    public int age;
    public double weight, height, bodyFat, imcValue;
    public WorkoutItem[] woItem;
    public Workout[] Wo;

    //User constructor for Create Account
    User(String name, String email, String password, String phone){
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        int hashed = password.hashCode();
        String passwordH = Integer.toString(hashed);
        return passwordH;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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