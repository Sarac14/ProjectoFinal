package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import logico.Clinica;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;

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
				txtCedula = new JTextField();
				txtCedula.setColumns(10);
				txtCedula.setBounds(71, 24, 190, 22);
				panel_1.add(txtCedula);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setBounds(12, 56, 56, 16);
				panel_1.add(label);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setEditable(false);
				txtNombre.setColumns(10);
				txtNombre.setBounds(71, 56, 190, 22);
				panel_1.add(txtNombre);
			}
			{
				JLabel label = new JLabel("Direcci\u00F3n:");
				label.setBounds(12, 88, 70, 16);
				panel_1.add(label);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setEditable(false);
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(70, 85, 420, 22);
				panel_1.add(txtDireccion);
			}
			{
				JLabel lblNewLabel = new JLabel("Tel\u00E9fono:");
				lblNewLabel.setBounds(273, 59, 56, 16);
				panel_1.add(lblNewLabel);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setEditable(false);
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(341, 56, 149, 22);
				panel_1.add(txtTelefono);
			}
			{
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String aux = txtCedula.getText();
						if (Clinica.getinstance().buscarPaciente(aux) == null) {
							txtNombre.setEditable(true);
							txtDireccion.setEditable(true);
							txtTelefono.setEditable(true);
						}
						if (Clinica.getinstance().buscarPaciente(aux) == null) {
							txtNombre.setText(Clinica.getinstance().buscarPaciente(aux).getNombre());
							txtTelefono.setText(Clinica.getinstance().buscarPaciente(aux).getTelefono());
							txtDireccion.setText(Clinica.getinstance().buscarPaciente(aux).getDireccion());
						}
					}
				});
				btnBuscar.setActionCommand("OK");
				btnBuscar.setBounds(341, 23, 95, 25);
				panel_1.add(btnBuscar);
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
					JSpinner spnFecha = new JSpinner();
					spnFecha.setModel(new SpinnerDateModel(new Date(1648008000000L), null, null, Calendar.DAY_OF_YEAR));
					spnFecha.setBounds(61, 20, 92, 22);
					panel_2.add(spnFecha);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Doctor:");
					lblNewLabel_2.setBounds(12, 52, 56, 16);
					panel_2.add(lblNewLabel_2);
				}
				{
					JComboBox cbxDoctor = new JComboBox();
					cbxDoctor.setBounds(61, 49, 175, 22);
					panel_2.add(cbxDoctor);
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
