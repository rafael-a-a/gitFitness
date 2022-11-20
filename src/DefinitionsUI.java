import org.postgresql.ds.common.BaseDataSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefinitionsUI extends JFrame implements ActionListener {

    JButton goBackButton;
    JButton changePass;
    JButton changeMail;
    JButton changeData;
    JButton deleteAccount;
    JLabel textLabel;
    JLabel buttonsLabel;
    JPanel textPanel;
    JPanel topPanel;
    JPanel goBackPanel;
    JPanel buttonsPanel;



    DefinitionsUI(){

        ImageIcon backImage = new ImageIcon("src/icons/Button.png");
        ImageIcon backPressed = new ImageIcon("src/icons/ButtonClick.png");
        ImageIcon image = new ImageIcon("src/icons/logo4.png"); //create an ImageIcon

//-------------------------------Buttons--------------------------------------------
        goBackButton = new JButton();
        goBackButton.setFocusPainted(false); // Removes focus lines
        goBackButton.setBorderPainted(false);    //Removes border
        goBackButton.setContentAreaFilled(true);    //Removes background
        goBackButton.setBackground(new Color(62, 255, 147));
        goBackButton.setPreferredSize(new Dimension(50, 30));
        //goBackButton.setPressedIcon(backPressed);   //Changes icon (when pressed)
        //goBackButton.setIcon(backImage);
        //goBackButton.setBounds(1, 130, 250, 100);
        goBackButton.addActionListener(this);
        goBackButton.setFocusable(false);
        goBackButton.setLayout(new BorderLayout());

        changePass = new JButton();
        changePass.setText("Change password");
        changePass.setFocusPainted(false);
        changePass.setBorderPainted(false);
        changePass.setContentAreaFilled(true);
        changePass.setBackground(new Color(62, 255, 147));
        changePass.setPreferredSize(new Dimension(400, 50));
        changePass.setBounds(240, 0, 400, 100);
        changePass.addActionListener(this);

        changeMail = new JButton();
        changeMail.setBounds(240, 100, 400, 100);
        changeMail.setText("Change E-mail");
        changeMail.addActionListener(this);

        changeData = new JButton();
        changeData.setBounds(240, 200, 400, 100);
        changeData.setText("Change your data");
        changeData.addActionListener(this);

        deleteAccount  = new JButton();
        deleteAccount.setBounds(240, 300, 400, 100);
        deleteAccount.setText("Delete your account");
        deleteAccount.addActionListener(this);

//-------------------------------Labels--------------------------------------------
        textLabel = new JLabel();
        textLabel.setText("DEFINITIONS");
        textLabel.setVerticalAlignment(JLabel.TOP);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 40));


        buttonsLabel = new JLabel();
        buttonsLabel.setVerticalAlignment(JLabel.CENTER);
        buttonsLabel.setHorizontalAlignment(JLabel.CENTER);
        buttonsLabel.setBackground(new Color(255, 229, 62));
        buttonsLabel.add(changePass);
        buttonsLabel.add(changeMail);
        buttonsLabel.add(changeData);
        buttonsLabel.add(deleteAccount);


//-------------------------------Panels--------------------------------------------
        topPanel = new JPanel();
        topPanel.setBackground(new Color(255, 255, 200));
        topPanel.setPreferredSize(new Dimension(500,40));
        topPanel.setLayout(new BorderLayout());     //allows to change elements position inside the panel
        goBackPanel = new JPanel();
        goBackPanel.setBackground(new Color(255, 255, 200));
        goBackPanel.setPreferredSize(new Dimension(100, 100));
        goBackPanel.add(goBackButton);
        topPanel.add(goBackPanel, BorderLayout.WEST);


        textPanel =new JPanel();
        textPanel.setBackground(new Color(255, 255, 200));
        textPanel.setPreferredSize(new Dimension(100, 100));
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel, BorderLayout.NORTH);

        buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(255, 255, 200));
        buttonsPanel.setPreferredSize(new Dimension(400, 600));
        buttonsPanel.setLayout(new BorderLayout());
        buttonsPanel.add(buttonsLabel, BorderLayout.CENTER);

        textPanel.add(buttonsPanel, BorderLayout.CENTER);



        this.setTitle("Lose it");  //Sets title of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(true); // don't allow frame to be resized
        this.setSize(900,700); //sets the x-dimension and the y-dimension of the window
        this.setLayout(new BorderLayout());
        this.setVisible(true); //make frame visible
        this.setIconImage(image.getImage());    //change icon of frame
        //this.getContentPane().setBackground(new Color(255, 255, 200));       //change background color
        this.setLocationRelativeTo(null);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(textPanel, BorderLayout.CENTER);
        //this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == goBackButton){
            this.dispose();
            MainMenuUI myMenuUI = new MainMenuUI();
            System.out.println("workout");
        }else if(e.getSource() == changePass){
            System.out.println("change pass");
        }else if(e.getSource() == changeMail){
            System.out.println("change mail");
        }else if (e.getSource() == changeData){
            System.out.println("change data");
        }else if(e.getSource() == deleteAccount){
            System.out.println("delete account");
        }
    }
}





