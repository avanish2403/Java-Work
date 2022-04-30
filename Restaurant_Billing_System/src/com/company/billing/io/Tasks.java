package com.company.billing.io;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tasks extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tasks frame = new Tasks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tasks() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to the main menu. Please select an option to move further...");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(57, 42, 714, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(109, 128, 122, 109);
		lblNewLabel_1.setIcon(new ImageIcon( Tasks.class.getResource("/addproduct.jpg") ));
		contentPane.add(lblNewLabel_1);

		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(451, 128, 119, 109);
		lblNewLabel_2.setIcon(new ImageIcon( Tasks.class.getResource("/order.png") ));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(109, 343, 122, 149);
		lblNewLabel_3.setIcon(new ImageIcon( Tasks.class.getResource("/about.jpg") ));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(451, 367, 130, 125);
		lblNewLabel_4.setIcon(new ImageIcon( Tasks.class.getResource("/history.jpg") ));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(747, 251, 149, 132);
		lblNewLabel_5.setIcon(new ImageIcon( Tasks.class.getResource("/gallery.jpg") ));
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Add Product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddProducts().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(119, 248, 102, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("About Us");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutUs().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(129, 495, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Order().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_2.setBounds(461, 248, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("History");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_3.setBounds(461, 495, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Gallery");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_4.setBounds(777, 385, 89, 23);
		contentPane.add(btnNewButton_4);
		
		
		
		
		
		
		
		
	}
}
