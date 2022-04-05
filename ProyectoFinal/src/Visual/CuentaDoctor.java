package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CuentaDoctor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CuentaDoctor dialog = new CuentaDoctor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CuentaDoctor() {
		setTitle("Inicio de Sesi\u00F3n");
		setBounds(100, 100, 552, 384);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Usuario:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(118, 76, 108, 16);
			panel.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(118, 105, 270, 22);
			panel.add(textField);
			textField.setColumns(10);
			
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblContrasea.setBounds(118, 155, 108, 16);
			panel.add(lblContrasea);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(118, 184, 270, 22);
			panel.add(textField_1);
			
			JButton btnNewButton = new JButton("Iniciar S\u00E9sion");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton.setBounds(194, 219, 122, 39);
			panel.add(btnNewButton);
		}
	}
}
