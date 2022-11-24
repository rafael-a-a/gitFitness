import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TargetMuscleUI {

    private JPanel targetPanel;
    private JButton button1;
    private JPanel panel1;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JCheckBox checkBox7;
    private JCheckBox checkBox8;
    private JCheckBox checkBox9;
    private JCheckBox checkBox10;
    private JButton backButton;

    private final User currentUser;
    private void createUIComponents() {
        // TODO: place custom component creation code here

    }

    TargetMuscleUI(User u){

        currentUser = u;

        int windowHeight = 300;
        int windowWidth = 300;
        int buttonHeight = 30;
        int buttonWidth = 160;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.add(targetPanel);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == backButton) {
                    frame.dispose();
                    WorkoutUI myTarget = new WorkoutUI(currentUser);
                }
            }
        });
    }
}
