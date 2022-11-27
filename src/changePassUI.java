import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

public class changePassUI extends JFrame implements ActionListener, MouseListener, KeyListener {


    private boolean pressedw;
    private boolean pressedh;
    private boolean pressedf;
    Database d = new Database();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField newpassField = new JPasswordField();
    JPasswordField confirmpassField = new JPasswordField();
    JButton changePass = new JButton();
    JButton goBackButton = new JButton();
    JTextField nameField = new JTextField();
    JLabel changeStatus = new JLabel();
    JLabel textLabel = new JLabel();
    JLabel wLabel = new JLabel();
    JLabel hLabel = new JLabel();
    JLabel fLabel = new JLabel();
    JButton cwButton = new JButton();
    JButton chButton = new JButton();
    JButton cfButton = new JButton();
    JTextField wText = new JTextField();
    JTextField hText = new JTextField();
    JTextField fText = new JTextField();

    private User currentUser;
    private String info;

    int windowHeight = 300;
    int windowWidth = 300;
    int buttonHeight = 30;
    int buttonWidth = 160;

    changePassUI(User u, String i){

        info = i;
        currentUser = u;

        ImageIcon changeIcon = new ImageIcon("src/icons/createAccountButton.png");
        ImageIcon changePressed = new ImageIcon("src/icons/createAccountButtonClick.png");
        ImageIcon backImage = new ImageIcon("src/icons/Back.png");
        ImageIcon backPressed = new ImageIcon("src/icons/BackClick.png");

        pressedw = false;
        pressedh = false;
        pressedf = false;

        System.out.println("altura do individuo:" + currentUser.getHeight());

        if(info.equals("pass") || info.equals("delete")){
            textLabel = new JLabel();

            if(info.equals("delete")){
                textLabel.setText("  Delete your account");
            }else{
                textLabel.setText(" Change your password");
            }
            textLabel.setBounds(windowWidth /2 - buttonWidth /2, windowHeight - 250, buttonWidth + 10, buttonHeight - 10);
            textLabel.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 14));

