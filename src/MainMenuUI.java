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
    JPanel buttonsPanel;
    JPanel settingsPanel;
    private final User currentUser;

    MainMenuUI(User u){

        currentUser = u;
        ImageIcon bigImage = new ImageIcon("src/icons/logo1.png");
        ImageIcon workoutIcon = new ImageIcon("src/icons/Button.png");
        ImageIcon workoutPressed = new ImageIcon("src/icons/ButtonClick.png");
        ImageIcon settingsIcon = new ImageIcon("src/icons/Definições.png");
        ImageIcon settingsPressed = new ImageIcon("src/icons/DefiniçõesClick.png");
        ImageIcon progressIcon = new ImageIcon("src/icons/Button.png");
        ImageIcon progressPressed = new ImageIcon("src/icons/ButtonClick.png");
        ImageIcon objectivesIcon = new ImageIcon("src/icons/Button.png");
        ImageIcon objectivesPressed = new ImageIcon("src/icons/ButtonClick.png");

        bigImagLabel = new JLabel();   //creates a new label
        bigImagLabel.setIcon(bigImage);
        bigImagLabel.setVerticalAlignment(JLabel.CENTER);  //set vertical position
        bigImagLabel.setHorizontalAlignment(JLabel.CENTER);
        bigImagLabel.setLayout(new BorderLayout());

        imagPanel = new JPanel();
        imagPanel.setBackground(new Color(189, 222, 228));
        imagPanel.setBounds(300, 20, 500, 400);
        //imagPanel.setLayout(null);
        imagPanel.add(bigImagLabel);


        buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(189,222,228));
        buttonsPanel.setPreferredSize(new Dimension(270,100));


        settingsPanel = new JPanel();
        settingsPanel.setBackground(new Color(189,222,228));
        settingsPanel.setPreferredSize(new Dimension(100,200));
        settingsPanel.setLayout(new BorderLayout());



        //ImageIcon workoutIcon = new ImageIcon();  //for when we have an icon

        workout = new JButton();    //creates a new button
        //-----Button icon-----
        workout.setFocusPainted(false); // Removes focus lines
        workout.setBorderPainted(false);    //Removes border
        workout.setContentAreaFilled(false);    //Removes background
        workout.setPressedIcon(workoutPressed);   //Changes icon (when pressed)
        workout.setIcon(workoutIcon);
        //-----Button configuration-----
        workout.setBounds(20, 20, 250, 100);
        workout.addActionListener(this);
        workout.setText("TREINO");  //set text of button
        workout.setFocusable(false);
        workout.setVerticalTextPosition(JButton.CENTER);
        workout.setHorizontalTextPosition(JButton.CENTER);
        workout.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 30));
        workout.setIconTextGap(-15);
        //workout.setBackground(new Color(255, 62, 120));


        objectives = new JButton();    //creates a new button

        objectives.setFocusPainted(false); // Removes focus lines
        objectives.setBorderPainted(false);    //Removes border
        objectives.setContentAreaFilled(false);    //Removes background
        objectives.setPressedIcon(objectivesPressed);   //Changes icon (when pressed)
        objectives.setIcon(objectivesIcon);

        objectives.setBounds(20, 130, 250, 100);
        objectives.addActionListener(this);
        objectives.setText("OBJETIVOS");  //set text of button
        objectives.setFocusable(false);
        objectives.setVerticalTextPosition(JButton.CENTER);
        objectives.setHorizontalTextPosition(JButton.CENTER);
        objectives.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 30));
        objectives.setIconTextGap(-15);
        //objectives.setBackground(new Color(62, 255, 147));


        progress = new JButton();    //creates a new button

        progress.setFocusPainted(false); // Removes focus lines
        progress.setBorderPainted(false);    //Removes border
        progress.setContentAreaFilled(false);    //Removes background
        progress.setPressedIcon(progressPressed);   //Changes icon (when pressed)
        progress.setIcon(progressIcon);

        progress.setBounds(20, 240, 250, 100);
        progress.addActionListener(this);
        progress.setText("PROGRESSO");  //set text of button
        progress.setFocusable(false);
        progress.setVerticalTextPosition(JButton.CENTER);
        progress.setHorizontalTextPosition(JButton.CENTER);
        progress.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 30));
        progress.setIconTextGap(-15);
        //progress.setBackground(new Color(62, 123, 255));


        settings = new JButton();    //creates a new button

        settings.setFocusPainted(false); // Removes focus lines
        settings.setBorderPainted(false);    //Removes border
        settings.setContentAreaFilled(false);    //Removes background
        settings.setPressedIcon(settingsPressed);   //Changes icon (when pressed)
        settings.setIcon(settingsIcon);

        settings.setBounds(20, 500, 250, 100);
        settings.addActionListener(this);
        settings.setText("DEFINIÇÕES");  //set text of button
        settings.setFocusable(false);
        settings.setVerticalTextPosition(JButton.CENTER);
        settings.setHorizontalTextPosition(JButton.CENTER);
        settings.setFont(new Font("myText", Font.BOLD|Font.ITALIC, 25));
        settings.setIconTextGap(-15);
        //settings.setBackground(new Color(255, 229, 62));



        buttonsPanel.add(workout);
        buttonsPanel.add(objectives);
        buttonsPanel.add(progress);
        settingsPanel.add(settings, BorderLayout.WEST);


        this.setTitle("Lose it");  //Sets title of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(true); // don't allow frame to be resized
        this.setSize(900,700); //sets the x-dimension and the y-dimension of the window
        this.setLayout(new BorderLayout());
        this.setVisible(true); //make frame visible
        ImageIcon image = new ImageIcon("src/icons/logo4.png"); //create an ImageIcon
        this.setIconImage(image.getImage());    //change icon of frame
        this.getContentPane().setBackground(new Color(183, 222, 236));       //change background color
        this.setLocationRelativeTo(null);

        /*this.add(workout);
        this.add(objectives);
        this.add(progress);
        this.add(settings);*/
        this.add(buttonsPanel, BorderLayout.WEST);
        this.add(settingsPanel, BorderLayout.SOUTH);

        this.add(imagPanel, BorderLayout.CENTER);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==workout){
            System.out.println("workout");
            this.dispose();
            WorkoutUI myWorkout = new WorkoutUI(currentUser);
        } else if (e.getSource()==objectives) {
            System.out.println("objectives");
        } else if (e.getSource()==progress) {
            System.out.println("progress");
        } else if (e.getSource()==settings) {
            this.dispose();
            DefinitionsUI myDef = new DefinitionsUI(currentUser);
            System.out.println("settings");
        }
    }
}
