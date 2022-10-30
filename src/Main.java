
public class Main {
    public static void main(String[] args) {

        LoginUI myLogin = new LoginUI();
        RegisterUI myRegister;

        //texto = LoginUI.getUsername()
        while(true){
            if(myLogin.getregister()){
                myRegister = new RegisterUI();

                break;
            }
            System.out.println("hello");
        }
    }
}