            passwordField.setBounds(windowWidth /2 - buttonWidth /2, windowHeight - 200, buttonWidth, buttonHeight - 10);
            passwordField.addKeyListener(this);
            passwordField.addMouseListener(this);
            passwordField.setEchoChar((char)0);
            passwordField.setText("Password...");
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
            confirmpassField.setText("Confirm your new password...");
            confirmpassField.setForeground(Color.lightGray);

        }else if(info.equals("name")){
            textLabel = new JLabel();
            // esta janela devia se chamar settings
            textLabel.setText("   Change your name");
            textLabel.setBounds(windowWidth /2 - buttonWidth /2, windowHeight - 250, buttonWidth, buttonHeight - 10);
            textLabel.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 14));

            nameField.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 170, buttonWidth, buttonHeight - 10);
            nameField.addKeyListener(this);
            nameField.addMouseListener(this);
            nameField.setText("Name...");
            nameField.setForeground(Color.lightGray);
        }else if(info.equals("data")){
            createChangeData();
        }

        goBackButton.setVisible(true);
        goBackButton.setFocusPainted(false); // Removes focus lines
        goBackButton.setBorderPainted(false);    //Removes border
        goBackButton.setContentAreaFilled(false);
        goBackButton.setPressedIcon(backPressed);   //Changes icon (when pressed)
        goBackButton.setIcon(backImage);
        goBackButton.setVerticalTextPosition(JButton.CENTER);
        goBackButton.setHorizontalTextPosition(JButton.CENTER);
        goBackButton.setBounds(0,windowHeight - 290, 60 , buttonHeight);
        goBackButton.addActionListener(this);
        goBackButton.setFocusable(false);
        goBackButton.setBackground(new Color(255, 255, 255, 255));
        goBackButton.setBorder(BorderFactory.createEtchedBorder());


        changePass.setFocusPainted(false); // Removes focus lines
        changePass.setBorderPainted(false);    //Removes border
        changePass.setContentAreaFilled(false);    //Removes background
        changePass.setPressedIcon(changePressed);   //Changes icon (when pressed)
        changePass.setIcon(changeIcon);

        changePass.setVerticalTextPosition(JButton.CENTER);
        changePass.setHorizontalTextPosition(JButton.CENTER);
        changePass.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 80, buttonWidth, buttonHeight);
        changePass.addActionListener(this);  // enables button
        changePass.setText("Change");
        changePass.setFocusable(false);
        changePass.setFont(new Font("myText", Font.BOLD|Font.ITALIC,14));
        changePass.setBackground(new Color(255,255,255));
        changePass.setBorder(BorderFactory.createEtchedBorder());

        changeStatus.setBounds(windowWidth/2 - buttonWidth/2 - 30,windowHeight - 190, buttonWidth*3, buttonHeight - 10);
        changeStatus.setFont(new Font("",Font.ITALIC,14));
        changeStatus.setVisible(false);

        if(info.equals("delete")){
            confirmpassField.setVisible(false);
            newpassField.setVisible(false);
            changePass.setText("Delete");
        }

        if(info.equals("data")){
            changePass.setVisible(false);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(windowWidth, windowHeight);
        this.getContentPane().setBackground(new Color(224,255,255));
        //this.setExtendedState(MAXIMIZED_BOTH);     //OPEN IN FULL WINDOW
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.add(goBackButton);
        this.add(changePass);
        this.add(confirmpassField);
        this.add(passwordField);
        this.add(newpassField);
        this.add(nameField);
        this.add(textLabel);
        this.add(changeStatus);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == changePass){

            String pass = String.valueOf(passwordField.getPassword());

            if(info.equals("pass"))
            {
                boolean passwordsMatch = RegisterBE.checkPassword(newpassField.getPassword(), confirmpassField.getPassword());
                String oldpass = String.valueOf(passwordField.getPassword());
                String newpass = String.valueOf(newpassField.getPassword());


                if( passwordsMatch ){
                    if(d.checkLogin(currentUser.getEmail(),pass,currentUser.getPhone()) && d.changePassword(currentUser.getID(),oldpass,newpass)){
                        System.out.println("change pass accepted");
                        changeStatus.setVisible(true);
                        changeStatus.setForeground(Color.green);
                        changeStatus.setText("Your password has been changed");
                        changePass.setVisible(false);
                        passwordField.setVisible(false);
                        confirmpassField.setVisible(false);
                        newpassField.setVisible(false);

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
                changeStatus.setVisible(true);
                changeStatus.setForeground(Color.green);
                changeStatus.setText("  Your name has been changed");
                nameField.setVisible(false);

            }else if(info.equals("delete") && d.checkLogin(currentUser.getEmail(), pass, currentUser.getPhone())){
                d.delID(currentUser.getID());
                System.out.println("account deleted:/");
                LoginUI myLogin = new LoginUI();
                this.dispose();

            }

        }else if(e.getSource() == goBackButton){
            DefinitionsUI definitions = new DefinitionsUI(currentUser);
            this.dispose();
        }else if(e.getSource() == cwButton && !pressedw){
            pressedw = true;
            wText.setVisible(true);
        }else if(e.getSource() == chButton && !pressedh ){
            pressedh = true;
            hText.setVisible(true);
        }else if(e.getSource() == cfButton && !pressedf){
            pressedf = true;
            fText.setVisible(true);
            System.out.println(pressedf);
        }else if(e.getSource() == cwButton && pressedw){
            if(updateWeight()){
                currentUser = d.getUserData(currentUser.getEmail());
                wLabel.setText("Weight:  " + String.format(Locale.ENGLISH,"%.1f",currentUser.getWeight()) + " kg");
            }
            pressedw = false;
            wText.setVisible(false);
            wText.setText("");

        }else if(e.getSource() == chButton && pressedh){
            if(updateHeight()){

                currentUser = d.getUserData(currentUser.getEmail());
                hLabel.setText("Height:  " + String.format(Locale.ENGLISH,"%.2f",currentUser.getHeight()) + "  m");
            }
            pressedh = false;
            hText.setVisible(false);
            hText.setText("");

        }else if(e.getSource() == cfButton && pressedf ){
            //double fat = Double.parseDouble(fText.getText());


            if(updateFat()){
                currentUser = d.getUserData(currentUser.getEmail());
                fLabel.setText("Body Fat: " + currentUser.getBodyFat()+ "%");
            }

            fText.setText("");
            pressedf = false;
            fText.setVisible(false);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == passwordField) {
            if (String.valueOf(passwordField.getPassword()).equals("Password...")) {
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
            if(String.valueOf(confirmpassField.getPassword()).equals("Confirm your new password...")){
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
            if (String.valueOf(passwordField.getPassword()).equals("Password...")) {
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
            if(String.valueOf(confirmpassField.getPassword()).equals("Confirm your new password...")){
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
            if (String.valueOf(passwordField.getPassword()).equals("Password...")) {
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
            if(String.valueOf(confirmpassField.getPassword()).equals("Confirm your new password...")){
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

    public boolean updateHeight(){
        double height;

        try{
            height = Double.parseDouble(hText.getText());
        }catch (NumberFormatException nfe){
            return false;
        }

        if( height <= 0 || height > 2.50){
            return false;
        }

        return d.changeHeight(height, currentUser.getID());
    }

    public boolean updateWeight(){

        double weight;

        try{
            weight = Double.parseDouble(wText.getText());
        }catch (NumberFormatException nfe){
            return false;
        }

        if(weight <= 0){
            return false;
        }

        return d.changeWeight(weight, currentUser.getID());
    }

    public boolean updateFat(){

        double fat;

        try{
            fat = Double.parseDouble(fText.getText());
        }catch (NumberFormatException nfe){
            return false;
        }

        if(fat <= 0 || fat >= 90){
            return false;
        }

        return d.changeBodyFat(fat, currentUser.getID());
    }

    public void createChangeData(){


        textLabel.setText("  Change your Data");
        textLabel.setBounds(windowWidth /2 - buttonWidth /2, windowHeight - 250, buttonWidth, buttonHeight - 10);
        textLabel.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 15));

        wLabel.setText("Weight:  " + String.format(Locale.ENGLISH,"%.1f",currentUser.getWeight()) + " kg");
        wLabel.setBounds(windowWidth /2 - 120, windowHeight - 180, buttonWidth, buttonHeight - 10);
        wLabel.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 14));

        cwButton.setBounds(windowWidth /2, windowHeight - 176, 30, buttonHeight - 15);
        cwButton.setText("...");
        cwButton.addActionListener(this);
        cwButton.setFocusable(false);
        wText.setBounds(windowWidth /2 + 40 , windowHeight - 176, 30, buttonHeight - 15);
        wText.setVisible(false);


        hLabel.setText("Height:  " + String.format(Locale.ENGLISH,"%.2f",currentUser.getHeight()) + "  m");
        hLabel.setBounds(windowWidth /2 - 120, windowHeight - 150, buttonWidth, buttonHeight - 10);
        hLabel.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 14));

        chButton.setBounds(windowWidth /2, windowHeight - 146, 30, buttonHeight - 15);
        chButton.setText("...");
        chButton.addActionListener(this);
        chButton.setFocusable(false);
        hText.setBounds(windowWidth /2 + 40, windowHeight - 146, 30, buttonHeight - 15);
        hText.setVisible(false);


        fLabel.setText("Body Fat: " + currentUser.getBodyFat()+ "%");
        fLabel.setBounds(windowWidth /2 - 120, windowHeight - 120, buttonWidth, buttonHeight - 10);
        fLabel.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 14));

        cfButton.setText("...");
        cfButton.setBounds(windowWidth /2, windowHeight - 116, 30, buttonHeight - 15);
        cfButton.addActionListener(this);
        cfButton.setFocusable(false);
        fText.setBounds(windowWidth /2 + 40, windowHeight - 116, 30, buttonHeight - 15);
        fText.setVisible(false);


        this.add(wLabel);
        this.add(hLabel);
        this.add(fLabel);
        this.add(cwButton);
        this.add(chButton);
        this.add(cfButton);
        this.add(wText);
        this.add(hText);
        this.add(fText);

    }
}


