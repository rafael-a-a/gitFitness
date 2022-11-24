import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TargetMuscleUI {

    private JPanel targetPanel;
    private JButton confirmButton;
    private JPanel panel1;
    private JCheckBox absCheck;
    private JCheckBox backCheckBox;
    private JCheckBox chestCheckBox;
    private JCheckBox upperLegsCheckBox;
    private JCheckBox lowerLegsCheckBox;
    private JCheckBox shouldersCheckBox;
    private JCheckBox bicepsCheckBox;
    private JCheckBox cardioCheckBox;
    private JCheckBox glutesCheckBox;
    private JCheckBox tricepsCheckBox;
    private JButton backButton;

    private final User currentUser;

    TargetMuscleUI(User u){

        currentUser = u;

        int windowHeight = 500;
        int windowWidth = 500;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(targetPanel);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == backButton) {
                    frame.dispose();
                    WorkoutUI myWorkout = new WorkoutUI(currentUser);
                }
            }
        });
        /*ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==absCheck){

                    
                } else if (e.getSource()==backCheckBox) {
                    
                } else if (e.getSource()==bicepsCheckBox) {
                    
                } else if (e.getSource()==cardioCheckBox) {
                    
                } else if (e.getSource()==chestCheckBox) {
                    
                } else if (e.getSource()==glutesCheckBox) {
                    
                } else if (e.getSource()==lowerLegsCheckBox) {
                    
                } else if (e.getSource()==shouldersCheckBox) {
                    
                } else if (e.getSource()==tricepsCheckBox) {
                    
                } else if (e.getSource()==upperLegsCheckBox) {
                    
                } else if (e.getSource()==confirmButton) {

                }
            }
        };
        absCheck.addActionListener(listener);
        backCheckBox.addActionListener(listener);
        bicepsCheckBox.addActionListener(listener);
        cardioCheckBox.addActionListener(listener);
        chestCheckBox.addActionListener(listener);
        glutesCheckBox.addActionListener(listener);
        lowerLegsCheckBox.addActionListener(listener);
        shouldersCheckBox.addActionListener(listener);
        tricepsCheckBox.addActionListener(listener);
        upperLegsCheckBox.addActionListener(listener);
        confirmButton.addActionListener(listener);*/
    }
}
