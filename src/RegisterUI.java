import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUI extends JFrame implements ActionListener {

    JButton createButton = new JButton();
    JTextField emailField = new JTextField();
    JTextField idlField = new JTextField();
    JTextField phoneField = new JTextField();
    JPasswordField passwordField = new JPasswordField();


    final int buttonWidth = 120;
    final int buttonHeight = 30;
    final int windowWidth = 700;
    final int windowHeight = 700;
    
    RegisterUI(){



        createButton.setBounds(windowWidth/2 - buttonWidth/2,windowHeight - 270, buttonWidth, buttonHeight);
        createButton.addActionListener(this);  // enables button
        createButton.setText("Create Account" );
        createButton.setFocusable(false);
        createButton.setFont(new Font("myText", Font.BOLD|Font.ITALIC,14));
        createButton.setBackground(new Color(255,255,255));
        createButton.setBorder(BorderFactory.createEtchedBorder());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(windowWidth, windowHeight);
        this.getContentPane().setBackground(new Color(224,255,255));
        //this.setExtendedState(MAXIMIZED_BOTH);     //OPEN IN FULL WINDOW
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.add(createButton);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
