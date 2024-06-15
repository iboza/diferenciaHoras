import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class represents a GUI application that calculates the difference between two times.
 * The times are input by the user in the format "dd/MM/yy HH:mm:ss".
 * The difference is displayed in the format "X Days, Y Hours, Z Minutes, W Seconds."
 */
public class TimeDifferenceGUI extends JFrame {
    private JTextField startField;  // TextField to input the start time
    private JTextField endField;    // TextField to input the end time
    private JLabel resultLabel;     // Label to display the result

    /**
     * Constructor for the TimeDifferenceGUI class.
     * Initializes the GUI components and sets up the event handlers.
     */
    public TimeDifferenceGUI() {
        setLayout(new FlowLayout());

        startField = new JTextField(20);
        endField = new JTextField(20);
        JButton calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("");

        add(new JLabel("Example 15/06/24 12:00:00"));
        add(new JLabel("Start Time (dd/MM/yy HH:mm:ss):"));
        add(startField);
        add(new JLabel("End Time (dd/MM/yy HH:mm:ss):"));
        add(endField);
        add(calculateButton);
        add(resultLabel);

        // Set up the event handler for the calculate button
        calculateButton.addActionListener(e -> calculateTimeDifference());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Calculates the difference between the start time and end time.
     * The result is displayed in the resultLabel.
     */
    private void calculateTimeDifference() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startField.getText(), formatter);
        LocalDateTime end = LocalDateTime.parse(endField.getText(), formatter);

        Duration duration = Duration.between(start, end);

        long days = duration.toDays();
        long hours = duration.toHoursPart();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();

        String result = days < 1 ?
                String.format("%d Hours, %d Minutes, %d Seconds.", hours, minutes, seconds) :
                String.format("%d Days, %d Hours, %d Minutes, %d Seconds.", days, hours, minutes, seconds);

        resultLabel.setText(result);
    }

    /**
     * Main method to launch the application.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        new TimeDifferenceGUI();
    }
}