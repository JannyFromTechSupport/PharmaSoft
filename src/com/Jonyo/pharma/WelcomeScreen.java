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
import java.util.Objects;

public class WelcomeScreen extends JFrame implements ActionListener {

    private JLabel lblWelcome, lblCopyright;

    private JButton btnDoctor, btnPharmacist;

    public WelcomeScreen() {

        super("PHARMA");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(460, 180);
        ImageIcon image1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("icons8-batman-48.png")));
        setIconImage(image1.getImage());
        getContentPane().setBackground(new Color(92, 219, 149));

        lblWelcome = new JLabel("WELCOME!");
        lblWelcome.setBounds(80, -80, 350, 250);
        btnDoctor = new JButton("DOCTOR");
        btnDoctor.setBounds(130, 130, 250, 50);
        btnDoctor.setFocusable(false);
        btnPharmacist = new JButton("PHARMACIST");
        btnPharmacist.setBounds(130, 260, 250, 50);
        btnPharmacist.setFocusable(false);
        lblCopyright = new JLabel("Copyright " + "\u00A9" + " 2023 by Janny Jonyo");
        lblCopyright.setBounds(100, 220, 350, 250);

        ImageIcon originalIcon1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("doctor.png")));
        Image originalImage1 = originalIcon1.getImage();
        Image scaledImage1 = originalImage1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JLabel imageLabel1 = new JLabel(scaledIcon1);
        imageLabel1.setBounds(20, 100, 100, 100);

        ImageIcon originalIcon2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("syringe.png")));
        Image originalImage2 = originalIcon2.getImage();
        Image scaledImage2 = originalImage2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        JLabel imageLabel2 = new JLabel(scaledIcon2);
        imageLabel2.setBounds(20, 230, 100, 100);

        Font tahoma1 = new Font("Tahoma", Font.BOLD, 41);
        Font tahoma2 = new Font("Tahoma", Font.BOLD, 15);
        Font tahoma3 = new Font("Tahoma", Font.BOLD, 12);
        lblWelcome.setFont(tahoma1);
        lblWelcome.setForeground(Color.WHITE);
        lblCopyright.setFont(tahoma3);
        lblCopyright.setForeground(Color.WHITE);
        btnDoctor.setFont(tahoma2);
        btnDoctor.setBackground(new Color(56, 176, 250));
        btnDoctor.setForeground(Color.WHITE);
        btnPharmacist.setFont(tahoma2);
        btnPharmacist.setBackground(new Color(56, 176, 250));
        btnPharmacist.setForeground(Color.WHITE);

        add(lblWelcome);
        add(imageLabel1);
        add(btnDoctor);
        add(imageLabel2);
        add(btnPharmacist);
        add(lblCopyright);

        btnDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DoctorFrame doctorframe = new DoctorFrame();
            }
        });
        btnPharmacist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PharmacistFrame pharmacistframe = new PharmacistFrame();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
