import org.postgresql.ds.common.BaseDataSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefinitionsUI extends JFrame implements ActionListener {

    JButton goBackButton;
    JButton changePass;
    JButton changeName;
    JButton changeData;
    JButton deleteAccount;
    JLabel textLabel;
    JLabel buttonsLabel;
    JPanel textPanel;
    JPanel topPanel;
    JPanel goBackPanel;
    JPanel buttonsPanel;
    private final User currentUser;
    private  String info;



    DefinitionsUI(User u){

        currentUser = u;
        ImageIcon backImage = new ImageIcon("src/icons/Back.png");
        ImageIcon backPressed = new ImageIcon("src/icons/BackClick.png");
        ImageIcon image = new ImageIcon("src/icons/logo4.png"); //create an ImageIcon
        ImageIcon button = new ImageIcon("src/icons/Treino");
        ImageIcon buttonPressed = new ImageIcon("src/icons/TreinoClick.png");

//-------------------------------Buttons--------------------------------------------
        goBackButton = new JButton();
        goBackButton.setFocusPainted(false); // Removes focus lines
        goBackButton.setBorderPainted(false);    //Removes border
        goBackButton.setContentAreaFilled(false);    //Removes background
        goBackButton.setPreferredSize(new Dimension(50, 30));
        goBackButton.setPressedIcon(backPressed);   //Changes icon (when pressed)
        goBackButton.setIcon(backImage);
        goBackButton.addActionListener(this);
        goBackButton.setFocusable(false);
        goBackButton.setLayout(new BorderLayout());

        changePass = new JButton();
        changePass.setText("Mudar palavra passe");
       /* changePass.setFocusPainted(false);
        changePass.setBorderPainted(false);
        changePass.setContentAreaFilled(false);
        changePass.setPressedIcon(buttonPressed);
        changePass.setIcon(button);*/
        changePass.setIconTextGap(-15);
        changePass.setPreferredSize(new Dimension(400, 100));
        changePass.addActionListener(this);

        changeName = new JButton();
        changeName.setPreferredSize(new Dimension(400, 100));//setBounds(240, 110, 400, 100);
        changeName.setText("Alterar nome");
        changeName.addActionListener(this);

        changeData = new JButton();
        changeData.setPreferredSize(new Dimension(400, 100));//setBounds(240, 210, 400, 100);
        changeData.setText("Alterar os dados pessoais");
        changeData.addActionListener(this);

        deleteAccount  = new JButton();
        deleteAccount.setPreferredSize(new Dimension(400, 100));//setBounds(240, 310, 400, 100);
        deleteAccount.setText("Apagar conta");
        deleteAccount.addActionListener(this);

//-------------------------------Labels--------------------------------------------
        textLabel = new JLabel();
        // esta janela devia se chamar settings
        textLabel.setText("DEFINIÇÔES");
        textLabel.setVerticalAlignment(JLabel.TOP);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 40));


        buttonsLabel = new JLabel();
        buttonsLabel.setPreferredSize(new Dimension(100,100));
        buttonsLabel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        c.gridx = 0;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 10,0,0);
        //c.fill = GridBagConstraints.VERTICAL;
        buttonsLabel.add(changePass,c);
        buttonsLabel.add(changeName,c);
        buttonsLabel.add(changeData,c);
        buttonsLabel.add(deleteAccount,c);




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
        buttonsPanel.setPreferredSize(new Dimension(100, 100));
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
        this.setLocationRelativeTo(null);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(textPanel, BorderLayout.CENTER);
        //this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == goBackButton){
            this.dispose();
            MainMenuUI myMenuUI = new MainMenuUI(currentUser);
            System.out.println("workout");
        }else if(e.getSource() == changePass){
            info = "pass";
            changePassUI cp = new changePassUI(currentUser, info);
            System.out.println("change pass");
            this.dispose();
        }else if(e.getSource() == changeName){
            info = "name";
            changePassUI cp = new changePassUI(currentUser, info);
            System.out.println("your name is"+currentUser.getName());
            this.dispose();
        }else if (e.getSource() == changeData){
            System.out.println("change data");
        }else if(e.getSource() == deleteAccount){
            System.out.println("delete account");
        }
    }
}





