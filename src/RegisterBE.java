import java.util.regex.Pattern;

public class RegisterBE {

    private static final String pattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public static boolean emailVerificationPattern(String email){
        return Pattern.compile(pattern).matcher(email).matches();
    }

    public static boolean checkPassword(char[] pass1,char[] pass2){

        String spass1 = String.valueOf(pass1);
        String spass2 = String.valueOf(pass2);

        return spass1.equals(spass2);
    }
}
