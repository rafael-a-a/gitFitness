import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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


    TargetMuscleUI(User u, String difficulty) {

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
                if (e.getSource() == backButton) {
                    frame.dispose();
                    WorkoutUI myWorkout = new WorkoutUI(currentUser);
                }
            }
        });


        absCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    Exercise ex;
                    ex = Exercise.getRandomExercise("Abs", difficulty);
                    System.out.println(ex.name);

                }
            }
        });
        backCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    Exercise ex;
                    ex = Exercise.getRandomExercise("Back", difficulty);
                    System.out.println(ex.name);

                }

            }
        });
        bicepsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    Exercise ex;
                    ex = Exercise.getRandomExercise("Biceps", difficulty);
                    System.out.println(ex.name);

                }

            }
        });
        cardioCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    Exercise ex;
                    ex = Exercise.getRandomExercise("Cardio", difficulty);
                    System.out.println(ex.name);

                }

            }
        });
        chestCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    Exercise ex;
                    ex = Exercise.getRandomExercise("Chest", difficulty);
                    System.out.println(ex.name);

                }

            }
        });
        glutesCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    Exercise ex;
                    ex = Exercise.getRandomExercise("Glutes", difficulty);
                    System.out.println(ex.name);

                }

            }
        });
        lowerLegsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    Exercise ex;
                    ex = Exercise.getRandomExercise("Lower Legs", difficulty);
                    System.out.println(ex.name);

                }

            }
        });
        shouldersCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    Exercise ex;
                    ex = Exercise.getRandomExercise("Shoulders", difficulty);
                    System.out.println(ex.name);

                }

            }
        });
        tricepsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    Exercise ex;
                    ex = Exercise.getRandomExercise("Triceps", difficulty);
                    System.out.println(ex.name);

                }

            }
        });
        upperLegsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    Exercise ex;
                    ex = Exercise.getRandomExercise("Upper Legs", difficulty);
                    System.out.println(ex.name);

                }

            }
        });
    }
}
