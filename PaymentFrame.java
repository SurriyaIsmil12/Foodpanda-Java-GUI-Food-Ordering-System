import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PaymentFrame extends JFrame {
    JRadioButton cashOption, cardOption;
    ButtonGroup paymentGroup;
    JButton confirmButton;
    JTextArea receiptArea;

    int restaurantIndex, foodTotal, shippingCharge;
    String riderName, location;

    static String[] restaurant = {"KFC", "MC Donalds", "Yasir Broast", "Bundu Khan"};

    public PaymentFrame(int restaurantIndex, int foodTotal, int shippingCharge, String riderName, String location) {
        this.restaurantIndex = restaurantIndex;
        this.foodTotal = foodTotal;
        this.shippingCharge = shippingCharge;
        this.riderName = riderName;
        this.location = location;

        setTitle("Payment & Receipt");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select Payment Method:"));

        cashOption = new JRadioButton("Cash");
        cardOption = new JRadioButton("Card");
        paymentGroup = new ButtonGroup();
        paymentGroup.add(cashOption);
        paymentGroup.add(cardOption);

        topPanel.add(cashOption);
        topPanel.add(cardOption);

        confirmButton = new JButton("Confirm & Show Receipt");
        topPanel.add(confirmButton);

        add(topPanel, BorderLayout.NORTH);

        receiptArea = new JTextArea(15, 40);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        receiptArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(receiptArea);
        add(scrollPane, BorderLayout.CENTER);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String paymentMethod = "";

                if (cashOption.isSelected()) {
                    paymentMethod = "Cash";
                } else if (cardOption.isSelected()) {
                    paymentMethod = "Card";
                } else {
                    JOptionPane.showMessageDialog(null, "❌ Please select a payment method.");
                    return;
                }

                int grandTotal = foodTotal + shippingCharge;
                int deliveryTime = new Random().nextInt(21) + 20;

                StringBuilder receipt = new StringBuilder();
                receipt.append("==================== INVOICE ====================\n");
                receipt.append("Restaurant       : " + restaurant[restaurantIndex] + "\n");
                receipt.append("Location         : " + location + "\n");
                receipt.append("Rider Assigned   : " + riderName + "\n");
                receipt.append("Delivery Time    : " + deliveryTime + " minutes\n");
                receipt.append("Payment Method   : " + paymentMethod.toUpperCase() + "\n");
                receipt.append("-----------------------------------------------\n");
                receipt.append("Food Total       : Rs " + foodTotal + "\n");
                receipt.append("Shipping Charges : Rs " + shippingCharge + "\n");
                receipt.append("GRAND TOTAL      : Rs " + grandTotal + "\n");
                receipt.append("================================================\n");
                receipt.append("     Thank you for ordering from foodpanda 🐼\n");

                receiptArea.setText(receipt.toString());
            }
        });

        setVisible(true);
    }
}