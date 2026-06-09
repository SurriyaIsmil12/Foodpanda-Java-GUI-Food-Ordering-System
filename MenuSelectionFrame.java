import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuSelectionFrame extends JFrame {
    static String[][] menu = {
            {"Zinger Burger", "Fries", "Cold Drinks", "Ice Cream", "Chicken Piece"},
            {"Big Mac Burger", "Ice Cream", "Cold Drink", "Chicken Wings", "Chicken Piece"},
            {"Chicken Karahi", "Mutton Karahi", "BBQ", "Sajji", "Roti/Naan"},
            {"Sandwiches", "Beef Burger", "Rice", "Juices", "Salad"}
    };

    static int[][] prices = {
            {400, 250, 200, 150, 650},
            {500, 200, 200, 600, 750},
            {2200, 2600, 300, 1600, 23},
            {350, 850, 1200, 550, 400}
    };

    int selectedIndex;
    JComboBox<String> itemDropdown;
    JTextField quantityField;
    JLabel totalLabel;
    JButton addButton, nextButton;

    int foodTotal = 0;

    public MenuSelectionFrame(int restaurantIndex) {
        this.selectedIndex = restaurantIndex;
        setTitle("Menu - " + RestaurantSearchFrame.restaurant[restaurantIndex]);
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JPanel menuPanel = new JPanel();
        menuPanel.add(new JLabel("Select Item:"));
        itemDropdown = new JComboBox<>(menu[restaurantIndex]);
        menuPanel.add(itemDropdown);
        add(menuPanel);

        JPanel qtyPanel = new JPanel();
        qtyPanel.add(new JLabel("Enter Quantity:"));
        quantityField = new JTextField(10);
        qtyPanel.add(quantityField);
        add(qtyPanel);

        totalLabel = new JLabel("Total: Rs 0");
        add(totalLabel);

        addButton = new JButton("Add to Order");
        add(addButton);

        nextButton = new JButton("Next ➡️");
        add(nextButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int qty = Integer.parseInt(quantityField.getText());
                    if (qty <= 0) throw new NumberFormatException();

                    int itemIndex = itemDropdown.getSelectedIndex();
                    int price = prices[restaurantIndex][itemIndex];
                    int total = qty * price;
                    foodTotal += total;

                    totalLabel.setText("Total: Rs " + foodTotal);
                    JOptionPane.showMessageDialog(null, "✔ " + qty + " x " + menu[restaurantIndex][itemIndex] + " added to order!");
                    quantityField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "❌ Please enter a valid quantity (positive number).");
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DeliveryFrame(restaurantIndex, foodTotal);
            }
        });

        setVisible(true);
    }
}
