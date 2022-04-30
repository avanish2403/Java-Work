package com.company.billing.io;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Order extends JFrame {
	
	//protected static final JTable JTable1 = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
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
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public Order() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billingdb", "root", null);
			JOptionPane.showMessageDialog(null, "Connection Success");
		
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//getTotal();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowData();
				ShowData1();
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 70, 420, 481);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Place your order here...");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(20, 11, 382, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Choose Item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TableModel model = table.getModel();
				int[] index = table.getSelectedRows();
				Object[] row = new Object[4];
				DefaultTableModel model1 = (DefaultTableModel)table_1.getModel();
				for(int i=0; i<index.length; i++)
				{
					row[0] = model.getValueAt(index[i], 0);
					row[1] = model.getValueAt(index[i], 1);
					row[2] = model.getValueAt(index[i], 2);
					model1.addRow(row);
					
				}
				
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(445, 296, 100, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(549, 70, 420, 368);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_1 = new JButton("Total Amount");
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			getTotal();
		}
	});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(549, 475, 108, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Amount Paid");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_2.setBounds(668, 475, 105, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Balance\r\n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Balance();			
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_3.setBounds(783, 475, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Order");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_1.getRowCount() == 0){
					JOptionPane.showMessageDialog(null, "Please Place Your Order First");
				}else {
					JOptionPane.showMessageDialog(null, "Order Is Successfull");
				}
					
				}
				
			
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_4.setBounds(885, 495, 89, 23);
		contentPane.add(btnNewButton_4);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 12));
		textField.setBounds(549, 516, 105, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(668, 516, 105, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(783, 516, 89, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		
	}
	private void ShowData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Product Name");
		model.addColumn("Product Price");
		model.addColumn("Product Description");
		try {
			String query = "select * from addproduct";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				model.addRow(new Object []{
				rs.getString("productname"),
				rs.getString("productprice"),
				rs.getString("productdescription")
				
			});
			
			}
//			rs.close();
//			st.close();
			//connection.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(150);
			table.getColumnModel().getColumn(1).setPreferredWidth(120);
			table.getColumnModel().getColumn(2).setPreferredWidth(150);
			
		}catch(Exception e)
		{
			System.out.println("Error" + e);
		}
		
	}
	
	private void ShowData1() {
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("Product Name");
		model1.addColumn("Product Price");
		model1.addColumn("Product Description");
		
		try {
			
			Statement st = connection.createStatement();
			table_1.setModel(model1);
			table_1.setAutoResizeMode(0);
			table_1.getColumnModel().getColumn(0).setPreferredWidth(150);
			table_1.getColumnModel().getColumn(1).setPreferredWidth(120);
			table_1.getColumnModel().getColumn(2).setPreferredWidth(150);
				
		}catch(Exception e)
		{
			System.out.println("Error" + e);
		}
		
	}
	
	
	public void getTotal()
	{
		int sum = 0;
		for(int i=0; i<table_1.getRowCount(); i++)
		{
			sum = sum + Integer.parseInt(table_1.getValueAt(i, 1).toString());
		}
		
		textField.setText(Integer.toString(sum));
	}
	
	public void Balance() {
		int total = Integer.parseInt(textField.getText());
		int pay = Integer.parseInt(textField_1.getText());
		int balance = pay-total;
		textField_2.setText(String.valueOf(balance));
	}
	
}
