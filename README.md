# Foodpanda-Java-GUI-Food-Ordering-System
 Foodpanda — Java GUI Food Ordering System
A Java Swing-based food ordering desktop application developed as a Programming Fundamentals final project at the University of Central Punjab (UCP).


📋 Project Overview
This application simulates a food delivery ordering system inspired by Foodpanda. The user can log in, choose a restaurant, select menu items, enter delivery info, and receive a final invoice.

🗂️ Project Structure
FoodpandaProject/
│
├── Phase2_GUI/               ← GUI only (no file handling)
│   ├── LoginFrame.java
│   ├── RestaurantSearchFrame.java
│   ├── MenuSelectionFrame.java
│   ├── DeliveryFrame.java
│   └── PaymentFrame.java
│
└── Phase3_FileHandling/      ← GUI + file handling
    ├── LoginFrame.java
    ├── RestaurantSearchFrame.java
    ├── MenuSelectionFrame.java
    ├── DeliveryFrame.java
    └── PaymentFrame.java

🔄 Application Flow
Login → Restaurant Selection → Menu Selection → Delivery Info → Payment & Receipt
FrameDescriptionLoginFrameUsername/password login with input validationRestaurantSearchFrameDropdown to select from KFC, MC Donalds, Yasir Broast, Bundu KhanMenuSelectionFrameItem selection with quantity and running totalDeliveryFrameLocation input, auto rider assignment, shipping charge calculationPaymentFrameCash/Card payment, final invoice display

📁 File Handling (Phase 3)
Phase 3 adds automatic file logging at each step:
FileContentslogins.txtSaved username and password on each loginrestaurant_selection.txtSelected restaurant nameorder.txtItem, quantity, and subtotal per orderdelivery.txtLocation, assigned rider, shipping chargesreceipt.txtFull invoice saved after payment confirmation

▶️ How to Run

Open the project in IntelliJ IDEA or Eclipse
Navigate to either Phase2_GUI/ or Phase3_FileHandling/
Run LoginFrame.java — it contains the main method
All frames open automatically as you proceed through the app


Note: Phase 3 will generate .txt files in the same directory where you run the project.


🛠️ Technologies Used

Java — Core language
Java Swing — GUI framework (JFrame, JPanel, JComboBox, JTextArea, etc.)
Java I/O — FileWriter, BufferedWriter, PrintWriter for file handling


🎓 Course
Programming Fundamentals — University of Central Punjab (UCP)
Faculty of Information Technology and Computer Science
