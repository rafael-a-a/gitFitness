import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

public class Database {
    public Connection c;
    public Statement stmt;
    public ResultSet rs;

    public void signIn(User client){
        /*
         * NAME: insertEntry
         * RETURNS: none
         * PARAMETERS:
         * * client - insert data from the client in the login table
         */
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Insert data gathered from the console in client1
            stmt = c.createStatement();
            String sql = "INSERT INTO loseit.login (NAME,EMAIL,PASSWORD,PHONEN) "
                    + "VALUES ('" + client.getName() + "', '" + client.getEmail() + "', '" + client.getPassword() + "', '" +  client.getPhone() + "')";

            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Entry inserted successfully.");
    }

    public void adminDelID(int ID){
        /*
         * NAME: adminDelID
         * RETURNS: none
         * PARAMETERS:
         * * ID - ID from client to delete (deletes all data in login table)
         */
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Delete data from user with ID received in argument
            stmt = c.createStatement();
            String sql1 = "DELETE from loseit.login where ID = " + ID + ";";
            stmt.executeUpdate(sql1);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Deletion ID = " + ID +" successfully.");
    }

    public boolean checkLogin(String email, String posPassword, String phonen){
        /*
         * NAME: checkLogin
         * RETURNS: none
         * PARAMETERS:
         * * email - user email, must be verified (it cannot exist already)
         * * posPassword - user password, must be compared with password in database
         * * phonen - user phone number, can also be used to login
         */
        int flagF = 0; // Flag to check if email/phone number introduced exist in the database
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Search email in database
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT password, id from loseit.login where email = '"+ email +"' OR phonen = '"+ phonen +"';");

            while (rs.next()) {
                int id = rs.getInt("id");
                String realPassword = rs.getString("password");

                if(Objects.equals(realPassword, posPassword)){
                    System.out.println("Login successful with password: " + realPassword + " user ID : " + id);
                    rs.close();
                    stmt.close();
                    c.close();
                    return true;
                }
                else{
                    System.out.println("Invalid password.");
                }
                flagF = 1;
            }
            if(flagF == 0){  // If there is no rs.next, email/phone number don't exist in the database
                System.out.println("Email and phone number do not exist. Are you signed in?");
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return false; // if function reaches this point, then login was not successful
    }

    public boolean changePassword(String email, String posPassword, String phonen)
    {
        /*
         * NAME: changePassword
         * RETURNS: none
         * PARAMETERS:
         * * email - user email, must be verified (it cannot exist already)
         * * posPassword - user password, must be compared with password in database
         * * phonen - user phone number, can also be used to login
         */

        Scanner myObj = new Scanner(System.in);
        String findHashed;

        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Search email in database
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT password, id from loseit.login where email = '"+ email +"' OR phonen = '"+ phonen +"';");

            while (rs.next()) {
                int id = rs.getInt("id");
                String realPassword = rs.getString("password");

                findHashed = Integer.toString(posPassword.hashCode());

                if(Objects.equals(realPassword, findHashed)){
                    System.out.println("Introduza a nova password");
                    String newPass = Integer.toString(myObj.nextLine().hashCode());

                    String sql = "UPDATE loseit.login SET password ='"+newPass+"' where email = '"+email+"';";
                    stmt.executeUpdate(sql);

                    rs.close();
                    stmt.close();
                    c.close();
                    return true;
                }
                else{
                    System.out.println("Invalid password.");
                }
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
            System.out.println();
        }
        return false;
    }
}
