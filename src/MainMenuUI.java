import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainMenuUI extends JFrame implements ActionListener{

    JButton workout;
    JButton objectives;
    JButton progress;
    JButton settings;

    JLabel bigImagLabel;
    JPanel imagPanel;

    MainMenuUI(){
        ImageIcon bigImage = new ImageIcon("src/logo1.png");

        bigImagLabel = new JLabel();   //creates a new label
        bigImagLabel.setIcon(bigImage);
        bigImagLabel.setVerticalAlignment(JLabel.CENTER);  //set vertical position
        bigImagLabel.setHorizontalAlignment(JLabel.CENTER);
        bigImagLabel.setLayout(new BorderLayout());

        imagPanel = new JPanel();
        imagPanel.setBackground(new Color(33, 192, 255));
        imagPanel.setBounds(300, 20, 500, 400);
        //imagPanel.setLayout(null);
        imagPanel.add(bigImagLabel);



        //ImageIcon workoutIcon = new ImageIcon();  //for when we have an icon

        workout = new JButton();    //creates a new button
        workout.setBounds(20, 20, 250, 100);
        workout.addActionListener(this);
        workout.setText("TREINO");  //set text of button
        workout.setFocusable(false);
        //workout.setIcon(workoutIcon);
        workout.setVerticalTextPosition(JButton.CENTER);
        workout.setHorizontalTextPosition(JButton.CENTER);
        workout.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 30));
        workout.setIconTextGap(-15);
        workout.setBackground(new Color(255, 62, 120));


        objectives = new JButton();    //creates a new button
        objectives.setBounds(20, 130, 250, 100);
        objectives.addActionListener(this);
        objectives.setText("OBJETIVOS");  //set text of button
        objectives.setFocusable(false);
        //objectives.setIcon(objectivesIcon);
        objectives.setVerticalTextPosition(JButton.CENTER);
        objectives.setHorizontalTextPosition(JButton.CENTER);
        objectives.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 30));
        objectives.setIconTextGap(-15);
        objectives.setBackground(new Color(62, 255, 147));


        progress = new JButton();    //creates a new button
        progress.setBounds(20, 240, 250, 100);
        progress.addActionListener(this);
        progress.setText("PROGRESSO");  //set text of button
        progress.setFocusable(false);
        //progress.setIcon(progressIcon);
        progress.setVerticalTextPosition(JButton.CENTER);
        progress.setHorizontalTextPosition(JButton.CENTER);
        progress.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 30));
        progress.setIconTextGap(-15);
        progress.setBackground(new Color(62, 123, 255));


        settings = new JButton();    //creates a new button
        settings.setBounds(20, 500, 250, 100);
        settings.addActionListener(this);
        settings.setText("DEFINIÇÕES");  //set text of button
        settings.setFocusable(false);
        //settings.setIcon(settingsIcon);
        settings.setVerticalTextPosition(JButton.CENTER);
        settings.setHorizontalTextPosition(JButton.CENTER);
        settings.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 30));
        settings.setIconTextGap(-15);
        settings.setBackground(new Color(255, 229, 62));


        this.setTitle("Lose it");  //Sets title of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false); // don't allow frame to be resized
        this.setSize(900,700); //sets the x-dimension and the y-dimension of the window
        this.setLayout(null);
        this.setVisible(true); //make frame visible
        ImageIcon image = new ImageIcon("src/logo4.png"); //create an ImageIcon
        this.setIconImage(image.getImage());    //change icon of frame
        this.getContentPane().setBackground(new Color(116, 216, 253));       //change background color
        this.setLocationRelativeTo(null);
        this.add(workout);
        this.add(objectives);
        this.add(progress);
        this.add(settings);
        this.add(imagPanel);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==workout){
            System.out.println("workout");
        } else if (e.getSource()==objectives) {
            System.out.println("objectives");
        } else if (e.getSource()==progress) {
            System.out.println("progress");
        } else if (e.getSource()==settings) {
            System.out.println("settings");
        }
    }
}
