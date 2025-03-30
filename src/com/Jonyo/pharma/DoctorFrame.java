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

public class DoctorFrame extends JFrame implements ActionListener {

    private JLabel lblDoctor, lblDoctorPassword, lblLogin, lblSignUp, lblCopyright;

    private JTextField txtDoctor;

    private JPasswordField pswDoctorPassword;

    private JButton btnLogin, btnSignUp, btnBack;

    public DoctorFrame() {

        super("Doctor Login");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 440);
        setLocation(460, 180);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("doctor.png")));
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(189, 144, 246));

        lblLogin = new JLabel("Login");
        lblLogin.setBounds(140, -80, 350, 250);
        lblDoctor = new JLabel("Username");
        lblDoctor.setBounds(40,100,75,25);
        lblDoctorPassword = new JLabel("Password");
        lblDoctorPassword.setBounds(40, 180, 75, 25);
        lblSignUp = new JLabel("I don't have an account");
        lblSignUp.setBounds(40, 310, 300, 50);
        txtDoctor = new JTextField(10);
        txtDoctor.setBounds(40, 130, 300, 30);
        Border lineBorder = new LineBorder(Color.BLACK, 2);
        txtDoctor.setBorder(lineBorder);
        pswDoctorPassword = new JPasswordField(20);
        pswDoctorPassword.setBounds(40, 210, 300, 30);
        pswDoctorPassword.setBorder(lineBorder);
        btnLogin = new JButton("Login");
        btnLogin.setBounds(40, 270, 300, 30);
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(240, 320, 100, 30);
        lblCopyright = new JLabel("Copyright " + "\u00A9" + " 2023 by Janny Jonyo");
        lblCopyright.setBounds(100, 260, 350, 250);
        btnBack = new JButton("Back");
        btnBack.setBounds(10, 10, 80, 25);
        btnBack.setFocusable(false);

        Font tahoma = new Font("Tahoma", Font.BOLD, 35);
        lblLogin.setFont(tahoma);
        lblLogin.setForeground(Color.WHITE);
        lblDoctor.setForeground(Color.WHITE);
        lblDoctorPassword.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(255, 189, 253));
        btnSignUp.setBackground(new Color(255, 189, 253));
        btnBack.setBackground(new Color(255, 189, 253));

        add(lblLogin);
        add(lblDoctor);
        add(txtDoctor);
        add(lblDoctorPassword);
        add(pswDoctorPassword);
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

                    String username = txtDoctor.getText();
                    char[] passwordChars = pswDoctorPassword.getPassword();
                    String password = new String(passwordChars);

                    Statement stm = con.createStatement();

                    String sql = "select * from tbl_doctor where FirstName='"+username+"' and Passwords='"+password+"'";
                    ResultSet rs = stm.executeQuery(sql);

                    if (rs.next()) {
                        dispose();
                        Doctor doctor = new Doctor();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "username or password incorrect. Please try again");
                        txtDoctor.setText("");
                        pswDoctorPassword.setText("");
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
                DoctorSignUp doctorsignup = new DoctorSignUp();
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

class DoctorSignUp extends JFrame implements ActionListener{

    private JLabel lblSignUp, lblFirstName, lblLastName, lblPassword, lblCopyright;

    private JTextField txtFirstName, txtLastName;

    private JPasswordField pswPassword;

    private JButton btnSignUp, btnBack;

    public DoctorSignUp(){

        super("Doctor Sign Up");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 440);
        setLocation(460, 180);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("doctor.png")));
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
        txtFirstName= new JTextField(200);
        txtFirstName.setBounds(150, 150, 200, 25);
        txtFirstName.setBorder(lineBorder);
        txtLastName = new JTextField(200);
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

                    String sql = "insert into tbl_doctor (FirstName, LastName, Passwords) values (?, ?, ?)";
                    PreparedStatement preparedstatement = con.prepareStatement(sql);
                    preparedstatement.setString(1, firstname);
                    preparedstatement.setString(2, lastname);
                    preparedstatement.setString(3, password);
                    int rowsAffected = preparedstatement.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Doctor signed up successfully!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Doctor sign up unsuccessful!");
                    }
                    preparedstatement.close();
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
                dispose();
                Doctor doctor = new Doctor();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DoctorFrame doctorframe = new DoctorFrame();
                doctorframe.setVisible(true);
                doctorframe.setSize(400, 440);
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

class Doctor extends JFrame implements ActionListener{

    private JLabel lblCopyright;

    private JButton btnPrescribe, btnHome;

