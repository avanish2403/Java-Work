package com.company.billing.io;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Invoice extends JFrame {

	private JPanel contentPane;
	private JTextField price_field;
	private JTextField textField_2;
	private JComboBox product_combobox;
	private JLabel products_left;
	/**
	 * Launch the application.
	 */
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice frame = new Invoice();
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
	
	public void productDropdown() {
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from addproduct where productname =?");
			
			while(resultSet.next())
			{
				product_combobox.addItem(resultSet.getString("productname"));
			}
		}catch(Exception e) {
			
		}
	}
	
	
	public Invoice() {
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingdb", "root", null);
			JOptionPane.showMessageDialog(null, "Welcome To Invoice");
		
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		product_combobox = new JComboBox();	
		product_combobox.setSelectedItem(null);
		product_combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				try {
								
								
								String fetch_row = "select * from addproduct where productname =?";
								PreparedStatement statement=connection.prepareStatement(fetch_row);
								
								
							
								statement.setString(1, (String) product_combobox.getSelectedItem());
													
								resultSet = statement.executeQuery();
										
								while(resultSet.next()) {
									products_left.setText(resultSet.getString("quantity"));
									price_field.setText(resultSet.getString("productprice"));
								}
								
								statement.close();
								
								
							}catch(SQLException e2) {
								e2.printStackTrace();
								
							}

			}
		});
			
		product_combobox.setBounds(41, 49, 231, 22);
		contentPane.add(product_combobox);
		
		price_field = new JTextField();
		price_field.setBounds(515, 50, 103, 20);
		contentPane.add(price_field);
		//price_field.add(price_field);
		price_field.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));		
		btnNewButton.setBounds(874, 49, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Select Product");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(41, 21, 130, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblUnitsLeft = new JLabel("Units Left");
		lblUnitsLeft.setForeground(Color.WHITE);
		lblUnitsLeft.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUnitsLeft.setBounds(335, 17, 130, 22);
		contentPane.add(lblUnitsLeft);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPrice.setBounds(515, 17, 130, 22);
		contentPane.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblQuantity.setBounds(686, 21, 130, 22);
		contentPane.add(lblQuantity);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(686, 50, 103, 20);
		contentPane.add(textField_2);
		
		products_left = new JLabel("");
		products_left.setForeground(Color.WHITE);
		products_left.setBounds(335, 53, 97, 14);
		contentPane.add(products_left);
		    

		productDropdown();
	}
}



