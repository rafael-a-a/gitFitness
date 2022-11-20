import org.postgresql.gss.GSSOutputStream;
import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Database {
    public Connection c;
    public Statement stmt;
    public ResultSet rs;

    /* este método ainda nao pode ser testado através interface gráfica pelo que tem de estar comentado para fazer
    o push e o commit sem haver erros. foi no entanto testado através da consola e está a funcionar.
     */
    /*
    public User getUserData(String email){
        /**
         * NAME: getUserData
         * RETURNS: User instance with all database information with the email provided
         * PARAMETERS:
         * * email - User's email which information must be filled
         *//*
        User userReturn = new User();
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Select exercises with input targetMuscle and difficulty
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * from loseit.userlist where email = '"+ email +"';");

            while(rs.next()) {
                userReturn.email = rs.getString("email");
                userReturn.name = rs.getString("name");
                userReturn.phone = rs.getString("phonen");
                userReturn.birthDate = rs.getString("bdate");
                userReturn.weight = rs.getDouble("currweight");
                userReturn.height = rs.getDouble("currheight");
                userReturn.imcValue = rs.getDouble("imc");
                userReturn.gender = rs.getString("gender");
                userReturn.bodyFat = rs.getDouble("bodyfat");
                userReturn.id = rs.getString("id");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return userReturn;
    } */
    public void signUp(User client){
        /**
         * NAME: signUp
         * RETURNS: void
         * PARAMETERS:
         * * client - Fill the database with the client's information
         */
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Insert data gathered from the console    in client1
            stmt = c.createStatement();
            String sql = "INSERT INTO loseit.userlist (NAME,EMAIL,PASSHASH,PHONEN) "
                    + "VALUES ('" + client.getName() + "', '" + client.getEmail() + "', '" + client.getPassword() + "', '" +  client.getPhone() + "')";

            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Entry inserted successfully.");
    }

    public void delID(String ID){
        /**
         * NAME: delID
         * RETURNS: void
         * PARAMETERS:
         * * ID - ID from client to delete (deletes all data in the database)
         */
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Delete data from user with ID received in argument
            stmt = c.createStatement();
            String sql1 = "DELETE from loseit.userlist where ID = '" + ID + "';";
            stmt.executeUpdate(sql1);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Deletion ID = " + ID +" successfully.");
    }



    public boolean checkLogin(String email, String posPassword, String phonen){
        /**
         * NAME: checkLogin
         * RETURNS: true if successful, false if unsuccessful
         * PARAMETERS:
         * * email - user email, can be used to log in
         * * posPassword - user password, must be compared with password in database
         * * phonen - user phone number, can also be used to log in
         */
        int flagF = 0; // flag to check if email/phone number introduced exist in the database
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Search email in database
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT passhash, id from loseit.userlist where email = '"+ email +"' OR phonen = '"+ phonen +"';" );

            while (rs.next()) {
                int id = rs.getInt("id");
                String realPassword = rs.getString("passhash");
                String findHashed = Integer.toString(posPassword.hashCode());

                if(Objects.equals(realPassword, findHashed)){
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

            if(flagF == 0){  // if there is no rs.next, email/phone number don't exist in the database
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
        return false;
    }

    public boolean changePassword(String id, String oldPassword, String newPassword)
    {
        /**
         * NAME: changePassword
         * RETURNS: true if successful, false if unsuccessful
         * PARAMETERS:
         * * id - the id of the client whose password is being changed
         * * oldPassword - user's old password, must be compared with current password in database
         * * newPassword - user's new password, must be updated if old password matches the current one in database
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
            rs = stmt.executeQuery("SELECT passhash from loseit.userlist where id = '"+ id +"';");

            while (rs.next()){
                String realPassword = rs.getString("passhash");
                findHashed = Integer.toString(oldPassword.hashCode());

                if(Objects.equals(realPassword, findHashed)){
                    String newPass = Integer.toString(newPassword.hashCode());
                    String sql = "UPDATE loseit.userlist SET passhash ='"+ newPass +"' where id = '"+ id +"';";
                    stmt.executeUpdate(sql);
                    rs.close();
                    stmt.close();
                    c.close();
                    System.out.println("Password change completed!");
                    return true;
                }
                else{
                    System.out.println("Old password does not match!");
                    return false;
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

    public boolean changeName(String newName, String id)
    {
        /**
         * NAME: changeName
         * RETURNS: true if successful, false if unsuccessful
         * PARAMETERS:
         * * newName - the new name of the user
         * * id - the id of the client whose name is being changed
         */
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Search email in database
            stmt = c.createStatement();
            String sql = "UPDATE loseit.userlist SET name ='"+ newName +"' where id = '"+ id +"';";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
            System.out.println();
        }
        return false;
    }

    public boolean changeWeight(double newWeight, String id)
    {
        /**
         * NAME: changeWeight
         * RETURNS: true if successful, false if unsuccessful
         * PARAMETERS:
         * * neWeight- the new weight of the user
         * * id - the id of the client whose weight is being changed
         */
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Search email in database
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT currheight from loseit.userlist where id = '"+ id + "';");
            while(rs.next()){
                double currHeight = rs.getDouble("currheight");
                double newImc = newWeight/Math.pow(currHeight, 2);
                changeIMC(newImc, id);
            }

            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            stmt = c.createStatement();
            String sql = "UPDATE loseit.userlist SET currweight ='"+ newWeight +"' where id = '"+ id +"';";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
            System.out.println();
        }
        return false;
    }

    public boolean changeHeight(double newHeight, String id)
    {
        /**
         * NAME: changeHeight
         * RETURNS: true if successful, false if unsuccessful
         * PARAMETERS:
         * * newName - the new height of the user
         * * id - the id of the client whose height is being changed
         */
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Search email in database
            stmt = c.createStatement();

            rs = stmt.executeQuery("SELECT currweight from loseit.userlist where id = '"+ id + "';");
            while(rs.next()){
                double currWeight = rs.getDouble("currweight");
                double newImc = currWeight/Math.pow(newHeight, 2);
                changeIMC(newImc, id);
            }

            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            stmt = c.createStatement();
            String sql = "UPDATE loseit.userlist SET currheight ="+ newHeight +" where id = '"+ id +"';";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
            System.out.println();
        }
        return false;
    }

    public boolean changeBodyFat(double newBodyFat, String id)
    {
        /**
         * NAME: changeBodyFat
         * RETURNS: true if successful, false if unsuccessful
         * PARAMETERS:
         * * newName - the new body fat of the user
         * * id - the id of the client whose body fat is being changed
         */
        Scanner myObj = new Scanner(System.in);
        String findHashed;
        String ex;
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Search email in database
            stmt = c.createStatement();

            String sql = "UPDATE loseit.userlist SET bodyfat ="+ newBodyFat +" where id = '"+ id +"';";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
            System.out.println();
        }
        return false;
    }

    public boolean changeIMC(double newIMC, String id)
    {
        /**
         * NAME: changeIMC
         * RETURNS: true if successful, false if unsuccessful
         * PARAMETERS:
         * * newIMC - the new IMC of the user (after altering weight or/and height)
         * * id - the id of the client whose IMC is being changed
         */
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");



            // Search email in database
            stmt = c.createStatement();

            String sql = "UPDATE loseit.userlist SET imc ="+ newIMC +" where id = '"+ id +"';";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
            System.out.println();
        }
        return false;
    }
}