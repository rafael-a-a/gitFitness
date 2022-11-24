import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefinitionsUI{

    JButton goBackButton;
    JButton changePass;
    JButton changeName;
    JButton changeData;
    JButton deleteAccount;
    JPanel textPanel;
    JPanel topPanel;
    JPanel goBackPanel;
    JPanel buttonsPanel;
    private final User currentUser;
    private  String info;
    private JPanel settingsPanel;


    DefinitionsUI(User u){

        currentUser = u;

        ImageIcon image = new ImageIcon("src/icons/logo4.png"); //create an ImageIcon
        JFrame frame = new JFrame();
        frame.setTitle("Lose it");  //Sets title of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setResizable(true); // don't allow frame to be resized
        frame.setSize(900,700); //sets the x-dimension and the y-dimension of the window
        frame.setVisible(true); //make frame visible
        frame.setIconImage(image.getImage());    //change icon of frame
        frame.setLocationRelativeTo(null);
        frame.add(settingsPanel);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == goBackButton){
                    frame.dispose();
                    MainMenuUI myMenuUI = new MainMenuUI(currentUser);
                    System.out.println("workout");
                }else if(e.getSource() == changePass){
                    info = "pass";
                    changePassUI cp = new changePassUI(currentUser, info);
                    System.out.println("change pass");
                    frame.dispose();
                }else if(e.getSource() == changeName){
                    info = "name";
                    changePassUI cp = new changePassUI(currentUser, info);
                    System.out.println("your name is"+currentUser.getName());
                    frame.dispose();
                }else if (e.getSource() == changeData){
                    System.out.println("change data");
                }else if(e.getSource() == deleteAccount){
                    info = "delete";
                    changePassUI cp = new changePassUI(currentUser, info);
                    System.out.println("delete account");
                    frame.dispose();

                }
            }
        };
        changePass.addActionListener(listener);
        changeName.addActionListener(listener);
        changeData.addActionListener(listener);
        deleteAccount.addActionListener(listener);
        goBackButton.addActionListener(listener);
    }

}





