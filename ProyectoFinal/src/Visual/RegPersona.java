package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class RegPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPersona dialog = new RegPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegPersona() {
		setTitle("Crear Cita");
		setBounds(100, 100, 560, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Datos Personales:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(12, 13, 509, 133);
			panel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel label = new JLabel("C\u00E9dula:");
				label.setBounds(12, 27, 56, 16);
				panel_1.add(label);
			}
			{
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(71, 24, 190, 22);
				panel_1.add(textField);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(12, 56, 56, 16);
				panel_1.add(label);
			}
			{
				textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setColumns(10);
				textField_1.setBounds(71, 56, 190, 22);
				panel_1.add(textField_1);
			}
			{
				JLabel label = new JLabel("Direcci\u00F3n:");
				label.setBounds(12, 88, 70, 16);
				panel_1.add(label);
			}
			{
				textField_2 = new JTextField();
				textField_2.setEditable(false);
				textField_2.setColumns(10);
				textField_2.setBounds(70, 85, 420, 22);
				panel_1.add(textField_2);
			}
			{
				JLabel lblNewLabel = new JLabel("Tel\u00E9fono:");
				lblNewLabel.setBounds(273, 59, 56, 16);
				panel_1.add(lblNewLabel);
			}
			{
				textField_3 = new JTextField();
				textField_3.setEditable(false);
				textField_3.setColumns(10);
				textField_3.setBounds(341, 56, 149, 22);
				panel_1.add(textField_3);
			}
			{
				JButton btnNewButton = new JButton("Buscar");
				btnNewButton.setBounds(341, 24, 109, 22);
				panel_1.add(btnNewButton);
			}
			{
				JPanel panel_2 = new JPanel();
				panel_2.setBorder(new TitledBorder(null, "Datos de la Cita:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_2.setBounds(12, 159, 509, 86);
				panel.add(panel_2);
				panel_2.setLayout(null);
				{
					JLabel lblNewLabel_1 = new JLabel("Fecha:");
					lblNewLabel_1.setBounds(12, 23, 56, 16);
					panel_2.add(lblNewLabel_1);
				}
				{
					JSpinner spinner = new JSpinner();
					spinner.setModel(new SpinnerDateModel(new Date(1648008000000L), null, null, Calendar.DAY_OF_YEAR));
					spinner.setBounds(61, 20, 92, 22);
					panel_2.add(spinner);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Doctor:");
					lblNewLabel_2.setBounds(12, 52, 56, 16);
					panel_2.add(lblNewLabel_2);
				}
				{
					JComboBox comboBox = new JComboBox();
					comboBox.setBounds(61, 49, 175, 22);
					panel_2.add(comboBox);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agendar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