    public Doctor() {

        super("Doctor");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 440);
        setLocation(460, 180);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("doctor.png")));
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(92, 219, 149));

        btnPrescribe = new JButton("Prescribe Drugs");
        btnPrescribe.setBounds(70, 270, 250, 50);
        Border lineborder = new LineBorder(Color.BLACK, 2);
        btnPrescribe.setFocusable(false);
        lblCopyright = new JLabel("Copyright " + "\u00A9" + " 2023 by Janny Jonyo");
        lblCopyright.setBounds(100, 260, 350, 250);
        btnHome = new JButton("Home");
        btnHome.setBounds(10, 10, 80, 25);
        btnHome.setFocusable(false);

        ImageIcon originalIcon1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("doctor.png")));
        Image originalImage1 = originalIcon1.getImage();
        Image scaledImage1 = originalImage1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel imageLabel1 = new JLabel(scaledIcon1);
        imageLabel1.setBounds(90, 40, 200, 200);

        Font tahoma = new Font("Tahoma", Font.BOLD, 15);
        btnPrescribe.setFont(tahoma);
        btnPrescribe.setBackground(new Color(56, 176, 250));
        btnPrescribe.setForeground(Color.WHITE);
        lblCopyright.setForeground(Color.WHITE);
        btnHome.setBackground(new Color(56, 176, 250));
        btnHome.setForeground(Color.WHITE);

        add(btnPrescribe);
        add(imageLabel1);
        add(lblCopyright);
        add(btnHome);

        btnPrescribe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrescriptionFrame prescriptionframe = new PrescriptionFrame();
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

class PrescriptionFrame extends JFrame implements ActionListener {

    private JLabel lblGivePrescription, lblDoctorID, lblPatientName, lblDrugID, lblDrugName, lblQuantity, lblIssueDate, lblCopyright;

    private JTextField txtDoctorID, txtPatientName, txtDrugID, txtDrugName, txtQuantity, txtIssueDate;

    private JButton btnSave;

