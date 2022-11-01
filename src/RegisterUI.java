import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterUI extends JFrame implements ActionListener, MouseListener, KeyListener {

    JButton createButton = new JButton();
    JTextField emailField = new JTextField();
    JTextField idField = new JTextField();
    JTextField phoneField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmpassField = new JPasswordField();
    JTextField nameField = new JTextField();

    JLabel createStatus = new JLabel();

    Database d = new Database();


    final int buttonWidth = 160;
    final int buttonHeight = 30;
    final int windowWidth = 700;
    final int windowHeight = 700;
    
    RegisterUI(){

        emailField.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 440, buttonWidth, buttonHeight - 10);
        emailField.addKeyListener(this);
        emailField.addMouseListener(this);
        emailField.setText("Email...");
        emailField.setForeground(Color.lightGray);
        //idField.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 440, buttonWidth, buttonHeight - 10);4

        phoneField.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 410, buttonWidth, buttonHeight - 10);
        phoneField.addKeyListener(this);
        phoneField.addMouseListener(this);
        phoneField.setText("Phone number...");
        phoneField.setForeground(Color.lightGray);

        passwordField.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 380, buttonWidth, buttonHeight - 10);
        passwordField.addKeyListener(this);
        passwordField.addMouseListener(this);
        passwordField.setEchoChar((char)0);
        passwordField.setText("Password...");
        passwordField.setForeground(Color.lightGray);

        confirmpassField.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 350, buttonWidth, buttonHeight - 10);
        confirmpassField.addMouseListener(this);
        confirmpassField.addKeyListener(this);
        confirmpassField.setEchoChar((char)0);
        confirmpassField.setText("Confirm your password...");
        confirmpassField.setForeground(Color.lightGray);

        nameField.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 320, buttonWidth, buttonHeight - 10);
        nameField.addKeyListener(this);
        nameField.addMouseListener(this);
        nameField.setText("Name...");
        nameField.setForeground(Color.lightGray);

        createButton.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 270, buttonWidth, buttonHeight);
        createButton.addActionListener(this);  // enables button
        createButton.setText("Create Account" );
        createButton.setFocusable(false);
        createButton.setFont(new Font("myText", Font.BOLD|Font.ITALIC,14));
        createButton.setBackground(new Color(255,255,255));
        createButton.setBorder(BorderFactory.createEtchedBorder());

        createStatus.setBounds(windowWidth/2 - buttonWidth/2 - 10,windowHeight - 220, buttonWidth*3, buttonHeight - 10);

        ImageIcon icon = new ImageIcon("src/logo4.png");
        JLabel logoLabel = new JLabel();

        logoLabel.setBounds(240 ,0, 250, 220);
        logoLabel.setIcon(icon);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(windowWidth, windowHeight);
        this.getContentPane().setBackground(new Color(224,255,255));
        //this.setExtendedState(MAXIMIZED_BOTH);     //OPEN IN FULL WINDOW
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.add(createButton);
        this.add(idField);
        this.add(emailField);
        this.add(phoneField);
        this.add(passwordField);
        this.add(confirmpassField);
        this.add(nameField);
        this.add(createStatus);
        this.add(logoLabel);
    }
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == createButton){

            boolean passwordsMatch = RegisterBE.checkPassword(passwordField.getPassword(), confirmpassField.getPassword());

            if(passwordsMatch && RegisterBE.emailVerificationPattern(emailField.getText())){

                    User u = new User(nameField.getText(),emailField.getText(),String.valueOf(passwordField.getPassword()),phoneField.getText());
                    d.signIn(u);
                    createStatus.setFont(new Font("",Font.ITALIC,14));
                    createStatus.setForeground(Color.green);
                    createStatus.setBounds(windowWidth/2 - buttonWidth/2 - 12,windowHeight - 220, buttonWidth*3, buttonHeight - 10);
                    createStatus.setText("Your account has been created!");


            }else{
                createStatus.setFont(new Font("",Font.ITALIC,14));
                createStatus.setForeground(Color.red);
                if(!passwordsMatch)
                    createStatus.setText("Your passwords don´t match");
                else
                    createStatus.setText("  Your email is not valid");
            }

        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == passwordField){
            if(String.valueOf(passwordField.getPassword()).equals("Password...")){
                passwordField.setText("");
                passwordField.setEchoChar((char)8226);
            }

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getSource() == passwordField){
            if(String.valueOf(passwordField.getPassword()).equals("Password...")){
                passwordField.setText("");
                passwordField.setEchoChar((char)8226);
                passwordField.setForeground(Color.BLACK);
            }

        }
        if(e.getSource() == confirmpassField){
            if(String.valueOf(confirmpassField.getPassword()).equals("Confirm your password...")){
                confirmpassField.setText("");
                confirmpassField.setEchoChar((char)8226);
                confirmpassField.setForeground(Color.black);
            }

        }
        if(e.getSource() == emailField){
            if(emailField.getText().equals("Email...")){
                emailField.setText("");
                emailField.setForeground(Color.black);

            }
        }
        if(e.getSource() == phoneField){
            if(phoneField.getText().equals("Phone number...")){
                phoneField.setText("");
                phoneField.setForeground(Color.black);

            }
        }

        if(e.getSource() == nameField){
            if(nameField.getText().equals("Name...")){
                nameField.setText("");
                nameField.setForeground(Color.black);

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(e.getSource() == passwordField){
            if(String.valueOf(passwordField.getPassword()).equals("Password...")){
                passwordField.setText("");
                passwordField.setEchoChar((char)8226);
                passwordField.setForeground(Color.black);
            }

        }
        if(e.getSource() == confirmpassField){
            if(String.valueOf(confirmpassField.getPassword()).equals("Confirm your password...")){
                confirmpassField.setText("");
                confirmpassField.setEchoChar((char)8226);
                confirmpassField.setForeground(Color.black);
            }

        }
        if(e.getSource() == emailField){
            if(emailField.getText().equals("Email...")){
                emailField.setText("");
                emailField.setForeground(Color.black);

            }
        }
        if(e.getSource() == phoneField){
            if(phoneField.getText().equals("Phone number...")){
                phoneField.setText("");
                phoneField.setForeground(Color.black);

            }
        }

        if(e.getSource() == nameField){
            if(nameField.getText().equals("Name...")){
                nameField.setText("");
                nameField.setForeground(Color.black);

            }
        }

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
}
