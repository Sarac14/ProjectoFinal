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
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(CuentaDoctor.class.getResource("/Imagenes/seguro-de-salud.png")));
		setTitle("Inicio de Sesi\u00F3n");
		setBounds(100, 100, 553, 445);
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
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_1.setBounds(74, 31, 383, 338);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel label = new JLabel("Usuario:");
			label.setBounds(153, 161, 75, 20);
			label.setFont(new Font("Tahoma", Font.BOLD, 16));
			panel_1.add(label);
			
			textField = new JTextField();
			textField.setBounds(85, 195, 211, 22);
			textField.setColumns(10);
			panel_1.add(textField);
			
			JLabel label_1 = new JLabel("Contrase\u00F1a:");
			label_1.setBounds(135, 225, 111, 20);
			label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			panel_1.add(label_1);
			
			textField_1 = new JTextField();
			textField_1.setBounds(85, 258, 211, 22);
			textField_1.setColumns(10);
			panel_1.add(textField_1);
			
			JButton button = new JButton("Iniciar S\u00E9sion");
			button.setForeground(Color.BLACK);
			button.setBounds(43, 300, 126, 25);
			button.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel_1.add(button);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(Color.BLACK);
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCancelar.setBounds(212, 300, 126, 25);
			panel_1.add(btnCancelar);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(CuentaDoctor.class.getResource("/Imagenes/user-profile.png")));
			lblNewLabel.setBounds(127, 13, 126, 134);
			panel_1.add(lblNewLabel);
		}
	}
}
