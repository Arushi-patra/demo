//Design a GUI application which consists of three 	Label named 	as Red, Green and blue, three combo boxes which 	will consist 	the value from 0 to 255 and one button named as 	show output. 	The user will select different values from three combo boxes.	When the user clicks on the button, the panel background 	will be changed accordingly as per the value passed in RGB	format.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RGBColorChanger {
    public static void main(String[] args) {
        JFrame frame =new JFrame("RGB Color Changer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        JLabel redLabel = new JLabel("Red:");
        JLabel greenLabel = new JLabel("Green:");
        JLabel blueLabel = new JLabel("Blue:");

        Integer[] values = new Integer[256];
        for (int i = 0; i <= 255; i++) {
            values[i] = i;
        }

        JComboBox<Integer> redCombo = new JComboBox<>(values);
        JComboBox<Integer> greenCombo = new JComboBox<>(values);
        JComboBox<Integer> blueCombo = new JComboBox<>(values);

        JButton showOutputButton = new JButton("Show Output");

        JPanel colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(350, 150));
        colorPanel.setBackground(new Color(255, 255, 255)); // Default White

        showOutputButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int red = (int) redCombo.getSelectedItem();
                int green = (int) greenCombo.getSelectedItem();
                int blue = (int) blueCombo.getSelectedItem();

                colorPanel.setBackground(new Color(red, green, blue));
            }
        });

        frame.add(redLabel);
        frame.add(redCombo);
        frame.add(greenLabel);
        frame.add(greenCombo);
        frame.add(blueLabel);
        frame.add(blueCombo);
        frame.add(showOutputButton);
        frame.add(colorPanel);

        frame.setVisible(true);
    }
}
