import javax.swing.*;  
import java.awt.*;   // For Color class
import java.awt.event.*;  
import java.util.Random;  

public class HelloWorldGUI3{
    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("Hello World GUI");
        frame.setSize(500, 350); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(null); 

        // Set background color of frame
        frame.getContentPane().setBackground(new Color(230, 240, 250)); // light blue

        // Create a JLabel
        JLabel label = new JLabel("Hello, World!");
        label.setBounds(180, 30, 200, 30);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.BLUE); 
        frame.add(label);

        // Create a JTextField
        JTextField textField = new JTextField("Type something...");
        textField.setBounds(150, 80, 200, 30);
        frame.add(textField);

        // Create a JButton (Change Label)
        JButton buttonChange = new JButton("Set Text");
        buttonChange.setBounds(150, 130, 100, 30);
        buttonChange.setBackground(new Color(144, 238, 144)); 
        buttonChange.setForeground(Color.BLACK);
        frame.add(buttonChange);

        // Create another JButton (Clear/Reset)
        JButton buttonClear = new JButton("Clear");
        buttonClear.setBounds(260, 130, 100, 30);
        buttonClear.setBackground(new Color(255, 182, 193)); 
        buttonClear.setForeground(Color.BLACK);
        frame.add(buttonClear);

        // Create a new JButton (Change Label Color)
        JButton buttonColor = new JButton("Change Text Color");
        buttonColor.setBounds(80, 190, 160, 30);
        buttonColor.setBackground(new Color(173, 216, 230)); 
        buttonColor.setForeground(Color.BLACK);
        frame.add(buttonColor);

        // Create another JButton (Change Background Color)
        JButton buttonBgColor = new JButton("Change Background");
        buttonBgColor.setBounds(250, 190, 160, 30);
        buttonBgColor.setBackground(new Color(255, 228, 181)); // light orange
        buttonBgColor.setForeground(Color.BLACK);
        frame.add(buttonBgColor);

        // Action for "Set Text" button
        buttonChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                if (input.trim().isEmpty()) {
                    label.setText("Please type something!");
                } else {
                    label.setText(input); 
                }
            }
        });

        // Action for "Clear" button
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(""); 
                label.setText("Hello, World!"); 
                label.setForeground(Color.BLUE); 
                frame.getContentPane().setBackground(new Color(230, 240, 250)); // reset background
            }
        });

        // Action for "Change Text Color" button
        buttonColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                Color randomColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                label.setForeground(randomColor); 
            }
        });

        // Action for "Change Background" button
        buttonBgColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                Color randomColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                frame.getContentPane().setBackground(randomColor); 
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
