import javax.swing.*;  
import java.awt.event.*;  

public class HelloWorldGUI1 {
    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("Hello World GUI");
        frame.setSize(500, 300); // Bigger window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(null); // Still using null layout

        // Create a JLabel
        JLabel label = new JLabel("Hello, World!");
        label.setBounds(180, 30, 200, 30);
        frame.add(label);

        // Create a JTextField
        JTextField textField = new JTextField("Type something...");
        textField.setBounds(150, 80, 200, 30);
        frame.add(textField);

        // Create a JButton (Change Label)
        JButton buttonChange = new JButton("Set Text");
        buttonChange.setBounds(150, 130, 100, 30);
        frame.add(buttonChange);

        // Create another JButton (Clear/Reset)
        JButton buttonClear = new JButton("Clear");
        buttonClear.setBounds(260, 130, 100, 30);
        frame.add(buttonClear);

        // Action for "Set Text" button
        buttonChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                if (input.trim().isEmpty()) {
                    label.setText("Please type something!");
                } else {
                    label.setText(input); // Change label to user input
                }
            }
        });

        // Action for "Clear" button
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(""); 
                label.setText("Hello, World!"); // Reset label
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
