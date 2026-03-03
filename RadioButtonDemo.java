import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButton extends JFrame implements ActionListener {

    // Radio buttons
    private final JRadioButton bird, cat, dog, rabbit, pig;

    // Label to display images
    private final JLabel imageLabel;

    public RadioButtonDemo() {

        // Window title
        setTitle("RadioButton Demo with Images");

        // Window size
        setSize(400, 400);

        // Layout
        setLayout(new FlowLayout());

        // Create radio buttons
        bird = new JRadioButton("Bird");
        cat = new JRadioButton("Cat");
        dog = new JRadioButton("Dog");
        rabbit = new JRadioButton("Rabbit");
        pig = new JRadioButton("Pig");

        // Group radio buttons (only one selectable)
        ButtonGroup group = new ButtonGroup();
        group.add(bird);
        group.add(cat);
        group.add(dog);
        group.add(rabbit);
        group.add(pig);

        // Add buttons to frame
        add(bird);
        add(cat);
        add(dog);
        add(rabbit);
        add(pig);

        // Add action listeners
        bird.addActionListener(this);
        cat.addActionListener(this);
        dog.addActionListener(this);
        rabbit.addActionListener(this);
        pig.addActionListener(this);

        // JLabel for image display
        imageLabel = new JLabel();
        add(imageLabel);

        // Default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make window visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ImageIcon icon = null;

        if (bird.isSelected()) {
            icon = new ImageIcon(getClass().getResource("/images/bird.png"));
        } else if (cat.isSelected()) {
            icon = new ImageIcon(getClass().getResource("/images/cat.png"));
        } else if (dog.isSelected()) {
            icon = new ImageIcon(getClass().getResource("/images/dog.jpg"));
        } else if (rabbit.isSelected()) {
            icon = new ImageIcon(getClass().getResource("/images/rabbit.jpg"));
        } else if (pig.isSelected()) {
            icon = new ImageIcon(getClass().getResource("/images/pig.jpg"));
        }

        // Optional: resize image to fit nicely
        if (icon != null) {
            Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        }
    }

    public static void main(String[] args) {
        // Run GUI in Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new RadioButtonDemo());
    }

}
