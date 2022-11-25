import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise {
    public String name, difficulty, description, targetMuscle, exID;

    public static Exercise getRandomExercise(String targetMuscle, String difficulty){
        /**
         * NAME:getRandomExercise
         * RETURNS: returns a random exercise within the targetMuscle and difficulty given
         * PARAMETERS:
         * * targetMuscle - category of muscle chosen
         * * difficulty - the difficulty of the exercise
         */
        Connection c;
        Statement stmt;
        ResultSet rs;
        List<Integer> exsChosen = new ArrayList<>();
        Exercise retExercise = new Exercise();
        try {
            // Open connection to database loseit.login
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Select exercises with input targetMuscle and difficulty
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * from loseit.exercise where targetmuscle = '"+ targetMuscle +"' and difficulty = '"+ difficulty +"';");

            while(rs.next()){
                exsChosen.add(Integer.parseInt(rs.getString("id")));
            }

            Random random = new Random();
            int rnd = random.nextInt(exsChosen.toArray().length);

            c = DriverManager
                    .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                            "pswa0506", "XPdYrXJb");

            // Select the chose exercise
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * from loseit.exercise where id= '"+ exsChosen.toArray()[rnd] +"';");

            while(rs.next()){
                retExercise.name = rs.getString("name");
                retExercise.difficulty = rs.getString("difficulty");
                retExercise.description = rs.getString("description");
                retExercise.targetMuscle = rs.getString("targetmuscle");
                retExercise.exID = rs.getString("id");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return retExercise;
    }
    public Exercise[] getAllExercises() {
        /**
         * NAME:getAllExercises
         * RETURNS: an array of the class Exercises with all the existent exercises in the database
         * PARAMETERS:
         * * none
         */
        Exercise[] retArray = new Exercise[75];
        Connection c;
        Statement stmt;
        ResultSet rs;
        int i;

        for (i = 3; i < 78; i++) {
            try {
                // Open connection to database loseit.login
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://db.fe.up.pt:5432/pswa0506",
                                "pswa0506", "XPdYrXJb");

                stmt = c.createStatement();
                rs = stmt.executeQuery("SELECT * from loseit.exercise where id= '" + i + "';");
                while(rs.next()) {
                    System.out.println("i = " + i);
                    retArray[i - 3] = new Exercise();
                    retArray[i - 3].name = rs.getString("name");
                    retArray[i - 3].difficulty = rs.getString("difficulty");
                    retArray[i - 3].description = rs.getString("description");
                    retArray[i - 3].targetMuscle = rs.getString("targetmuscle");
                    retArray[i - 3].exID = rs.getString("id");
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
                System.out.println();
            }

        }
        return retArray;
    }
}