    public PrescriptionFrame() {

        super("Prescription Form");
        setLayout(null);
        setVisible(true);
        setSize(460, 550);
        setLocation(420, 90);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("doctor.png")));
        setIconImage(image.getImage());
        getContentPane().setBackground(new Color(222, 164, 80));

        lblGivePrescription = new JLabel("Give Prescription");
        lblGivePrescription.setBounds(80, -80, 350, 250);
        lblDoctorID = new JLabel("Doctor ID");
        lblDoctorID.setBounds(40, 100, 150, 30);
        lblPatientName = new JLabel("Patient Name");
        lblPatientName.setBounds(40, 160, 150, 25);
        lblDrugID = new JLabel("Drug ID");
        lblDrugID.setBounds(40, 220, 150, 25);
        lblDrugName = new JLabel("Drug Name");
        lblDrugName.setBounds(40, 280, 100, 25);
        lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(40, 340,  100, 25);
        lblIssueDate = new JLabel("Issue Date");
        lblIssueDate.setBounds(40, 400, 100, 25);
        Border lineBorder = new LineBorder(Color.BLACK, 2);
        txtDoctorID = new JTextField(10);
        txtDoctorID.setBounds(140, 100, 270, 25);
        txtDoctorID.setBorder(lineBorder);
        txtPatientName = new JTextField(10);
        txtPatientName.setBounds(140, 160, 270, 25);
        txtPatientName.setBorder(lineBorder);
        txtDrugID = new JTextField(10);
        txtDrugID.setBounds(140, 220, 125, 25);
        txtDrugID.setBorder(lineBorder);
        txtDrugID.setEditable(false);
        txtDrugName = new JTextField(10);
        txtDrugName.setBounds(140, 280, 270, 25);
        txtDrugName.setBorder(lineBorder);
        txtQuantity = new JTextField(10);
        txtQuantity.setBounds(140, 340, 270, 25);
        txtQuantity.setBorder(lineBorder);
        txtIssueDate = new JTextField(10);
        txtIssueDate.setBounds(140, 400, 270, 25);
        txtIssueDate.setBorder(lineBorder);
        btnSave = new JButton("Save Prescription");
        btnSave.setBounds(80, 445, 270, 25);
        btnSave.setFocusable(false);

        lblCopyright = new JLabel("Copyright " + "\u00A9" + " 2023 by Janny Jonyo");
        lblCopyright.setBounds(130, 445, 300, 100);

        JButton btnSearchDrug = new JButton("Search Drug");
        btnSearchDrug.setBounds(280, 220, 125, 25);
        btnSearchDrug.setFocusable(false);
        btnSearchDrug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrugSearchDialog drugSearchDialog = new DrugSearchDialog(PrescriptionFrame.this);
                drugSearchDialog.setVisible(true);
            }
        });

        Font tahoma = new Font("Tahoma", Font.BOLD, 35);
        lblGivePrescription.setFont(tahoma);
        lblGivePrescription.setForeground(new Color(155, 70, 31));
        lblDoctorID.setForeground(new Color(155, 70, 31));
        lblPatientName.setForeground(new Color(155, 70, 31));
        lblDrugID.setForeground(new Color(155, 70, 31));
        lblDrugName.setForeground(new Color(155, 70, 31));
        lblQuantity.setForeground(new Color(155, 70, 31));
        lblIssueDate.setForeground(new Color(155, 70, 31));
        btnSave.setBackground(new Color(155, 70, 31));
        btnSave.setForeground(new Color(222, 164, 80));

        add(lblGivePrescription);
        add(lblDoctorID);
        add(txtDoctorID);
        add(lblPatientName);
        add(txtPatientName);
        add(lblDrugID);
        add(btnSearchDrug);
        add(lblIssueDate);
        add(txtIssueDate);
        add(txtDrugID);
        add(lblDrugName);
        add(txtDrugName);
        add(lblQuantity);
        add(txtQuantity);
        add(btnSave);
        add(lblCopyright);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savePrescription();
            }
        });
    }

    private void savePrescription() {
        if (txtDoctorID.getText().isEmpty() || txtPatientName.getText().isEmpty() || txtDrugID.getText().isEmpty() || txtDrugName.getText().isEmpty() || txtQuantity.getText().isEmpty() || txtIssueDate.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_janny_jonyo_166885", "root", "147j9135")) {
            String sql = "INSERT INTO tbl_prescription (DoctorID, PatientName, DrugID, DrugName, Quantity, IssueDate) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, Integer.parseInt(txtDoctorID.getText()));
                preparedStatement.setString(2, txtPatientName.getText());
                preparedStatement.setInt(3, Integer.parseInt(txtDrugID.getText()));
                preparedStatement.setString(4, txtDrugName.getText());
                preparedStatement.setInt(5, Integer.parseInt(txtQuantity.getText()));
                preparedStatement.setString(6, txtIssueDate.getText());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Prescription saved successfully!");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to save prescription.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException | NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while saving prescription.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtDoctorID.setText("");
        txtPatientName.setText("");
        txtDrugID.setText("");
        txtDrugName.setText("");
        txtQuantity.setText("");
        txtIssueDate.setText("");
    }

    public void setSelectedDrug(String selectedDrugName, int selectedDrugID) {
        txtDrugName.setText(selectedDrugName);
        txtDrugID.setText(String.valueOf(selectedDrugID));
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

class DrugSearchDialog extends JDialog {

    private JTextField txtSearch;
    private JTable drugTable;
    private DefaultTableModel drugTableModel;

    public DrugSearchDialog(JFrame parent) {
        super(parent, "Drug Search", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);

        txtSearch = new JTextField(15);
        drugTableModel = new DefaultTableModel();
        drugTableModel.addColumn("Drug Name");
        drugTableModel.addColumn("Drug ID");
        drugTable = new JTable(drugTableModel);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchDrugs();
            }
        });

        JButton btnSelect = new JButton("Select");
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSelect();
            }
        });

        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(txtSearch);
        topPanel.add(btnSearch);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(drugTable), BorderLayout.CENTER);
        add(btnSelect, BorderLayout.SOUTH);
    }

    private void searchDrugs() {
        drugTableModel.setRowCount(0);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_janny_jonyo_166885", "root", "147j9135")) {
            String sql = "SELECT DrugName, DrugID FROM tbl_drug WHERE DrugName LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, "%" + txtSearch.getText() + "%");

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String drugName = resultSet.getString("DrugName");
                        int drugID = resultSet.getInt("DrugID");
                        drugTableModel.addRow(new Object[]{drugName, drugID});
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while searching for drugs.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleSelect() {
        int selectedRow = drugTable.getSelectedRow();
        if (selectedRow != -1) {
            String selectedDrugName = (String) drugTableModel.getValueAt(selectedRow, 0);
            int selectedDrugID = (int) drugTableModel.getValueAt(selectedRow, 1);

            ((PrescriptionFrame) getParent()).setSelectedDrug(selectedDrugName, selectedDrugID);

            dispose();
        }
    }

}
