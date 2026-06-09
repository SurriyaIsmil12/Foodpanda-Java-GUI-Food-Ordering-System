import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DeliveryFrame extends JFrame {
    JTextField locationField;
    JLabel riderLabel, shippingLabel;
    JButton assignButton, nextButton;

    static String[] riders = {"Ali", "Usman", "Hamza", "Nouman", "Aliyas"};
    static String riderName = "";
    static int shippingCharge = 0;
    static String location = "";
    int restaurantIndex;
    int foodTotal;

    public DeliveryFrame(int restaurantIndex, int foodTotal) {
        this.restaurantIndex = restaurantIndex;
        this.foodTotal = foodTotal;

        setTitle("Delivery Information");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));
        setLocationRelativeTo(null);

        JPanel locPanel = new JPanel();
        locPanel.add(new JLabel("Enter Your Location:"));
        locationField = new JTextField(20);
        locPanel.add(locationField);
        add(locPanel);

        riderLabel = new JLabel("Rider: ");
        add(riderLabel);

        shippingLabel = new JLabel("Shipping Charges: ");
        add(shippingLabel);

        assignButton = new JButton("Assign Rider");
        add(assignButton);

        nextButton = new JButton("Next");
        add(nextButton);

        assignButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                location = locationField.getText().toLowerCase().trim();
                if (location.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Location cannot be empty!");
                    return;
                }

                if (location.contains("gulberg")) {
                    shippingCharge = 100;
                } else if (location.contains("johar")) {
                    shippingCharge = 80;
                } else if (location.contains("model")) {
                    shippingCharge = 70;
                } else {
                    shippingCharge = 120;
                }

                Random rand = new Random();
                riderName = riders[rand.nextInt(riders.length)];

                riderLabel.setText("Rider: " + riderName);
                shippingLabel.setText("Shipping Charges: Rs " + shippingCharge);

                JOptionPane.showMessageDialog(null, "✔ Rider Assigned and Charges Calculated!");
            }
        });

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (riderName.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please assign rider first!");
                    return;
                }
                dispose();
                new PaymentFrame(restaurantIndex, foodTotal, shippingCharge, riderName, location);
            }
        });

        setVisible(true);
    }
}