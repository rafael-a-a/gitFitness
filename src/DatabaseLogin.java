import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class DatabaseLogin {
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
                    + "VALUES ('" + client.name + "', '" + client.email + "', '" + client.password + "', '" +  client.phone + "')";

            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Entry inserted successfully.");
    }

    public void delID(int ID){
        /*
         * NAME: delID
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

    public void checkLogin(String email, String posPassword){
        /*
         * NAME: checkPassword
         * RETURNS: none
         * PARAMETERS:
         * * email - user email, must be verified (it cannot exist already)
         * * posPassword - user password, must be compared with password in database
         */
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Search email in database
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * from loseit.login where email = '"+ email +"';" );

            // The condition !rs.next() must be revised, the intent was to check the non-existence of the email given
            //if(!rs.next())
            //    System.out.println("Email does not exist. Are you signed in?");

            while (rs.next()) {
                int id = rs.getInt("id");
                String realPassword = rs.getString("password");
                if(Objects.equals(realPassword, posPassword)){
                    System.out.println("Login successful with password: " + realPassword + " user ID : " + id);
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
        }
    }
}
