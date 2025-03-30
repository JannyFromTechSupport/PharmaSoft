/*
Janny Jonyo
Bachelor of Informatics and Computer Science
166885
06/11/2023
*/

package com.Jonyo.pharma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class PharmacistFrame extends JFrame implements ActionListener {

    private JLabel lblPharmacist, lblPharmacistPassword, lblLogin, lblSignUp, lblCopyright;

    private JTextField txtPharmacist;

    private JPasswordField pswPharmacistPassword;

    private JButton btnLogin, btnSignUp, btnBack;

    public PharmacistFrame() {

        super("Pharmacist Login");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 440);
        setLocation(460, 180);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("syringe.png")));
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(189, 144, 246));

        lblLogin = new JLabel("Login");
        lblLogin.setBounds(140, -80, 350, 250);
        lblPharmacist = new JLabel("Username");
        lblPharmacist.setBounds(40,100,75,25);
        lblPharmacistPassword = new JLabel("Password");
        lblPharmacistPassword.setBounds(40, 180, 75, 25);
        lblSignUp = new JLabel("I don't have an account");
        lblSignUp.setBounds(40, 310, 300, 50);
        txtPharmacist = new JTextField(10);
        txtPharmacist.setBounds(40, 130, 300, 30);
        Border lineBorder = new LineBorder(Color.BLACK, 2);
        txtPharmacist.setBorder(lineBorder);
        pswPharmacistPassword = new JPasswordField(20);
        pswPharmacistPassword.setBounds(40, 210, 300, 30);
        pswPharmacistPassword.setBorder(lineBorder);
        btnLogin = new JButton("Login");
        btnLogin.setBounds(40, 270, 300, 30);
        btnLogin.setFocusable(false);
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(240, 320, 100, 30);
        btnSignUp.setFocusable(false);
        lblCopyright = new JLabel("Copyright " + "\u00A9" + " 2023 by Janny Jonyo");
        lblCopyright.setBounds(100, 260, 350, 250);
        btnBack = new JButton("Back");
        btnBack.setBounds(10, 10, 80, 25);
        btnBack.setFocusable(false);

        Font tahoma = new Font("Tahoma", Font.BOLD, 35);
        lblLogin.setFont(tahoma);
        lblLogin.setForeground(Color.WHITE);
        lblPharmacist.setForeground(Color.WHITE);
        lblPharmacistPassword.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(255, 189, 253));
        btnSignUp.setBackground(new Color(255, 189, 253));
        btnBack.setBackground(new Color(255, 189, 253));

        add(lblLogin);
        add(lblPharmacist);
        add(txtPharmacist);
        add(lblPharmacistPassword);
        add(pswPharmacistPassword);
        add(btnLogin);
        add(lblSignUp);
        add(btnSignUp);
        add(lblCopyright);
        add(btnBack);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_janny_jonyo_166885?useSSL=false","root","147j9135");

                    String username = txtPharmacist.getText();
                    char[] passwordChars = pswPharmacistPassword.getPassword();
                    String password = new String(passwordChars);

                    Statement stm = con.createStatement();

                    String sql = "select * from tbl_pharmacist where FirstName='"+username+"' and Passwords='"+password+"'";
                    ResultSet rs = stm.executeQuery(sql);

                    if (rs.next()) {
                        dispose();
                        Pharmacist pharmacist = new Pharmacist();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "username or password incorrect. Please try again");
                        txtPharmacist.setText("");
                        pswPharmacistPassword.setText("");
                    }

                    con.close();

                }catch(Exception a) {
                    System.out.println(a.getMessage());
                }
            }
        });
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PharmacistSignUp pharmacistsignup = new PharmacistSignUp();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                WelcomeScreen welcomescreen = new WelcomeScreen();
                welcomescreen.setVisible(true);
                welcomescreen.setSize(400, 400);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

/*
Janny Jonyo
Bachelor of Informatics and Computer Science
166885
06/11/2023
*/

class PharmacistSignUp extends JFrame implements ActionListener{

    private JLabel lblSignUp, lblFirstName, lblLastName, lblPassword, lblCopyright;

    private JTextField txtFirstName, txtLastName;

    private JPasswordField pswPassword;

    private JButton btnSignUp, btnBack;

