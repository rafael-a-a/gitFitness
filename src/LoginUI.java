import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginUI extends JFrame implements ActionListener{

    Database d = new Database();
    JButton loginButton;
    JButton registerButton;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JLabel loginStatus;
    JLabel createAccountLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JLabel logoLabel;


    private boolean authentication = false;
    private boolean register = false;

    boolean getauthentication(){
        return authentication;
    }
     boolean getregister(){
        return register;
     }
    

    LoginUI(){
        ImageIcon icon = new ImageIcon("src/icons/logo4.png");
        //ImageIcon testicon = new ImageIcon("src/icons/logo3.png");
        ImageIcon loginButtonIcon = new ImageIcon("src/icons/loginButton.png");
        ImageIcon loginButtonPressed = new ImageIcon("src/icons/loginButtonClick.png");
        ImageIcon createAccountIcon = new ImageIcon("src/icons/createAccountButton.png");
        ImageIcon createAccountPressed = new ImageIcon("src/icons/createAccountButtonClick.png");



        loginButton = new JButton();
        registerButton = new JButton();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        loginStatus = new JLabel();
        usernameField = new JTextField();
        passwordField = new JPasswordField();    //hides password when writing
        createAccountLabel = new JLabel();
        logoLabel = new JLabel();


        final int buttonWidth = 120;
        final int buttonHeight = 30;
        final int windowWidth = 700;
        final int windowHeight = 700;


        loginButton.setFocusPainted(false); // Removes focus lines
        loginButton.setBorderPainted(false);    //Removes border
        loginButton.setContentAreaFilled(false);    //Removes background
        loginButton.setPressedIcon(loginButtonPressed);   //Changes icon (when pressed)
        loginButton.setIcon(loginButtonIcon);

        loginButton.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 270, buttonWidth, buttonHeight);
        loginButton.addActionListener(this);  // enables button
        loginButton.setText("Login" );
        loginButton.setFocusable(false);

        loginButton.setVerticalTextPosition(JButton.CENTER);
        loginButton.setHorizontalTextPosition(JButton.CENTER);
        loginButton.setFont(new Font("myText", Font.BOLD|Font.ITALIC,14));
        loginButton.setBackground(new Color(255,255,255));
        loginButton.setBorder(BorderFactory.createEtchedBorder());


        registerButton.setFocusPainted(false); // Removes focus lines
        registerButton.setBorderPainted(false);    //Removes border
        registerButton.setContentAreaFilled(false);    //Removes background
        registerButton.setPressedIcon(createAccountPressed);   //Changes icon (when pressed)
        registerButton.setIcon(createAccountIcon);

        registerButton.setVerticalTextPosition(JButton.CENTER);
        registerButton.setHorizontalTextPosition(JButton.CENTER);
        registerButton.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 120, buttonWidth, buttonHeight);
        registerButton.addActionListener(this);  // enables button
        registerButton.setText("Sign Up");
        registerButton.setFocusable(false);
        registerButton.setFont(new Font("myText", Font.BOLD|Font.ITALIC,14));
        registerButton.setBackground(new Color(255,255,255));
        registerButton.setBorder(BorderFactory.createEtchedBorder());


        usernameField.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 340, buttonWidth, buttonHeight - 10);
        //usernameField.setText("username");
        //usernameField.setForeground(Color.gray);
        //usernameField.addMouseListener(this);
        //usernameField.addKeyListener(this);

        passwordField.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 310, buttonWidth, buttonHeight - 10);

        usernameLabel.setBounds(windowWidth/2 - buttonWidth/2 - 60 ,windowHeight - 356, buttonWidth, buttonHeight + 20);
        usernameLabel.setText("Username");
        passwordLabel.setBounds(windowWidth/2 - buttonWidth/2 - 60 ,windowHeight - 326, buttonWidth, buttonHeight + 20);
        passwordLabel.setText("Password");
        createAccountLabel.setBounds(windowWidth/2 - buttonWidth/2 ,windowHeight - 160, buttonWidth, buttonHeight + 20);
        createAccountLabel.setText("First time on Lose It?");
        loginStatus.setBounds(windowWidth/2 - buttonWidth,windowHeight - 220, buttonWidth*3, buttonHeight - 10);



        logoLabel.setBounds(240 ,0, 250, 220);
        logoLabel.setIcon(icon);

        //JLabel test = new JLabel();

        //test.setBounds(300 ,450, 150, 120);
        //test.setIcon(testicon);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(windowWidth, windowHeight);
        this.getContentPane().setBackground(new Color(255,255,200));
        //this.setExtendedState(MAXIMIZED_BOTH);     //OPEN IN FULL WINDOW
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(icon.getImage());
        this.setVisible(true);
        this.add(loginButton);
        this.add(registerButton);
        this.add(usernameField);
        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(createAccountLabel);
        this.add(passwordField);
        this.add(loginStatus);
        this.add(logoLabel);
        //this.add(test);

    }





    @Override //button functionality
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginButton ){

            String uID;
            uID = usernameField.getText();
            String phonen = usernameField.getText();
            String password;
            password = String.valueOf(passwordField.getPassword()); // this method returns char[], not a String


            if(d.checkLogin(uID,password, phonen)) { //if login is verified, then opens main menu
                loginButton.setEnabled(false);
                User u = d.getUserData(uID);
                MainMenuUI myMenuUI = new MainMenuUI(u);
                this.dispose();

            }else{
                loginStatus.setFont(new Font("",Font.ITALIC,14));
                loginStatus.setForeground(Color.red);
                loginStatus.setText("Username or password are incorrect");
                passwordField.setText("");   //if login fails then password gets deleted
                authentication = false;

            }

        } else if(e.getSource() == registerButton){
            System.out.println("Registe-se");
            register = true;
            RegisterUI myRegister = new RegisterUI();
            this.dispose();

            //open new window
        }
    }

/*                  Not necessary right now
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == usernameField) {
            usernameField.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == usernameField){

            if(usernameField.getText().equals("username")){
                usernameField.setText("");
            }

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }*/
}
