//Implement a GUI application which consists of one List Box and 	one button. The list box will have four different color names. 	When the user will select a color from the list box and click on 	the button, the panel color will be changed to that color.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChangerApp {
    public static void main(String[] args) {  
        // Create JFrame
        JFrame frame = new JFrame("Color Changer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // List of Colors
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        JList<String> colorList = new JList<>(colors);
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton applyButton = new JButton("Apply Color");

        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(Color.WHITE);
        colorPanel.setPreferredSize(new Dimension(400, 200));

        applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                String selectedColor = colorList.getSelectedValue();
                if (selectedColor != null) {
                    switch (selectedColor) {
                        case "Red":
                            colorPanel.setBackground(Color.RED);
                            break;
                        case "Green":
                            colorPanel.setBackground(Color.GREEN);
                            break;
                        case "Blue":
                            colorPanel.setBackground(Color.BLUE);
                            break;
                        case "Yellow":
                            colorPanel.setBackground(Color.YELLOW);
                            break;
                    }
                }
            }
        });

        frame.add(new JScrollPane(colorList), BorderLayout.WEST);
        frame.add(applyButton, BorderLayout.SOUTH);
        frame.add(colorPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