    public PharmacistSignUp(){

        super("Pharmacist Sign Up");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 440);
        setLocation(460, 180);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("syringe.png")));
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(189, 144, 246));

        lblSignUp = new JLabel("Sign Up");
        lblSignUp.setBounds(130, -80, 350, 250);
        lblFirstName = new JLabel("First Name");
        lblFirstName.setBounds(40,150,75,25);
        lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(40,200,75,25);
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(40, 250, 75, 25);
        Border lineBorder = new LineBorder(Color.BLACK, 2);
        txtFirstName= new JTextField(10);
        txtFirstName.setBounds(150, 150, 200, 25);
        txtFirstName.setBorder(lineBorder);
        txtLastName = new JTextField(10);
        txtLastName.setBounds(150, 200, 200, 25);
        txtLastName.setBorder(lineBorder);
        pswPassword = new JPasswordField(20);
        pswPassword.setBounds(150, 250, 200, 25);
        pswPassword.setBorder(lineBorder);
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(90, 300, 200, 25);
        lblCopyright = new JLabel("Copyright " + "\u00A9" + " 2023 by Janny Jonyo");
        lblCopyright.setBounds(100, 260, 350, 250);
        btnBack = new JButton("Back");
        btnBack.setBounds(10, 10, 80, 25);
        btnBack.setFocusable(false);

        Font tahoma = new Font("Tahoma", Font.BOLD, 35);
        lblSignUp.setFont(tahoma);
        lblSignUp.setForeground(Color.WHITE);
        lblFirstName.setForeground(Color.WHITE);
        lblLastName.setForeground(Color.WHITE);
        lblPassword.setForeground(Color.WHITE);
        btnSignUp.setBackground(new Color(255, 189, 253));
        btnBack.setBackground(new Color(255, 189, 253));

        add(lblSignUp);
        add(lblFirstName);
        add(txtFirstName);
        add(lblLastName);
        add(txtLastName);
        add(lblPassword);
        add(pswPassword);
        add(btnSignUp);
        add(lblCopyright);
        add(btnBack);

        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_janny_jonyo_166885?useSSL=false","root","147j9135");

                    String firstname = txtFirstName.getText();
                    String lastname = txtLastName.getText();
                    String password = pswPassword.getText();

                    Statement stm = con.createStatement();

                    if (firstname.isEmpty() || lastname.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill in all required fields!");
                        return;
                    }

                    String sql = "insert into tbl_pharmacist (FirstName, LastName, Passwords) values (?, ?, ?)";
                    PreparedStatement preparedstatement = con.prepareStatement(sql);
                    preparedstatement.setString(1, firstname);
                    preparedstatement.setString(2, lastname);
                    preparedstatement.setString(3, password);
                    int rowsAffected = preparedstatement.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Pharmacist signed up successfully!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Pharmacist sign up unsuccessful!");
                    }
                    preparedstatement.close();
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
                dispose();
                Pharmacist pharmacist = new Pharmacist();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PharmacistFrame pharmacistframe = new PharmacistFrame();
                pharmacistframe.setVisible(true);
                pharmacistframe.setSize(400, 440);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

/*
Janny Jonyo
Bachelor of infomatics and Computer Science
166885
06/11/2023
*/

class Pharmacist extends JFrame implements ActionListener{

    private ExpiredDrugs expireddrugs;

    private JLabel lblCopyright;

    private JButton btnAddDrug, btnRemoveDrug, btnSellDrug, btnHome;

    public Pharmacist() {

        super("Pharmacist");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(700, 500);
        setLocation(290, 115);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("syringe.png")));
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(92, 219, 149));

        expireddrugs = new ExpiredDrugs();
        btnAddDrug = new JButton("Add A New Drug");
        btnAddDrug.setBounds(70, 230, 560, 40);
        btnAddDrug.setFocusable(false);
        btnRemoveDrug = new JButton("Remove Expired Drug");
        btnRemoveDrug.setBounds(70, 300, 560, 40);
        btnRemoveDrug.setFocusable(false);
        btnSellDrug = new JButton("Sell Drug");
        btnSellDrug.setBounds(70, 370, 560, 40);
        btnSellDrug.setFocusable(false);
        lblCopyright = new JLabel("Copyright " + "\u00A9" + " 2023 by Janny Jonyo");
        lblCopyright.setBounds(260, 430, 300, 25);
        btnHome = new JButton("Home");
        btnHome.setBounds(10, 10, 80, 25);
        btnHome.setFocusable(false);

        ImageIcon originalIcon2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("syringe.png")));
        Image originalImage2 = originalIcon2.getImage();
        Image scaledImage2 = originalImage2.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        JLabel imageLabel2 = new JLabel(scaledIcon2);
        imageLabel2.setBounds(260, 10, 200, 200);

        Font tahoma = new Font("Tahoma", Font.BOLD, 15);
        btnAddDrug.setFont(tahoma);
        btnRemoveDrug.setFont(tahoma);
        btnSellDrug.setFont(tahoma);
        btnAddDrug.setForeground(Color.WHITE);
        btnRemoveDrug.setForeground(Color.WHITE);
        btnSellDrug.setForeground(Color.WHITE);
        btnAddDrug.setBackground(new Color(56, 176, 250));
        btnRemoveDrug.setBackground(new Color(56, 176, 250));
        btnSellDrug.setBackground(new Color(56, 176, 250));
        lblCopyright.setForeground(Color.WHITE);
        btnHome.setBackground(new Color(56, 176, 250));
        btnHome.setForeground(Color.WHITE);

        add(btnAddDrug);
        add(btnRemoveDrug);
        add(btnSellDrug);
        add(lblCopyright);
        add(imageLabel2);
        add(btnHome);

        btnAddDrug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrugFrame drugframe = new DrugFrame();
            }
        });
        btnRemoveDrug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expireddrugs.showExpiredDrugs();
                expireddrugs.setVisible(true);
            }
        });
        btnSellDrug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransactionFrame transactionframe = new TransactionFrame();
            }
        });
        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                WelcomeScreen welcomescreen = new WelcomeScreen();
                welcomescreen.setVisible(true);
                welcomescreen.setSize(400, 400);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

