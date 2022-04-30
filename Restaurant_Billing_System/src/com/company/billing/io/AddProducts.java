package com.company.billing.io;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProducts extends JFrame {

	private JPanel contentPane;
	private JTextField product_name;
	private JTextField product_price;
	private JTextField product_quantity;
	private JTextField product_tax;
	private JTextField product_description;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProducts frame = new AddProducts();
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
	Connection connection = null;
	public AddProducts() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingdb", "root", null);
			JOptionPane.showMessageDialog(null, "Connection Success");
		
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Product First");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setBounds(41, 36, 427, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(41, 127, 144, 27);
		contentPane.add(lblNewLabel_1);
		
		product_name = new JTextField();
		product_name.setFont(new Font("Times New Roman", Font.BOLD, 12));
		product_name.setBounds(257, 130, 211, 20);
		contentPane.add(product_name);
		product_name.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Price");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(41, 201, 144, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quantity");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(41, 277, 101, 27);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tax");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(41, 358, 101, 27);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Product Description");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(41, 432, 179, 27);
		contentPane.add(lblNewLabel_1_4);
		
		product_price = new JTextField();
		product_price.setFont(new Font("Times New Roman", Font.BOLD, 12));
		product_price.setColumns(10);
		product_price.setBounds(257, 206, 211, 20);
		contentPane.add(product_price);
		
		product_quantity = new JTextField();
		product_quantity.setFont(new Font("Times New Roman", Font.BOLD, 12));
		product_quantity.setColumns(10);
		product_quantity.setBounds(257, 282, 211, 20);
		contentPane.add(product_quantity);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Product product = new Product();
				//(productname,productprice,quantity,tax,productdescription)
				
				try {
					PreparedStatement ps = connection.prepareStatement("insert into addproduct values(?,?,?,?,?) ");
					ps.setString(1, product_name.getText());
					ps.setString(2, product_price.getText());
					ps.setString(3, product_quantity.getText());
					ps.setString(4, product_tax.getText());
					ps.setString(5, product_description.getText());
					int x = ps.executeUpdate();
					
					//for(Product product : AddProducts) {
//					
//						ps.setString(1, product.getProduct_name());
//						ps.setString(2, product.getProduct_price());
//						ps.setString(3, product.getProduct_quantity());
//						ps.setString(4, product.getProduct_tax());
//						ps.setString(5, product.getProduct_description());
						
						
						ps.addBatch();
					
				
					
					if(x>0) {
						JOptionPane.showMessageDialog(null, "Product Uploaded Successfully");
						
						product_name.setText("");
						product_price.setText("");
						product_quantity.setText("");
						product_tax.setText("");
						product_description.setText("");
						
						
						
						
					}else {
						JOptionPane.showMessageDialog(null, " Unable To Upload Product");
						
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(316, 503, 89, 23);
		contentPane.add(btnNewButton);
		
		product_tax = new JTextField();
		product_tax.setFont(new Font("Times New Roman", Font.BOLD, 12));
		product_tax.setColumns(10);
		product_tax.setBounds(257, 363, 211, 20);
		contentPane.add(product_tax);
		
		product_description = new JTextField();
		product_description.setFont(new Font("Times New Roman", Font.BOLD, 12));
		product_description.setColumns(10);
		product_description.setBounds(257, 437, 211, 20);
		contentPane.add(product_description);
	}
}
