package com.company.billing.io;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;

public class AboutUs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs frame = new AboutUs();
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
	public AboutUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("About Us :-");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setBounds(10, 11, 177, 64);
		contentPane.add(lblNewLabel);
		
		JTextPane txtpnAPerfectPlace = new JTextPane();
		txtpnAPerfectPlace.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtpnAPerfectPlace.setForeground(Color.WHITE);
		txtpnAPerfectPlace.setBackground(Color.BLACK);
		txtpnAPerfectPlace.setText("Nothing\u2019s better than chilled ice-cream on a hot summer day or hot chocolate fudge on a cold winter night. While foodies may debate over the best cuisine, pizza vs burger, etc. everyone is on the same page when it comes to love for ice cream.\r\n\r\nA perfect place for a sweet treat and all about Icecream And Shake Parlour at Nawada, Delhi. The response it received led to its successful journey, culminating in the establishment of a chain of ice-cream parlours all across the city. It is the brand's commitment to quality that has led to its success and made it a name to reckon with in the industry. Easily accessible to people of all age groups, this establishment is situated strategically at Block ANawada in Nawada, an area that is well-connected to other eminent parts of the city via numerous modes of public transport. Undoubtedly it is one of the Best Ice Cream Retailers in Nawada, Delhi.");
		txtpnAPerfectPlace.setBounds(10, 349, 964, 201);
		contentPane.add(txtpnAPerfectPlace);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 61, 253, 277);
		lblNewLabel_1.setIcon(new ImageIcon( Tasks.class.getResource("/shake2.jpg") ));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(273, 25, 202, 231);
		lblNewLabel_2.setIcon(new ImageIcon( Tasks.class.getResource("/icecream2.jpg") ));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(476, 137, 222, 201);
		lblNewLabel_3.setIcon(new ImageIcon( Tasks.class.getResource("/cake.jpg") ));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(708, 61, 265, 201);
		lblNewLabel_4.setIcon(new ImageIcon( Tasks.class.getResource("/icecream3.jpg") ));
		contentPane.add(lblNewLabel_4);
	}
}
