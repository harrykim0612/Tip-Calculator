package Tip_Calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TipCalculator {

	private JFrame frmTipCalculator;
	private JTextField textAmount;
	private JTextField textPercent;
	private JTextField textTipAmount;
	private JTextField textTotalAmount;
	private JLabel lblYourTipIs;
	private JLabel lblYourTotalAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TipCalculator window = new TipCalculator();
					window.frmTipCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TipCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTipCalculator = new JFrame();
		frmTipCalculator.setTitle("Tip Calculator");
		frmTipCalculator.setBounds(100, 100, 450, 300);
		frmTipCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTipCalculator.getContentPane().setLayout(null);
		
		textAmount = new JTextField();
		textAmount.setBounds(32, 66, 116, 22);
		frmTipCalculator.getContentPane().add(textAmount);
		textAmount.setColumns(10);
		
		textPercent = new JTextField();
		textPercent.setBounds(243, 66, 116, 22);
		frmTipCalculator.getContentPane().add(textPercent);
		textPercent.setColumns(10);
		
		textTipAmount = new JTextField();
		textTipAmount.setBounds(214, 139, 116, 22);
		frmTipCalculator.getContentPane().add(textTipAmount);
		textTipAmount.setColumns(10);
		
		textTotalAmount = new JTextField();
		textTotalAmount.setBounds(214, 174, 116, 22);
		frmTipCalculator.getContentPane().add(textTotalAmount);
		textTotalAmount.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setBounds(32, 49, 116, 16);
		frmTipCalculator.getContentPane().add(lblAmount);
		
		JLabel lblPercent = new JLabel("Tip Percent");
		lblPercent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercent.setBounds(243, 49, 116, 16);
		frmTipCalculator.getContentPane().add(lblPercent);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double amount;
				Double percent;
				try {
					amount = Double.parseDouble(textAmount.getText());
					percent = Double.parseDouble(textPercent.getText());
				}
				catch (NumberFormatException err) {
					return;
				}
				
				percent /= 100;
				
				double tip = percent * amount;
				textTipAmount.setText(String.valueOf(tip));
				
				double totalAmount = tip + amount;
				textTotalAmount.setText(String.valueOf(totalAmount));
			}
		});
		btnCalculate.setBounds(323, 101, 97, 25);
		frmTipCalculator.getContentPane().add(btnCalculate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAmount.setText("");
				textPercent.setText("");
				textTipAmount.setText("");
				textTotalAmount.setText("");
				
			}
		});
		btnClear.setBounds(12, 215, 97, 25);
		frmTipCalculator.getContentPane().add(btnClear);
		
		lblYourTipIs = new JLabel("Your tip is");
		lblYourTipIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourTipIs.setBounds(123, 142, 116, 16);
		frmTipCalculator.getContentPane().add(lblYourTipIs);
		
		lblYourTotalAmount = new JLabel("Your total amount is");
		lblYourTotalAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourTotalAmount.setBounds(94, 177, 116, 16);
		frmTipCalculator.getContentPane().add(lblYourTotalAmount);
	}
}
