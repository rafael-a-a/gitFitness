import java.util.regex.Pattern;

public class LoginBE {

    /*Arguments
    email - email to check
    pattern - pattern used to check if mail is valid
      Return
    true if mail is valid

     */
    private static final String pattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public static boolean emailVerificationPattern(String email){
        return Pattern.compile(pattern).matcher(email).matches();
    }

    public static String getPattern(){
        return pattern;
    }


}
