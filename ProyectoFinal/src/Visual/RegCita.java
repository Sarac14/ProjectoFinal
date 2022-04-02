package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


import logico.Cita;
import logico.Clinica;
import logico.Persona;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.SpinnerListModel;

public class RegCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JSpinner spnFecha;
	private JComboBox cbxDoctor;
	private Persona persona;
	private JComboBox cbxEspecialidad;
	private JSpinner spnHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCita dialog = new RegCita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCita() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegCita.class.getResource("/Imagenes/seguro-de-salud.png")));
		setTitle("Crear Cita");
		setBounds(100, 100, 560, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
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
						persona = Clinica.getInstance().buscarPaciente(aux);
						
						if (persona == null) {
							txtNombre.setEditable(true);
							txtDireccion.setEditable(true);
							txtTelefono.setEditable(true);
						}else {
							txtNombre.setText(persona.getNombre());
							txtDireccion.setText(persona.getDireccion());
							txtTelefono.setText(persona.getTelefono());
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
					lblNewLabel_1.setBounds(288, 23, 56, 16);
					panel_2.add(lblNewLabel_1);
				}
				{
					spnFecha = new JSpinner();
					spnFecha.setModel(new SpinnerDateModel(new Date(1648868500588L), null, null, Calendar.DAY_OF_YEAR));
					spnFecha.setEditor(new JSpinner.DateEditor(spnFecha,"dd/MM/yyyy"));
					spnFecha.setBounds(337, 20, 92, 22);
					panel_2.add(spnFecha);
					spnFecha.setValue(new Date());
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Doctor:");
					lblNewLabel_2.setBounds(10, 59, 56, 16);
					panel_2.add(lblNewLabel_2);
				}
				{
					cbxDoctor = new JComboBox();
					cbxDoctor.setEnabled(false);
					cbxDoctor.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
					for(int i=0;i<Clinica.getInstance().getMisDoctores().size();i++) {
						cbxDoctor.addItem(Clinica.getInstance().getMisDoctores().get(i).getNombre());
					}
					cbxDoctor.setBounds(84, 56, 175, 22);
					panel_2.add(cbxDoctor);
				}
				{
					JLabel lblNewLabel_3 = new JLabel("Especialidad:");
					lblNewLabel_3.setBounds(10, 20, 125, 22);
					panel_2.add(lblNewLabel_3);
				}
				{
					cbxEspecialidad = new JComboBox();
					cbxEspecialidad.setModel(new DefaultComboBoxModel(new String[] {"<Selecione>", "Pediatra", "Cirujano", "Psicologo", "Cardiologo", "Dermatologo", "Endocrinologo", "Gastroenterologo", "Oftalmologo", "Otorrinolaringologo", "Neumologo", "Neurologo", "Radiologo", "Anestesiologo", "Oncologo", "Patologo", "Urologo"}));
					if(cbxEspecialidad.getSelectedIndex() != 0) {
						cbxDoctor.setEnabled(true);
					}
					cbxEspecialidad.setBounds(84, 20, 175, 22);
					panel_2.add(cbxEspecialidad);
				}
				{
					JLabel Hora = new JLabel("Hora:");
					Hora.setBounds(288, 59, 56, 16);
					panel_2.add(Hora);
				}
				{
					spnHora = new JSpinner();
					spnHora.setModel(new SpinnerListModel(new String[] {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30"}));
					spnHora.setBounds(337, 53, 92, 22);
					panel_2.add(spnHora);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agendar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if(persona == null) {
							Persona aux = new Persona(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText());
							Clinica.getInstance().agregarPersona(aux);
						}
						SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
						String spinnerValue = formater.format(spnFecha.getValue());
						String fechaString = spinnerValue.toString();
						// fechaCita = String.(spinnerValue.substring(0, 4));	

						
						Cita auxCita = new Cita(txtNombre.getText()+"-"+Clinica.getInstance().getMisCitas().size()+1,txtCedula.getText(), txtNombre.getText(), fechaString, cbxDoctor.getSelectedItem().toString());
						Clinica.getInstance().agregarCita(auxCita);
					    JOptionPane.showMessageDialog(null, "Operación exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
					    clean();
					}

				});
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
	private void clean() {
		txtNombre.setText("");
		txtCedula.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		spnFecha.setValue(new Date());
		cbxDoctor.setSelectedIndex(0);
		
		txtTelefono.setEditable(false);
		txtNombre.setEditable(false);
		txtDireccion.setEditable(false);
	}
}
