package in.bassure.training.batch7.java;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AnonymousDemo {

    public static void main(String[] args) {
        JFrame f = new JFrame("Window App");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println(
                        """
                        Application Terminated:
                            Run your end logic here.
                       """);
            }
        });

        JButton button = new JButton("Hit Me");
        f.setLayout(new FlowLayout());
        f.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You Hit Me @ " + LocalDateTime.now());
            }
        });

        JButton button2 = new JButton("Like Me");
        f.add(button2);
        button2.addActionListener(e -> {
            System.out.println("Liked Me @ " + LocalDateTime.now());
        });

        f.setSize(300, 500);
        f.setLocation(200, 80);
        f.setVisible(true);
    }

}
