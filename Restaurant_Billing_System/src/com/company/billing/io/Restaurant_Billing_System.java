package com.company.billing.io;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import javax.swing.JPasswordField;

public class Restaurant_Billing_System  {

	private JFrame frame;
	private JTextField textField;
	private JTextField name_field;
	private JTextField username_field;
	private JTextField org_field;
	private JTextField date_field;
	private JTextField mobile_field;
	private JPanel panel;
	private JPasswordField password_field;
	private JPasswordField passwordField;
	
	private String name;
	private String username;
	private String password;
	private String organisation;
	private String date_of_birth;
	private String mobile;
	private String email;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurant_Billing_System window = new Restaurant_Billing_System();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public Restaurant_Billing_System() throws ClassNotFoundException, SQLException {
		try {
			initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	private void initialize() throws SQLException  {
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingdb", "root", null);
		JOptionPane.showMessageDialog(null, "Connection Success");
		statement = connection.createStatement();
	
	} catch (SQLException | ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
		
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(200, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Creamy Creations\r\n");
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(274, 53, 655, 67);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(146, 180, 266, 51);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(681, 180, 216, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(582, 183, 69, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(582, 224, 69, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btn_login = new JButton("Login");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingdb", "root", null);
					statement = connection.createStatement();
					resultSet = statement.executeQuery("select * from user_mst where name='" + textField.getText() +"' and password='" + passwordField.getText().toString()+"'");
					if(resultSet.next())
					{
						JOptionPane.showMessageDialog(null, "Login Success");
						new Tasks().setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect user name or password");
						connection.close();
					}
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			});
		btn_login.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_login.setBounds(748, 278, 89, 20);
		frame.getContentPane().add(btn_login);
		
		JLabel lb_registered = new JLabel("Already Registered");
		lb_registered.setForeground(new Color(255, 255, 255));
		lb_registered.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lb_registered.setBounds(700, 123, 229, 20);
		frame.getContentPane().add(lb_registered);

		
		JLabel lblNewLabel_3 = new JLabel("New User");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(225, 131, 121, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel.setVisible(false);
		panel.setBounds(33, 278, 555, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		name_field = new JTextField();
		name_field.setBounds(122, 40, 165, 20);
		panel.add(name_field);
		name_field.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Name");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 43, 52, 14);
		panel.add(lblNewLabel_5);
		
		username_field = new JTextField();
		username_field.setColumns(10);
		username_field.setBounds(122, 87, 165, 20);
		panel.add(username_field);
		
		JLabel lblNewLabel_5_1 = new JLabel("Create Username");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_5_1.setBounds(10, 90, 92, 14);
		panel.add(lblNewLabel_5_1);
		
		org_field = new JTextField();
		org_field.setColumns(10);
		org_field.setBounds(122, 176, 165, 20);
		panel.add(org_field);
		
		JLabel lblNewLabel_5_2 = new JLabel("Choose Password");
		lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_5_2.setBounds(10, 137, 92, 14);
		panel.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Organisation");
		lblNewLabel_5_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_5_3.setBounds(10, 179, 92, 14);
		panel.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("Date of Birth");
		lblNewLabel_5_3_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_5_3_1.setBounds(10, 222, 92, 14);
		panel.add(lblNewLabel_5_3_1);
		
		date_field = new JTextField();
		date_field.setColumns(10);
		date_field.setBounds(122, 219, 165, 20);
		panel.add(date_field);
		
		mobile_field = new JTextField();
		mobile_field.setColumns(10);
		mobile_field.setBounds(380, 40, 165, 20);
		panel.add(mobile_field);
		
		JLabel lblNewLabel_5_4 = new JLabel("Mobile");
		lblNewLabel_5_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_5_4.setBounds(318, 43, 52, 14);
		panel.add(lblNewLabel_5_4);
		
		JButton create_account = new JButton("Create Account");
		create_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					PreparedStatement ps = connection.prepareStatement("insert into create_account(name,username,password,organisation,date_of_birth,mobile) values(?,?,?,?,?,?) ");
					ps.setString(1, name_field.getText());
					ps.setString(2, username_field.getText());
					ps.setString(3, passwordField.getText());
					ps.setString(4, org_field.getText());
					ps.setString(5, date_field.getText());
					ps.setString(6, mobile_field.getText());
					int x = ps.executeUpdate();
					if(x>0) {
						JOptionPane.showMessageDialog(null, "Account Created Successfully");
//						
					}else {
						JOptionPane.showMessageDialog(null, " Unable To Create Account");
//						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		create_account.setFont(new Font("Times New Roman", Font.BOLD, 12));
		create_account.setBounds(380, 112, 142, 23);
		panel.add(create_account);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(122, 134, 165, 20);
		panel.add(passwordField);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(681, 221, 216, 20);
		frame.getContentPane().add(passwordField);
		//resultSet.close();
		statement.close();
		//connection.close();
		
		
	}
	
}
