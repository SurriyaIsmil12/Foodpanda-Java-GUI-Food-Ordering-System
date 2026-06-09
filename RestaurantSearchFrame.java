import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RestaurantSearchFrame extends JFrame {
    JComboBox<String> restaurantDropdown;
    JButton searchButton;

    static String[] restaurant = {"KFC", "MC Donalds", "Yasir Broast", "Bundu Khan"};
    static int selectedIndex = -1;

    public RestaurantSearchFrame() {
        setTitle("Choose Restaurant");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        add(new JLabel("Select Restaurant:"));

        restaurantDropdown = new JComboBox<>(restaurant);
        add(restaurantDropdown);

        searchButton = new JButton("Search");
        add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = (String) restaurantDropdown.getSelectedItem();

                for (int i = 0; i < restaurant.length; i++) {
                    if (restaurant[i].equalsIgnoreCase(selected)) {
                        selectedIndex = i;
                        break;
                    }
                }

                if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(null, "❌ Restaurant not found!");
                } else {
                    JOptionPane.showMessageDialog(null, "✅ Restaurant Found: " + restaurant[selectedIndex]);
                    dispose();
                    new MenuSelectionFrame(selectedIndex);
                }
            }
        });

        setVisible(true);
    }
}