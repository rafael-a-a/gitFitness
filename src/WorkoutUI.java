import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutUI {
    private JPanel workout;
    private JLabel treinoLabel;
    private JButton facilButton;
    private JButton medioButton;
    private JButton dificilButton;
    private JButton backButton;

    private final User currentUser;

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }

    WorkoutUI(User u) {

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

        facilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == facilButton) {
                    frame.dispose();
                    TargetMuscleUI myTarget = new TargetMuscleUI();
                }
            }
        });


        medioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == medioButton) {
                    frame.dispose();
                    TargetMuscleUI myTarget = new TargetMuscleUI();
                }
            }
        });


        dificilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == dificilButton) {
                    frame.dispose();
                    TargetMuscleUI myTarget = new TargetMuscleUI();
                }
            }
        });



    }
}