/*
Janny Jonyo
Bachelor of Informatics and Computer Science
166885
06/11/2023
*/

class ExpiredDrugs extends JFrame {

    private JTable drugTable;
    private DefaultTableModel drugTableModel;

    public ExpiredDrugs() {
        setTitle("Expired Drugs");
        setVisible(false);
        setSize(600, 400);
        setLocation(380, 160);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("syringe.png")));
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(189, 144, 246));

        JPanel panel = new JPanel(new BorderLayout());

        drugTableModel = new DefaultTableModel();
        drugTableModel.addColumn("DrugID");
        drugTableModel.addColumn("Drug Name");
        drugTableModel.addColumn("Quantity");
        drugTableModel.addColumn("Manufacturer");
        drugTableModel.addColumn("Expiry Date");
        drugTableModel.addColumn("Unit Price");

        drugTable = new JTable(drugTableModel);

        JScrollPane scrollPane = new JScrollPane(drugTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnRemoveDrug = new JButton("Remove Expired Drugs");
        btnRemoveDrug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedDrug();
            }
        });
        panel.add(btnRemoveDrug, BorderLayout.SOUTH);

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showExpiredDrugs();
            }
        });
        panel.add(btnRefresh, BorderLayout.NORTH);

        add(panel);
    }

    public void showExpiredDrugs() {
        drugTableModel.setRowCount(0);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_janny_jonyo_166885", "root", "147j9135")) {
            String sql = "SELECT * FROM tbl_drug WHERE ExpiryDate < ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setDate(1, new java.sql.Date(System.currentTimeMillis()));

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Object[] rowData = {
                                resultSet.getInt("DrugID"),
                                resultSet.getString("DrugName"),
                                resultSet.getInt("Quantity"),
                                resultSet.getString("Manufacturer"),
                                resultSet.getDate("ExpiryDate"),
                                resultSet.getDouble("UnitPrice")
                        };
                        drugTableModel.addRow(rowData);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteSelectedDrug() {
        int selectedRow = drugTable.getSelectedRow();
        if (selectedRow != -1) {
            int confirmResult = JOptionPane.showConfirmDialog(this, "Do you want to remove the selected drug?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirmResult == JOptionPane.YES_OPTION) {
                int drugID = (int) drugTable.getValueAt(selectedRow, 0);
                deleteDrug(drugID);
            }
        }
    }

    private void deleteDrug(int drugID) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_janny_jonyo_166885", "root", "147j9135")) {
            String deleteSql = "DELETE FROM tbl_drug WHERE DrugID = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
                deleteStatement.setInt(1, drugID);
                int rowsAffected = deleteStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Drug removed successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to remove drug.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}

/*
Janny Jonyo
Bachelor of Informatics and Computer Science
166885
06/11/2023
*/

class TransactionFrame extends JFrame implements ActionListener {

    private JLabel lblMakeTransaction, lblPharmacistID, lblPrescriptionID, lblDrugName, lblQuantity, lblTransactionDate, lblTotalAmount, lblCopyright;

    private JTextField txtPharmacistID, txtPrescriptionID, txtDrugName, txtQuantity, txtTransactionDate, txtTotalAmount;

    private JButton btnMake;

