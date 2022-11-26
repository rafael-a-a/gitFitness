import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkingoutUI {
    private JPanel workingout;
    private JPanel textPanel;
    private JLabel text;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel centerPanel;
    private JButton button1;
    private JPanel downPanel;
    private JPanel card;
    private JTextArea textArea1;
    Exercise ex;

    WorkingoutUI (Exercise[] e){

        ex=e[0];

        JFrame frame = new JFrame();
        frame.setTitle("Lose it");  //Sets title of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setResizable(true); // don't allow frame to be resized
        frame.setSize(900, 700); //sets the x-dimension and the y-dimension of the window
        frame.setVisible(true); //make frame visible
        frame.setLocationRelativeTo(null);
        textArea1.setText(ex.description);
        frame.add(workingout);
        System.out.println(ex.description);

        /*button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button1){

                }
            }
        });*/
    }
}
