/*
Janny Jonyo
Bachelor of Informatics and Computer Science
166885
06/11/2023
*/

package com.Jonyo.pharma;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class DrugFrame extends JFrame implements ActionListener {

    private JLabel lblAddDrug, lblDrugName, lblQuantity, lblManufacturer, lblExpiryDate, lblUnitPrice, lblCopyright;

    private JTextField txtDrugName, txtQuantity, txtManufacturer, txtExpiryDate, txtUnitPrice;

    private JButton btnAddDrug;

    public DrugFrame() {

        super("Add A Drug");
        setLayout(null);
        setVisible(true);
        setSize(450, 500);
        setLocation(420, 100);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("syringe.png")));
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(222, 164, 80));

        lblAddDrug = new JLabel("Add Drug");
        lblAddDrug.setBounds(130, -80, 350, 250);
        lblDrugName = new JLabel("Drug Name");
        lblDrugName.setBounds(40, 120, 75, 25);
        lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(40, 170, 75, 25);
        lblManufacturer = new JLabel("Manufacturer");
        lblManufacturer.setBounds(40, 220, 100, 25);
        lblExpiryDate = new JLabel("Expiry Date");
        lblExpiryDate.setBounds(40, 270, 75, 25);
        lblUnitPrice = new JLabel("Unit Price");
        lblUnitPrice.setBounds(40, 320, 75, 25);
        Border lineBorder = new LineBorder(Color.BLACK, 2);
        txtDrugName = new JTextField(10);
        txtDrugName.setBounds(150, 120, 250, 25);
        txtDrugName.setBorder(lineBorder);
        txtQuantity = new JTextField(10);
        txtQuantity.setBounds(150, 170, 250, 25);
        txtQuantity.setBorder(lineBorder);
        txtManufacturer = new JTextField(10);
        txtManufacturer.setBounds(150, 220, 250, 25);
        txtManufacturer.setBorder(lineBorder);
        txtExpiryDate = new JTextField(10);
        txtExpiryDate.setBounds(150, 270, 250, 25);
        txtExpiryDate.setBorder(lineBorder);
        txtUnitPrice = new JTextField(10);
        txtUnitPrice.setBounds(150, 320, 250, 25);
        txtUnitPrice.setBorder(lineBorder);
        btnAddDrug = new JButton("Add Drug");
        btnAddDrug.setBounds(120, 370, 200, 25);
        lblCopyright = new JLabel("Copyright " + "\u00A9" + " 2023 by Janny Jonyo");
        lblCopyright.setBounds(120, 430, 200, 25);

        Font tahoma = new Font("Tahoma", Font.BOLD, 35);
        lblAddDrug.setFont(tahoma);
        lblAddDrug.setForeground(new Color(155, 70, 31));
        lblDrugName.setForeground(new Color(155, 70, 31));
        lblQuantity.setForeground(new Color(155, 70, 31));
        lblManufacturer.setForeground(new Color(155, 70, 31));
        lblExpiryDate.setForeground(new Color(155, 70, 31));
        lblUnitPrice.setForeground(new Color(155, 70, 31));
        btnAddDrug.setBackground(new Color(155, 70, 31));
        btnAddDrug.setForeground(new Color(222, 164, 80));

        add(lblAddDrug);
        add(lblDrugName);
        add(txtDrugName);
        add(lblQuantity);
        add(txtQuantity);
        add(lblManufacturer);
        add(txtManufacturer);
        add(lblExpiryDate);
        add(txtExpiryDate);
        add(lblUnitPrice);
        add(txtUnitPrice);
        add(btnAddDrug);
        add(lblCopyright);

        btnAddDrug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_janny_jonyo_166885?useSSL=false", "root", "147j9135");

                    String drugname = txtDrugName.getText();
                    String quantityStr = txtQuantity.getText();
                    String manufacturer = txtManufacturer.getText();
                    String expirydate = txtExpiryDate.getText();
                    String unitpriceStr = txtUnitPrice.getText();

                    Statement stm = con.createStatement();

                    if (drugname.isEmpty() || quantityStr.isEmpty() || manufacturer.isEmpty() || expirydate.isEmpty() || unitpriceStr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill in all required fields!");
                        return;
                    }

                    int quantity = Integer.parseInt(quantityStr);
                    double unitprice = Double.parseDouble(unitpriceStr);

                    String checkIfExistsQuery = "SELECT * FROM tbl_drug WHERE DrugName = ?";
                    PreparedStatement checkIfExistsStatement = con.prepareStatement(checkIfExistsQuery);
                    checkIfExistsStatement.setString(1, drugname);
                    ResultSet resultSet = checkIfExistsStatement.executeQuery();

                    if (resultSet.next()) {
                        int currentQuantity = resultSet.getInt("Quantity");
                        quantity += currentQuantity;

                        String updateQuery = "UPDATE tbl_drug SET Quantity = ? WHERE DrugName = ?";
                        PreparedStatement updateStatement = con.prepareStatement(updateQuery);
                        updateStatement.setInt(1, quantity);
                        updateStatement.setString(2, drugname);

                        int rowsAffected = updateStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Drug quantity updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to update drug quantity!");
                        }
                        updateStatement.close();
                    } else {
                        String insertQuery = "INSERT INTO tbl_drug (DrugName, Quantity, Manufacturer, ExpiryDate, UnitPrice) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement insertStatement = con.prepareStatement(insertQuery);
                        insertStatement.setString(1, drugname);
                        insertStatement.setInt(2, quantity);
                        insertStatement.setString(3, manufacturer);
                        insertStatement.setString(4, expirydate);
                        insertStatement.setDouble(5, unitprice);

                        int rowsAffected = insertStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Drug added successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Drug addition unsuccessful!");
                        }
                        insertStatement.close();
                    }

                    resultSet.close();
                    checkIfExistsStatement.close();
                    con.close();
                } catch (SQLException | ClassNotFoundException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
