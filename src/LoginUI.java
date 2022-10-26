import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame implements ActionListener {


    JButton loginButton;
    JButton registerButton;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JLabel loginStatus;
    JTextField usernameField;
    JPasswordField passwordField;

    private boolean authentication = false;

    boolean getauthentication(){
        return authentication;
    }
    

    LoginUI(){

        loginButton = new JButton();
        registerButton = new JButton();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        loginStatus = new JLabel();
        usernameField = new JTextField();
        passwordField = new JPasswordField();    //hides password when writing

        final int buttonWidth = 120;
        final int buttonHeight = 30;
        final int windowWidth = 700;
        final int windowHeight = 700;

        loginButton.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 270, buttonWidth, buttonHeight);
        loginButton.addActionListener(this);  // enables button
        loginButton.setText("Login" );
        loginButton.setFocusable(false);
        loginButton.setFont(new Font("myText", Font.BOLD|Font.ITALIC,14));
        loginButton.setBackground(new Color(255,255,255));
        loginButton.setBorder(BorderFactory.createEtchedBorder());

        registerButton.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 230, buttonWidth, buttonHeight);
        registerButton.addActionListener(this);  // enables button
        registerButton.setText("Criar conta");
        registerButton.setFocusable(false);
        registerButton.setFont(new Font("myText", Font.BOLD|Font.ITALIC,14));
        registerButton.setBackground(new Color(255,255,255));
        registerButton.setBorder(BorderFactory.createEtchedBorder());


        usernameField.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 340, buttonWidth, buttonHeight - 10);
        passwordField.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 310, buttonWidth, buttonHeight - 10);

        usernameLabel.setBounds(windowWidth/2 - buttonWidth/2 - 60 ,windowHeight - 356, buttonWidth, buttonHeight + 20);
        usernameLabel.setText("Username");
        passwordLabel.setBounds(windowWidth/2 - buttonWidth/2 - 60 ,windowHeight - 326, buttonWidth, buttonHeight + 20);
        passwordLabel.setText("Password");
        loginStatus.setBounds(windowWidth/2 - buttonWidth,windowHeight - 140, buttonWidth*3, buttonHeight - 10);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(windowWidth, windowHeight);
        this.getContentPane().setBackground(new Color(224,255,255));
        //this.setExtendedState(MAXIMIZED_BOTH);     //OPEN IN FULL WINDOW
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.add(loginButton);
        this.add(registerButton);
        this.add(usernameField);
        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(loginStatus);

    }



    @Override //button functionality
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginButton ){

            String uID;
            uID = usernameField.getText();
            String password;
            password = String.valueOf(passwordField.getPassword()); // this method returns char[], not a String


            if(uID.equals("rafael") && password.equals("rafael")) {
                //System.out.println(usernameField.getText() + " is logged in\n");
                loginStatus.setFont(new Font("",Font.ITALIC,14));
                loginStatus.setForeground(Color.green);
                loginStatus.setText("                  Welcome " + usernameField.getText());
                loginStatus.setVisible(true);

                loginButton.setEnabled(false);
            }else{
                loginStatus.setFont(new Font("",Font.ITALIC,14));
                loginStatus.setForeground(Color.red);
                loginStatus.setText("Username or password are incorrect");
                passwordField.setText("");   //if login fails then password gets deleted
                authentication = true;

            }

        } else if(e.getSource() == registerButton){
            System.out.println("Registe-se");

            //open new window
        }
    }


}
