import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutUI {
    private JPanel workout;
    private JLabel treinoLabel;
    private JButton backButton;
    private JButton mediumButton;
    private JButton easyButton;
    private JButton hardButton;

    private final User currentUser;

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }

    WorkoutUI(User u) {

        final String[] difficulty = new String[1];
        final String targetMuscle;

        currentUser = u;
        JFrame frame = new JFrame();
        frame.setTitle("Lose it");  //Sets title of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setResizable(true); // don't allow frame to be resized
        frame.setSize(900, 700); //sets the x-dimension and the y-dimension of the window
        frame.setVisible(true); //make frame visible
        frame.setLocationRelativeTo(null);
        frame.add(workout);


        backButton.addActionListener(e -> {
            if (e.getSource() == backButton) {
                System.out.println("workout");
                frame.dispose();
                MainMenuUI myWorkout = new MainMenuUI(currentUser);
            }
        });

        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == easyButton) {
                    difficulty[0] = "Beginner";
                    frame.dispose();
                    TargetMuscleUI myTarget = new TargetMuscleUI(currentUser, difficulty[0]);
                }
            }
        });


        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == mediumButton) {
                    difficulty[0] = "Medium";
                    frame.dispose();
                    TargetMuscleUI myTarget = new TargetMuscleUI(currentUser, difficulty[0]);
                }
            }
        });


        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == hardButton) {
                    difficulty[0] = "Expert";
                    frame.dispose();
                    TargetMuscleUI myTarget = new TargetMuscleUI(currentUser, difficulty[0]);
                }
            }
        });



    }
}
