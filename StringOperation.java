//Design a GUI application as shown below which consists of two 	text fields and various buttons for String operations. On clicking 	any of the button, the corresponding operation will be performed 	on the entered string in the first text field and the resultant 	string will be displayed in the second text field.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StringOperation extends JFrame implements ActionListener {
    private JTextField inputField, outputField;
    private JButton inCaps, inSmall, convertCase, words, letters, reverse, vowels, frequency, beginCaps, reset;

    public StringOperation() {
        // Frame settings
        setTitle("My Frame");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        getContentPane().setBackground(new Color(255, 182, 193)); // Light Pink

        // Labels and text fields
        add(new JLabel("Enter the string:"));
        inputField = new JTextField(20);
        add(inputField);

        add(new JLabel("String in upper case:"));
        outputField = new JTextField(20);
        outputField.setEditable(false);
        add(outputField);

        // Buttons for operations
        inCaps = new JButton("IN CAPS");
        inSmall = new JButton("IN SMALL");
        convertCase = new JButton("CONVERT CASE");
        words = new JButton("WORDS");
        letters = new JButton("LETTERS");
        reverse = new JButton("REVERSE");
        vowels = new JButton("VOWELS");
        frequency = new JButton("FREQUENCY");
        beginCaps = new JButton("BEGIN CAPS");
        reset = new JButton("RESET");

        // Adding buttons to frame
        add(inCaps);
        add(inSmall);
        add(convertCase);
        add(words);
        add(letters);
        add(reverse);
        add(vowels);
        add(frequency);
        add(beginCaps);
        add(reset);

        // Adding action listeners
        inCaps.addActionListener(this);
        inSmall.addActionListener(this);
        convertCase.addActionListener(this);
        words.addActionListener(this);
        letters.addActionListener(this);
        reverse.addActionListener(this);
        vowels.addActionListener(this);
        frequency.addActionListener(this);
        beginCaps.addActionListener(this);
        reset.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = inputField.getText();

        if (e.getSource() == inCaps) {
            outputField.setText(text.toUpperCase());
        } else if (e.getSource() == inSmall) {
            outputField.setText(text.toLowerCase());
        } else if (e.getSource() == convertCase) {
            outputField.setText(convertCase(text));
        } else if (e.getSource() == words) {
            outputField.setText("Words: " + text.split("\\s+").length);
        } else if (e.getSource() == letters) {
            outputField.setText("Letters: " + text.replaceAll("\\s+", "").length());
        } else if (e.getSource() == reverse) {
            outputField.setText(new StringBuilder(text).reverse().toString());
        } else if (e.getSource() == vowels) {
            outputField.setText("Vowels: " + countVowels(text));
        } else if (e.getSource() == frequency) {
            outputField.setText(characterFrequency(text));
        } else if (e.getSource() == beginCaps) {
            outputField.setText(beginCaps(text));
        } else if (e.getSource() == reset) {
            inputField.setText("");
            outputField.setText("");
        }
    }

    private String convertCase(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else {
                result.append(Character.toUpperCase(c));
            }
        }
        return result.toString();
    }

    private int countVowels(String str) {
        int count = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    private String characterFrequency(String str) {
        int[] freq = new int[256];
        for (char c : str.toCharArray()) {
            freq[c]++;
        }
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (freq[c] > 0) {
                result.append(c).append(":").append(freq[c]).append(" ");
                freq[c] = 0;
            }
        }
        return result.toString();
    }

    private String beginCaps(String str) {
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase()).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        new StringOperation();
    }
}