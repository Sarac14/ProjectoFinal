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
import logico.Doctor;
import logico.Persona;
import logico.Vacuna;

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
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.SpinnerListModel;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;

public class RegCita extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JSpinner spnFecha;
	private JComboBox<String> cbxDoctor;
	private Persona persona;
	private JComboBox<Object> cbxEspecialidad;
	private JSpinner spnHora;
	private JRadioButton rdbSexoM;
	private JRadioButton rdbSexoF;
	private JToggleButton tglConsulta;
	private JPanel PanelVcuna;
	private JPanel panelConsulta;
	private JSpinner spnFechaVacuna;
	private JSpinner spnHoraVacuna;
	private JComboBox<String> cbxVacunas;
	private JToggleButton tglVacuna;
	private Doctor elDoctor = null;

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
		setBounds(100, 100, 560, 395);
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
			panel_1.setBorder(
					new TitledBorder(null, "Datos Personales:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(12, 13, 509, 146);
			panel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel label = new JLabel("C\u00E9dula:");
				label.setBounds(12, 27, 56, 16);
				panel_1.add(label);
			}
			{
				txtCedula = new JTextField();
				txtCedula.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(java.awt.event.KeyEvent evt) {
						int key = evt.getKeyChar();

						boolean numeros = key >= 48 && key <= 57;

						if (!numeros) {
							evt.consume();
						}

						if (txtCedula.getText().trim().length() == 10) {
							evt.consume();
						}
					}
				});
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
				txtNombre.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(java.awt.event.KeyEvent evt) {
						int key = evt.getKeyChar();

						boolean mayusculas = key >= 65 && key <= 90;
						boolean minusculas = key >= 97 && key <= 122;
						boolean espacio = key == 32;

						if (!(minusculas || mayusculas || espacio)) {
							evt.consume();
						}
					}
				});
				txtNombre.setEditable(false);
				txtNombre.setColumns(10);
				txtNombre.setBounds(71, 56, 190, 22);
				panel_1.add(txtNombre);
			}
			{
				JLabel label = new JLabel("Direcci\u00F3n:");
				label.setBounds(12, 114, 70, 16);
				panel_1.add(label);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setEditable(false);
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(71, 111, 419, 22);
				panel_1.add(txtDireccion);
			}
			{
				JLabel lblNewLabel = new JLabel("Tel\u00E9fono:");
				lblNewLabel.setBounds(273, 59, 56, 16);
				panel_1.add(lblNewLabel);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(java.awt.event.KeyEvent evt) {
						int key = evt.getKeyChar();

						boolean numeros = key >= 48 && key <= 57;

						if (!numeros) {
							evt.consume();
						}

						if (txtTelefono.getText().trim().length() == 10) {
							evt.consume();
						}
					}
				});
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
						} else {
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
				JLabel lblNewLabel_4 = new JLabel("Sexo:");
				lblNewLabel_4.setBounds(12, 85, 56, 16);
				panel_1.add(lblNewLabel_4);
			}
			{
				rdbSexoM = new JRadioButton("M");
				rdbSexoM.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rdbSexoM.setSelected(true);
						rdbSexoF.setSelected(false);

					}
				});
				rdbSexoM.setSelected(true);
				rdbSexoM.setBounds(71, 83, 39, 22);
				panel_1.add(rdbSexoM);
			}
			{
				rdbSexoF = new JRadioButton("F");
				rdbSexoF.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rdbSexoM.setSelected(false);
						rdbSexoF.setSelected(true);
					}
				});
				rdbSexoF.setBounds(111, 83, 49, 22);
				panel_1.add(rdbSexoF);
			}
			{
				PanelVcuna = new JPanel();
				PanelVcuna.setVisible(false);
				PanelVcuna.setBounds(12, 170, 509, 86);
				panel.add(PanelVcuna);
				PanelVcuna.setBorder(new TitledBorder(null, "Datos de la cita:", TitledBorder.LEADING, TitledBorder.TOP,
						null, null));
				PanelVcuna.setLayout(null);
				{
					JLabel lblNewLabel_5 = new JLabel("Vacuna:");
					lblNewLabel_5.setBounds(10, 25, 106, 27);
					PanelVcuna.add(lblNewLabel_5);
				}
				{
					cbxVacunas = new JComboBox<String>();
					cbxVacunas.setModel(new DefaultComboBoxModel<String>(new String[] { "<Seleccione>" }));
					for (Vacuna laVacuna : Clinica.getInstance().getMisVacunas()) {
						cbxVacunas.addItem(laVacuna.getNombre());
					}
					cbxVacunas.setBounds(61, 27, 175, 22);
					PanelVcuna.add(cbxVacunas);
				}
				{
					JLabel lblNewLabel_6 = new JLabel("Fecha:");
					lblNewLabel_6.setBounds(273, 19, 77, 38);
					PanelVcuna.add(lblNewLabel_6);
				}
				{
					spnFechaVacuna = new JSpinner();
					spnFechaVacuna
							.setModel(new SpinnerDateModel(new Date(1648958400000L), null, null, Calendar.DAY_OF_YEAR));
					spnFechaVacuna.setEditor(new JSpinner.DateEditor(spnFechaVacuna, "dd/MM/yyyy"));
					spnFechaVacuna.setBounds(341, 27, 92, 22);
					PanelVcuna.add(spnFechaVacuna);
					spnFechaVacuna.setValue(new Date());
				}
				{
					JLabel lblHora = new JLabel("Hora:");
					lblHora.setBounds(273, 48, 77, 38);
					PanelVcuna.add(lblHora);
				}
				{
					spnHoraVacuna = new JSpinner();
					spnHoraVacuna.setModel(new SpinnerListModel(
							new String[] { "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00",
									"12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30" }));
					spnHoraVacuna.setBounds(341, 56, 92, 22);
					PanelVcuna.add(spnHoraVacuna);
				}
			}
			{
				panelConsulta = new JPanel();
				panelConsulta.setBounds(12, 170, 509, 86);
				panel.add(panelConsulta);
				panelConsulta.setBorder(new TitledBorder(null, "Datos de la Cita:", TitledBorder.LEADING,
						TitledBorder.TOP, null, null));
				panelConsulta.setLayout(null);
				{
					JLabel lblNewLabel_1 = new JLabel("Fecha:");
					lblNewLabel_1.setBounds(318, 23, 56, 16);
					panelConsulta.add(lblNewLabel_1);
				}
				{
					spnFecha = new JSpinner();
					spnFecha.setModel(new SpinnerDateModel(new Date(1648868500588L), null, null, Calendar.DAY_OF_YEAR));
					spnFecha.setEditor(new JSpinner.DateEditor(spnFecha, "dd/MM/yyyy"));
					spnFecha.setBounds(384, 20, 92, 22);
					panelConsulta.add(spnFecha);
					spnFecha.setValue(new Date());
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Doctor:");
					lblNewLabel_2.setBounds(10, 59, 56, 16);
					panelConsulta.add(lblNewLabel_2);
				}

				{
					JLabel lblNewLabel_3 = new JLabel("Especialidad:");
					lblNewLabel_3.setBounds(10, 20, 89, 22);
					panelConsulta.add(lblNewLabel_3);
				}

				{
					cbxDoctor = new JComboBox<String>();
					cbxDoctor.setEnabled(false);
					cbxDoctor.setModel(new DefaultComboBoxModel<String>(new String[] { "<Seleccione>" }));
					cbxDoctor.setBounds(109, 56, 175, 22);
					panelConsulta.add(cbxDoctor);
				}

				{
					cbxEspecialidad = new JComboBox<Object>();
					cbxEspecialidad.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {

							if (cbxEspecialidad.getSelectedIndex() != 0) {
								cbxDoctor.setEnabled(true);
								cbxDoctor.removeAllItems();
								cbxDoctor.setModel(new DefaultComboBoxModel<String>(new String[] { "<Seleccione>" }));
							}
							ArrayList<String> listaDoctores = new ArrayList<>();
							for (Doctor doctor : Clinica.getInstance().getMisDoctores()) {
								if (doctor.getEspecialidad()
										.equalsIgnoreCase(cbxEspecialidad.getSelectedItem().toString())) {

									String nombre = doctor.getNombre();

									if (!listaDoctores.contains(nombre)) {
										listaDoctores.add(nombre);
										cbxDoctor.addItem(nombre);
									}

								}

							}
						}
					});

					cbxEspecialidad.setModel(new DefaultComboBoxModel<Object>(new String[] { "<Selecione>", "Pediatra",
							"Cirujano", "Psicólogo", "Cardiologo", "Dermatologo", "Endocrinologo", "Gastroenterologo",
							"Oftalmologo", "Otorrinolaringologo", "Neumologo", "Neurologo", "Radiologo",
							"Anestesiologo", "Oncologo", "Patologo", "Urologo" }));
					cbxEspecialidad.setBounds(109, 20, 175, 22);
					panelConsulta.add(cbxEspecialidad);
				}

				{
					JLabel Hora = new JLabel("Hora:");
					Hora.setBounds(318, 59, 56, 16);
					panelConsulta.add(Hora);
				}
				{
					spnHora = new JSpinner();
					spnHora.setModel(new SpinnerListModel(
							new String[] { "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00",
									"12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30" }));
					spnHora.setBounds(384, 53, 92, 22);
					panelConsulta.add(spnHora);
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

						char sexo;
						if (rdbSexoF.isSelected()) {
							sexo = 'F';
						} else {
							sexo = 'M';
						}
						if (persona == null) {
							Persona aux = new Persona(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(),
									txtTelefono.getText(), sexo);
							Clinica.getInstance().agregarPersona(aux);
						}

						if (panelConsulta.isVisible() == true) {
							SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
							String spinnerValue = formater.format(spnFecha.getValue());
							String fechaString = spinnerValue.toString();

							elDoctor = Clinica.getInstance()
									.buscarDoctorporNombre(cbxDoctor.getSelectedItem().toString());

							Cita auxCita = new Cita(
									txtNombre.getText() + "-" + Clinica.getInstance().getMisCitas().size() + 1,
									txtCedula.getText(), txtNombre.getText(), fechaString,
									spnHora.getValue().toString(), cbxDoctor.getSelectedItem().toString(), "Consulta");
							Clinica.getInstance().agregarCita(auxCita);
							elDoctor.agregarCita(auxCita);
						} else {
							SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
							String spinnerValue = formater.format(spnFechaVacuna.getValue());
							String fechaString = spinnerValue.toString();
							
							elDoctor = Clinica.getInstance().buscarDoctorporNombre(cbxDoctor.getSelectedItem().toString());
							Cita auxCita = new Cita(txtNombre.getText() + "-" + Clinica.getInstance().getMisCitas().size() + 1,txtCedula.getText(), txtNombre.getText(), fechaString,
									spnHoraVacuna.getValue().toString(), "Enfermera", "Vacuna");
							
							Clinica.getInstance().agregarCita(auxCita);
							elDoctor.agregarCita(auxCita);
						}

						JOptionPane.showMessageDialog(null, "Operación exitosa", "Información",
								JOptionPane.INFORMATION_MESSAGE);
						clean();
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				tglConsulta = new JToggleButton("Cita");
				tglConsulta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						tglVacuna.setSelected(false);
						panelConsulta.setVisible(true);
						PanelVcuna.setVisible(false);
					}

				});
				tglConsulta.setSelected(true);
				tglConsulta.setIcon(new ImageIcon(RegCita.class.getResource("/Imagenes/portapapeles.png")));
				menuBar.add(tglConsulta);
			}
			{
				tglVacuna = new JToggleButton("Vacuna");
				tglVacuna.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						tglConsulta.setSelected(false);
						panelConsulta.setVisible(false);
						PanelVcuna.setVisible(true);
					}
				});
				tglVacuna.setIcon(new ImageIcon(RegCita.class.getResource("/Imagenes/vacuna (1).png")));
				menuBar.add(tglVacuna);
			}
		}
	}

	private void clean() {
		txtNombre.setText("");
		txtCedula.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		spnFecha.setValue(new Date());
		spnHora.setValue("8:00");
		cbxDoctor.setSelectedIndex(0);

		txtTelefono.setEditable(false);
		txtNombre.setEditable(false);
		txtDireccion.setEditable(false);

		spnFechaVacuna.setValue(new Date());
		spnHoraVacuna.setValue("8:00");
		cbxVacunas.setSelectedIndex(0);

		panelConsulta.setVisible(true);
		PanelVcuna.setVisible(false);
	}
}
