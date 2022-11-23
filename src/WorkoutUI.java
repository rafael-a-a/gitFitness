import javax.swing.*;

public class WorkoutUI{
    private JPanel workout;
    private JLabel treinoLabel;
    private JButton fácilButton;
    private JButton médioButton;
    private JButton difícilButton;
    private JButton button1;

    private final User currentUser;

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }

    WorkoutUI (User u){

        currentUser = u;
        JFrame frame = new JFrame();
        frame.setTitle("Lose it");  //Sets title of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setResizable(true); // don't allow frame to be resized
        frame.setSize(900,700); //sets the x-dimension and the y-dimension of the window
        frame.setVisible(true); //make frame visible
        frame.setLocationRelativeTo(null);
        frame.add(workout);


        button1.addActionListener(e -> {
            if (e.getSource() == button1) {
                System.out.println("workout");
                frame.dispose();
                MainMenuUI myWorkout = new MainMenuUI(currentUser);
            }
        });
    }

}
