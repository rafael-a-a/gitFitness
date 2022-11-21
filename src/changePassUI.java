import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class changePassUI extends JFrame implements ActionListener, MouseListener, KeyListener {

    Database d = new Database();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField newpassField = new JPasswordField();
    JPasswordField confirmpassField = new JPasswordField();
    JButton changePass = new JButton();
    JTextField nameField = new JTextField();
    JLabel textLabel = new JLabel();
    private final User currentUser;
    private String info;

    changePassUI(User u, String i){

        info = i;
        currentUser = u;

        ImageIcon changeIcon = new ImageIcon("src/icons/createAccountButton.png");
        ImageIcon changePressed = new ImageIcon("src/icons/createAccountButtonClick.png");

        int windowHeight = 300;
        int windowWidth = 300;
        int buttonHeight = 30;
        int buttonWidth = 160;


        if(info.equals("pass")){
            textLabel = new JLabel();
            // esta janela devia se chamar settings
            textLabel.setText("Change your password");
            textLabel.setBounds(windowWidth /2 - buttonWidth /2, windowHeight - 250, buttonWidth, buttonHeight - 10);
            textLabel.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 14));

            passwordField.setBounds(windowWidth /2 - buttonWidth /2, windowHeight - 200, buttonWidth, buttonHeight - 10);
            passwordField.addKeyListener(this);
            passwordField.addMouseListener(this);
            passwordField.setEchoChar((char)0);
            passwordField.setText("Old password...");
            passwordField.setForeground(Color.lightGray);

            newpassField.setBounds(windowWidth /2 - buttonWidth /2, windowHeight - 170, buttonWidth, buttonHeight - 10);
            newpassField.addKeyListener(this);
            newpassField.addMouseListener(this);
            newpassField.setEchoChar((char)0);
            newpassField.setText("New password...");
            newpassField.setForeground(Color.lightGray);

            confirmpassField.setBounds(windowWidth /2 - buttonWidth /2, windowHeight - 140, buttonWidth, buttonHeight - 10);
            confirmpassField.addMouseListener(this);
            confirmpassField.addKeyListener(this);
            confirmpassField.setEchoChar((char)0);
            confirmpassField.setText("Confirm your password...");
            confirmpassField.setForeground(Color.lightGray);

        }else if(info.equals("name")){
            textLabel = new JLabel();
            // esta janela devia se chamar settings
            textLabel.setText("Change your name");
            textLabel.setBounds(windowWidth /2 - buttonWidth /2, windowHeight - 250, buttonWidth, buttonHeight - 10);
            textLabel.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 14));

            nameField.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 170, buttonWidth, buttonHeight - 10);
            nameField.addKeyListener(this);
            nameField.addMouseListener(this);
            nameField.setText("Name...");
            nameField.setForeground(Color.lightGray);
        }


        changePass.setFocusPainted(false); // Removes focus lines
        changePass.setBorderPainted(false);    //Removes border
        changePass.setContentAreaFilled(false);    //Removes background
        changePass.setPressedIcon(changePressed);   //Changes icon (when pressed)
        changePass.setIcon(changeIcon);

        changePass.setVerticalTextPosition(JButton.CENTER);
        changePass.setHorizontalTextPosition(JButton.CENTER);
        changePass.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 80, buttonWidth, buttonHeight);
        changePass.addActionListener(this);  // enables button
        changePass.setText("Change" );
        changePass.setFocusable(false);
        changePass.setFont(new Font("myText", Font.BOLD|Font.ITALIC,14));
        changePass.setBackground(new Color(255,255,255));
        changePass.setBorder(BorderFactory.createEtchedBorder());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(windowWidth, windowHeight);
        this.getContentPane().setBackground(new Color(224,255,255));
        //this.setExtendedState(MAXIMIZED_BOTH);     //OPEN IN FULL WINDOW
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.add(changePass);
        this.add(confirmpassField);
        this.add(passwordField);
        this.add(newpassField);
        this.add(nameField);
        this.add(textLabel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == changePass){

            if(info.equals("pass")){
                boolean passwordsMatch = RegisterBE.checkPassword(newpassField.getPassword(), confirmpassField.getPassword());
                String oldpass = String.valueOf(passwordField.getPassword());
                String newpass = String.valueOf(newpassField.getPassword());
                if( passwordsMatch ){
                    if(d.changePassword(currentUser.getID(),oldpass,newpass)){
                        System.out.println("change pass accepted");
                        DefinitionsUI definitions = new DefinitionsUI(currentUser);
                        this.dispose();
                    }else{
                        System.out.println("your pass is wrong");
                        //Label to say " Your password is wrong"
                    }
                }else{
                    System.out.println("dont match");
                    //Label to say " Your passwords dont match "
                }
            }else if(info.equals("name") && d.changeName(nameField.getText(),currentUser.getID())){
                currentUser.setName(nameField.getText());
                DefinitionsUI definitions = new DefinitionsUI(currentUser);
                this.dispose();
            }

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == passwordField) {
            if (String.valueOf(passwordField.getPassword()).equals("Old password...")) {
                passwordField.setText("");
                passwordField.setEchoChar((char) 8226);
                passwordField.setForeground(Color.black);
            }
        }
        else if(e.getSource() == newpassField){
                if(String.valueOf(newpassField.getPassword()).equals("New password...")){
                    newpassField.setText("");
                    newpassField.setEchoChar((char)8226);
                    newpassField.setForeground(Color.black);
                }
            }
        else if(e.getSource() == confirmpassField){
            if(String.valueOf(confirmpassField.getPassword()).equals("Confirm your password...")){
                    confirmpassField.setText("");
                    confirmpassField.setEchoChar((char)8226);
                    confirmpassField.setForeground(Color.black);
            }
        }else if(e.getSource() == nameField){
            if(nameField.getText().equals("Name...")){
                nameField.setText("");
                nameField.setForeground(Color.black);

            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource() == passwordField) {
            if (String.valueOf(passwordField.getPassword()).equals("Old password...")) {
                passwordField.setText("");
                passwordField.setEchoChar((char) 8226);
                passwordField.setForeground(Color.black);
            }
        }
        else if(e.getSource() == newpassField){
            if(String.valueOf(newpassField.getPassword()).equals("New password...")){
                newpassField.setText("");
                newpassField.setEchoChar((char)8226);
                newpassField.setForeground(Color.black);
            }
        }
        else if(e.getSource() == confirmpassField){
            if(String.valueOf(confirmpassField.getPassword()).equals("Confirm your password...")){
                confirmpassField.setText("");
                confirmpassField.setEchoChar((char)8226);
                confirmpassField.setForeground(Color.black);
            }
        }else if(e.getSource() == nameField){
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
        if(e.getSource() == passwordField) {
            if (String.valueOf(passwordField.getPassword()).equals("Old password...")) {
                passwordField.setText("");
                passwordField.setEchoChar((char) 8226);
                passwordField.setForeground(Color.black);
            }
        }
        else if(e.getSource() == newpassField){
            if(String.valueOf(newpassField.getPassword()).equals("New password...")){
                newpassField.setText("");
                newpassField.setEchoChar((char)8226);
                newpassField.setForeground(Color.black);
            }
        }
        else if(e.getSource() == confirmpassField){
            if(String.valueOf(confirmpassField.getPassword()).equals("Confirm your password...")){
                confirmpassField.setText("");
                confirmpassField.setEchoChar((char)8226);
                confirmpassField.setForeground(Color.black);
            }
        }else if(e.getSource() == nameField){
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
