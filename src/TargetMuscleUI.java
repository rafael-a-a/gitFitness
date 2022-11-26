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

    private final Exercise ex[] = new Exercise[10];

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
                    ex[0] = Exercise.getRandomExercise("Abs", difficulty);
                    System.out.println(ex[0].name);

                }
            }
        });
        backCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    ex[1]= Exercise.getRandomExercise("Back", difficulty);
                    System.out.println(ex[1].name);

                }

            }
        });
        bicepsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    ex[2] = Exercise.getRandomExercise("Biceps", difficulty);
                    System.out.println(ex[2].name);

                }

            }
        });
        cardioCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    ex[3] = Exercise.getRandomExercise("Cardio", difficulty);
                    System.out.println(ex[3].name);

                }

            }
        });
        chestCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    ex[4] = Exercise.getRandomExercise("Chest", difficulty);
                    System.out.println(ex[4].name);

                }

            }
        });
        glutesCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    ex[5] = Exercise.getRandomExercise("Glutes", difficulty);
                    System.out.println(ex[5].name);

                }

            }
        });
        lowerLegsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    ex[6] = Exercise.getRandomExercise("Lower Legs", difficulty);
                    System.out.println(ex[6].name);

                }

            }
        });
        shouldersCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    ex[7] = Exercise.getRandomExercise("Shoulders", difficulty);
                    System.out.println(ex[7].name);

                }

            }
        });
        tricepsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    ex[8] = Exercise.getRandomExercise("Triceps", difficulty);
                    System.out.println(ex[8].name);

                }

            }
        });
        upperLegsCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    ex[9] = Exercise.getRandomExercise("Upper Legs", difficulty);
                    System.out.println(ex[9].name);
                }

            }
        });
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==confirmButton){
                    frame.dispose();
                    WorkingoutUI myWorkingout =new WorkingoutUI(ex);
                }
            }
        });
    }
}