    public TransactionFrame() {

        super("Transaction Form");
        setLayout(null);
        setVisible(true);
        setSize(475, 550);
        setLocation(435, 100);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("syringe.png")));
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(222, 164, 80));

        lblMakeTransaction = new JLabel("Make Transaction");
        lblMakeTransaction.setBounds(80, -80, 350, 250);
        lblPharmacistID = new JLabel("Pharmacist ID");
        lblPharmacistID.setBounds(40, 100, 150, 30);
        lblPrescriptionID = new JLabel("Prescription ID");
        lblPrescriptionID.setBounds(40, 160, 150, 25);
        lblDrugName = new JLabel("Drug Name");
        lblDrugName.setBounds(40, 220, 150, 25);
        lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(40, 280, 100, 25);
        lblTransactionDate = new JLabel("Transaction Date");
        lblTransactionDate.setBounds(40, 340,  100, 25);
        lblTotalAmount = new JLabel("Total Amount");
        lblTotalAmount.setBounds(40, 400, 100, 25);
        Border lineBorder = new LineBorder(Color.BLACK, 2);
        txtPharmacistID = new JTextField(10);
        txtPharmacistID.setBounds(150, 100, 270, 25);
        txtPharmacistID.setBorder(lineBorder);
        txtPrescriptionID = new JTextField(10);
        txtPrescriptionID.setBounds(150, 160, 270, 25);
        txtPrescriptionID.setBorder(lineBorder);
        txtDrugName = new JTextField(10);
        txtDrugName.setBounds(150, 220, 125, 25);
        txtDrugName.setBorder(lineBorder);
        txtQuantity = new JTextField(10);
        txtQuantity.setBounds(150, 280, 270, 25);
        txtQuantity.setBorder(lineBorder);
        txtTransactionDate = new JTextField(10);
        txtTransactionDate.setBounds(150, 340, 270, 25);
        txtTransactionDate.setBorder(lineBorder);
        txtTotalAmount = new JTextField(10);
        txtTotalAmount.setBounds(150, 400, 270, 25);
        txtTotalAmount.setBorder(lineBorder);
        btnMake = new JButton("Make Transaction");
        btnMake.setBounds(80, 445, 270, 25);
        btnMake.setFocusable(false);

        lblCopyright = new JLabel("Copyright " + "\u00A9" + " 2023 by Janny Jonyo");
        lblCopyright.setBounds(130, 445, 300, 100);

        JButton btnSearchPrescription = new JButton("Prescriptions");
        btnSearchPrescription.setBounds(280, 220, 125, 25);
        btnSearchPrescription.setFocusable(false);
        btnSearchPrescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayPrescriptionDialog displayprescriptiondialog = new DisplayPrescriptionDialog(TransactionFrame.this);
                displayprescriptiondialog.setVisible(true);
            }
        });

        Font tahoma = new Font("Tahoma", Font.BOLD, 35);
        lblMakeTransaction.setFont(tahoma);
        lblMakeTransaction.setForeground(new Color(155, 70, 31));
        lblPharmacistID.setForeground(new Color(155, 70, 31));
        lblPrescriptionID.setForeground(new Color(155, 70, 31));
        lblDrugName.setForeground(new Color(155, 70, 31));
        lblQuantity.setForeground(new Color(155, 70, 31));
        lblTransactionDate.setForeground(new Color(155, 70, 31));
        lblTotalAmount.setForeground(new Color(155, 70, 31));
        btnMake.setBackground(new Color(155, 70, 31));
        btnMake.setForeground(new Color(222, 164, 80));

        add(lblMakeTransaction);
        add(lblPharmacistID);
        add(txtPharmacistID);
        add(lblPrescriptionID);
        add(txtPrescriptionID);
        add(lblDrugName);
        add(txtDrugName);
        add(btnSearchPrescription);
        add(lblQuantity);
        add(txtQuantity);
        add(lblTransactionDate);
        add(txtTransactionDate);
        add(lblTotalAmount);
        add(txtTotalAmount);
        add(btnMake);
        add(lblCopyright);

        btnMake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeTransaction();
            }
        });
    }

    private void makeTransaction() {
        if (txtPharmacistID.getText().isEmpty() || txtPrescriptionID.getText().isEmpty() || txtDrugName.getText().isEmpty() || txtQuantity.getText().isEmpty() || txtTransactionDate.getText().isEmpty() || txtTotalAmount.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_janny_jonyo_166885", "root", "147j9135");
            connection.setAutoCommit(false);

            String insertTransactionSql = "INSERT INTO tbl_transaction (PharmacistID, PrescriptionID, DrugName, Quantity, TransactionDate, TotalAmount) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement insertTransactionStatement = connection.prepareStatement(insertTransactionSql, Statement.RETURN_GENERATED_KEYS)) {
                insertTransactionStatement.setInt(1, Integer.parseInt(txtPharmacistID.getText()));
                insertTransactionStatement.setInt(2, Integer.parseInt(txtPrescriptionID.getText()));
                insertTransactionStatement.setString(3, txtDrugName.getText());
                insertTransactionStatement.setInt(4, Integer.parseInt(txtQuantity.getText()));
                insertTransactionStatement.setString(5, txtTransactionDate.getText());
                insertTransactionStatement.setDouble(6, Double.parseDouble(txtTotalAmount.getText()));

                int rowsAffected = insertTransactionStatement.executeUpdate();
                if (rowsAffected > 0) {
                    try (ResultSet generatedKeys = insertTransactionStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int transactionID = generatedKeys.getInt(1);

                            String updateDrugQuantitySql = "UPDATE tbl_drug SET Quantity = Quantity - ? WHERE DrugName = ?";
                            try (PreparedStatement updateDrugQuantityStatement = connection.prepareStatement(updateDrugQuantitySql)) {
                                updateDrugQuantityStatement.setInt(1, Integer.parseInt(txtQuantity.getText()));
                                updateDrugQuantityStatement.setString(2, txtDrugName.getText());
                                updateDrugQuantityStatement.executeUpdate();
                            }

                            connection.commit();
                            JOptionPane.showMessageDialog(this, "Transaction completed successfully!");
                            clearFields();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to save prescription.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | NumberFormatException ex) {
            ex.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Error occurred while saving prescription.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private void clearFields() {
        txtPharmacistID.setText("");
        txtPrescriptionID.setText("");
        txtDrugName.setText("");
        txtQuantity.setText("");
        txtTransactionDate.setText("");
        txtTotalAmount.setText("");
    }

    public void setSelectedPrescription(int selectedPrescriptionID, String selectedDrugName, int selectedQuantity, double totalAmount) {
        txtPrescriptionID.setText(String.valueOf(selectedPrescriptionID));
        txtDrugName.setText(selectedDrugName);
        txtQuantity.setText(String.valueOf(selectedQuantity));
        txtTotalAmount.setText(String.valueOf(totalAmount));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

/*
Janny Jonyo
Bachelor of Informatics and Computer Science
166885
06/11/2023
*/

class DisplayPrescriptionDialog extends JDialog {

    private JTable prescriptionTable;
    private DefaultTableModel prescriptionTableModel;

    public DisplayPrescriptionDialog(JFrame parent) {
        super(parent, "Prescriptions", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);

        prescriptionTableModel = new DefaultTableModel();
        prescriptionTableModel.addColumn("Prescription ID");
        prescriptionTableModel.addColumn("Drug Name");
        prescriptionTableModel.addColumn("Drug Quantity");
        prescriptionTable = new JTable(prescriptionTableModel);

        loadAllPrescriptions();

        JButton btnSelect = new JButton("Select");
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSelect();
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(prescriptionTable), BorderLayout.CENTER);
        add(btnSelect, BorderLayout.SOUTH);
    }

    private void loadAllPrescriptions() {
        prescriptionTableModel.setRowCount(0);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_janny_jonyo_166885", "root", "147j9135")) {
            String sql = "SELECT PrescriptionID, DrugName, Quantity FROM tbl_prescription";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int prescriptionID = resultSet.getInt("PrescriptionID");
                        String drugName = resultSet.getString("DrugName");
                        int quantity = resultSet.getInt("Quantity");
                        prescriptionTableModel.addRow(new Object[]{prescriptionID, drugName, quantity});
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while loading prescriptions.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleSelect() {
        int selectedRow = prescriptionTable.getSelectedRow();
        if (selectedRow != -1) {
            int selectedPrescriptionID = (int) prescriptionTableModel.getValueAt(selectedRow, 0);
            String selectedDrugName = (String) prescriptionTableModel.getValueAt(selectedRow, 1);
            int selectedQuantity = (int) prescriptionTableModel.getValueAt(selectedRow, 2);

            double unitPrice = getUnitPrice(selectedDrugName);

            double totalAmount = selectedQuantity * unitPrice;

            ((TransactionFrame) getParent()).setSelectedPrescription(selectedPrescriptionID, selectedDrugName, selectedQuantity, totalAmount);

            dispose();
        }
    }

    private double getUnitPrice(String drugName) {
        double unitPrice = 0.0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_janny_jonyo_166885", "root", "147j9135")) {
            String sql = "SELECT UnitPrice FROM tbl_Drug WHERE DrugName = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, drugName);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        unitPrice = resultSet.getDouble("UnitPrice");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while fetching unit price.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return unitPrice;

    }

}
