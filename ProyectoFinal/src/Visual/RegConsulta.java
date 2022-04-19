package Visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.omg.PortableInterceptor.ObjectReferenceTemplate;

import logico.Cita;
import logico.Clinica;
import logico.Consulta;
import logico.Doctor;
import logico.Enfermedad;
import logico.HistorialClinico;
import logico.Paciente;
import logico.Persona;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SpinnerDateModel;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegConsulta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Object> cbxSangre;
	private JSpinner spnNacimiento;
	private JSpinner spnPeso;
	private JRadioButton rdbSi;
	private JRadioButton RdbNo;
	private JComboBox<String> cbxCita;
	private JSpinner spnPresion;
	private JSpinner spnEstatura;
	private JTextField txtIdCita;
	private JTextField txtCedulaPaciente;
	private JToggleButton tglConsulta;
	private JToggleButton tglListCita;
	private JToggleButton tglPacientes;
	private JPanel pnlConsulta;
	private JTable tablaCita;
	private JTable tablaPaciente;
	private DefaultTableModel modelListCita;
	private DefaultTableModel modelListPaciente;
	private Object rowCita[];
	private Object rowPaciete[];
	private JTextPane txtDiagnostico;
	private ArrayList<String>sintomas;
	private JComboBox<Object> cbxEnfermedad;
	private Doctor selecteDoctor = null;
	private ArrayList<Enfermedad> posibleEnfermedad;
	private JTextField txtDoctorLogin;
	private Paciente selectedPaciente = null;
	private JButton btnHistorial;
	private JRadioButton rdbtEnfermoSi;
	private JRadioButton rdbtnEnfermoNo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileOutputStream clinica2;
				ObjectOutputStream clinicaWrite;
				try {
					clinica2 = new FileOutputStream("clinica.dat");
					clinicaWrite = new ObjectOutputStream(clinica2);
					clinicaWrite.writeObject(Clinica.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public RegConsulta() {
		selecteDoctor = Clinica.getLoginDoctor();

		setIconImage(Toolkit.getDefaultToolkit().getImage(RegConsulta.class.getResource("/Imagenes/seguro-de-salud.png")));
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setTitle("Consulta");
		setBounds(100, 100, 530, 675);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			pnlConsulta = new JPanel();
			pnlConsulta.setBounds(1, 7, 510, 594);
			contentPanel.add(pnlConsulta);
			pnlConsulta.setLayout(null);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cita", TitledBorder.LEADING,
					TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 11, 488, 94);
			pnlConsulta.add(panel_1);
			panel_1.setLayout(null);

			cbxCita = new JComboBox<String>();
			cbxCita.setModel(new DefaultComboBoxModel<String>(new String[] { "<Seleccione>" }));
			for (int i = 0; i < Clinica.getInstance().getMisCitas().size(); i++) {
				cbxCita.addItem(Clinica.getInstance().getMisCitas().get(i).getCodigo());
			}
			cbxCita.setBounds(12, 29, 153, 20);
			panel_1.add(cbxCita);

			txtIdCita = new JTextField();
			txtIdCita.setEditable(false);
			txtIdCita.setBounds(80, 60, 86, 20);
			panel_1.add(txtIdCita);
			txtIdCita.setColumns(10);

			JLabel lblNewLabel_7 = new JLabel("Id Cita");
			lblNewLabel_7.setBounds(12, 62, 56, 16);
			panel_1.add(lblNewLabel_7);

			JLabel lblNewLabel_9 = new JLabel("C\u00E9dula del Paciente:");
			lblNewLabel_9.setBounds(288, 13, 135, 16);
			panel_1.add(lblNewLabel_9);

			txtCedulaPaciente = new JTextField();
			txtCedulaPaciente.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(java.awt.event.KeyEvent evt) {
					int key = evt.getKeyChar();

					boolean numeros = key >= 48 && key <= 57;

					if (!numeros) {
						evt.consume();
					}

					if (txtCedulaPaciente.getText().trim().length() == 10) {
						evt.consume();
					}
				}
			});
			txtCedulaPaciente.setBounds(288, 28, 116, 22);
			panel_1.add(txtCedulaPaciente);
			txtCedulaPaciente.setColumns(10);

			JButton btnBuscarCita = new JButton("");
			btnBuscarCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Cita laCita = null;
					laCita = Clinica.getInstance().buscarCita(txtCedulaPaciente.getText());
					if(laCita != null) {
						txtIdCita.setText(laCita.getCodigo());
						cbxCita.setSelectedItem(laCita.getCodigo());
						
					}
					

				}
			});
			btnBuscarCita.setIcon(new ImageIcon(RegConsulta.class.getResource("/Imagenes/lupa (2).png")));
			btnBuscarCita.setBounds(417, 18, 48, 34);
			panel_1.add(btnBuscarCita);
			
			txtDoctorLogin = new JTextField();
			txtDoctorLogin.setEditable(false);
			txtDoctorLogin.setText(selecteDoctor.getNombre());
			txtDoctorLogin.setBounds(288, 59, 116, 22);
			panel_1.add(txtDoctorLogin);
			txtDoctorLogin.setColumns(10);

			JPanel panel_2 = new JPanel();
			panel_2.setBorder(
					new TitledBorder(null, "Datos del paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 111, 488, 167);
			pnlConsulta.add(panel_2);
			panel_2.setLayout(null);
			

			JLabel lblNewLabel = new JLabel("Tipo de Sangre:");
			lblNewLabel.setBounds(10, 51, 119, 14);
			panel_2.add(lblNewLabel);

			cbxSangre = new JComboBox<Object>();
			cbxSangre.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
			cbxSangre.setBounds(141, 48, 109, 20);
			panel_2.add(cbxSangre);

			JLabel lblNewLabel_1 = new JLabel("Fecha de nacimiento:");
			lblNewLabel_1.setBounds(10, 24, 137, 14);
			panel_2.add(lblNewLabel_1);

			spnNacimiento = new JSpinner();
			spnNacimiento.setModel(new SpinnerDateModel(new Date(1650389515952L), null, new Date(1650389515952L), Calendar.DAY_OF_YEAR));
			spnNacimiento.setEditor(new JSpinner.DateEditor(spnNacimiento, "dd/MM/yyyy"));
			spnNacimiento.setBounds(141, 21, 109, 20);
			panel_2.add(spnNacimiento);
			spnNacimiento.setValue(new Date());

			JLabel lblNewLabel_2 = new JLabel("Peso:");
			lblNewLabel_2.setBounds(10, 105, 46, 14);
			panel_2.add(lblNewLabel_2);

			spnPeso = new JSpinner();
			spnPeso.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			spnPeso.setBounds(141, 102, 59, 20);
			panel_2.add(spnPeso);

			JLabel lblNewLabel_3 = new JLabel("Estatura:");
			lblNewLabel_3.setBounds(10, 78, 72, 14);
			panel_2.add(lblNewLabel_3);

			spnEstatura = new JSpinner();
			spnEstatura.addKeyListener(new KeyAdapter() {
				//@Override
				//public void keyTyped(KeyEvent arg0) {
				//}
			});
			spnEstatura.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			spnEstatura.setBounds(141, 75, 59, 20);
			panel_2.add(spnEstatura);

			JLabel lblNewLabel_4 = new JLabel("Presi\u00F3n alterial:");
			lblNewLabel_4.setBounds(10, 132, 109, 14);
			panel_2.add(lblNewLabel_4);

			spnPresion = new JSpinner();
			spnPresion.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			spnPresion.setBounds(141, 129, 59, 20);
			panel_2.add(spnPresion);

			JLabel lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.setIcon(new ImageIcon(RegConsulta.class.getResource("/Imagenes/paciente (2).png")));
			lblNewLabel_8.setBounds(320, 24, 128, 130);
			panel_2.add(lblNewLabel_8);

			JLabel lblNewLabel_10 = new JLabel("cm.");
			lblNewLabel_10.setBounds(208, 77, 26, 16);
			panel_2.add(lblNewLabel_10);

			JLabel lblNewLabel_11 = new JLabel("lb.");
			lblNewLabel_11.setBounds(208, 104, 20, 16);
			panel_2.add(lblNewLabel_11);

			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(10, 281, 488, 258);
			pnlConsulta.add(panel_3);
			panel_3.setLayout(null);

			JLabel lblNewLabel_5 = new JLabel("S\u00EDntomas: ");
			lblNewLabel_5.setBounds(10, 36, 93, 14);
			panel_3.add(lblNewLabel_5);

			JLabel lblDiagnostico = new JLabel("Diagn\u00F3stico");
			lblDiagnostico.setBounds(269, 11, 85, 14);
			panel_3.add(lblDiagnostico);

			JLabel lblNewLabel_6 = new JLabel("\u00BFGuardar en el historial cl\u00EDnico?");
			lblNewLabel_6.setBounds(10, 206, 229, 14);
			panel_3.add(lblNewLabel_6);

			rdbSi = new JRadioButton("S\u00ED");
			rdbSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbSi.setSelected(true);
					RdbNo.setSelected(false);
				}
			});
			rdbSi.setBounds(10, 224, 57, 25);
			panel_3.add(rdbSi);

			RdbNo = new JRadioButton("No");
			RdbNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbSi.setSelected(false);
					RdbNo.setSelected(true);
				}
			});
			RdbNo.setBounds(88, 224, 63, 25);
			panel_3.add(RdbNo);

			txtDiagnostico = new JTextPane();
			txtDiagnostico.setBounds(269, 38, 207, 207);
			panel_3.add(txtDiagnostico);

			JButton btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SeleccionarSintomas nuevo = new SeleccionarSintomas();
					nuevo.setModal(true);
					nuevo.setVisible(true);
					sintomas = Clinica.getInstance().getSintomasPaciente();
					posibleEnfermedad = Clinica.getInstance().buscarEnfermedadesPorSintomas(sintomas);
					cbxEnfermedad.removeAllItems();
					cbxEnfermedad.setModel(new DefaultComboBoxModel<Object>(
							new String[] { "<Seleccione>"}));
					ArrayList<String> nombres = new ArrayList<>();
					for (Enfermedad enfermedad : posibleEnfermedad) {
						if(!nombres.contains(enfermedad.getEnfermedadNombre())) {
							cbxEnfermedad.addItem(enfermedad.getEnfermedadNombre());
							nombres.add(enfermedad.getEnfermedadNombre());
						}
					}
					Clinica.getInstance().getSintomasPaciente().clear();
				}
			});
			btnSeleccionar.setBounds(88, 31, 125, 25);
			panel_3.add(btnSeleccionar);

			JLabel lblNewLabel_12 = new JLabel("Posibles Enfermedades: ");
			lblNewLabel_12.setBounds(10, 63, 203, 16);
			panel_3.add(lblNewLabel_12);

			cbxEnfermedad = new JComboBox<Object>();
			cbxEnfermedad.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccione>"}));
			cbxEnfermedad.setBounds(12, 92, 201, 22);
			panel_3.add(cbxEnfermedad);
			
			JLabel lblNewLabel_13 = new JLabel("Enfermo");
			lblNewLabel_13.setBounds(12, 134, 56, 16);
			panel_3.add(lblNewLabel_13);
			
			rdbtEnfermoSi = new JRadioButton("S\u00ED");
			rdbtEnfermoSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbtEnfermoSi.setSelected(true);
					rdbtnEnfermoNo.setSelected(false);
					
				}
			});
			rdbtEnfermoSi.setBounds(10, 159, 63, 25);
			panel_3.add(rdbtEnfermoSi);
			
			rdbtnEnfermoNo = new JRadioButton("No");
			rdbtnEnfermoNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnEnfermoNo.setSelected(true);
					rdbtEnfermoSi.setSelected(false);
				}
			});
			rdbtnEnfermoNo.setBounds(90, 159, 63, 25);
			panel_3.add(rdbtnEnfermoNo);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				buttonPane.setBounds(0, 552, 510, 42);
				pnlConsulta.add(buttonPane);
				{
					JButton okButton = new JButton("Guardar");
					okButton.setBounds(316, 7, 91, 25);
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if (cbxCita.getSelectedIndex() == 0  /*|| Integer.valueOf(spnEstatura.getValue().toString()) <= 0 
									|| Integer.valueOf(spnPeso.getValue().toString()) <= 0 || Integer.valueOf(spnPresion.getValue().toString()) <= 0
									*/|| cbxSangre.getSelectedIndex() == 0 || cbxEnfermedad.getSelectedIndex() == 0 || txtDiagnostico.getText().equals("")) {
								
								JOptionPane.showMessageDialog(null, "Debe llenar todos los campos para guardar", "Información",
										JOptionPane.INFORMATION_MESSAGE);
								
							
							}else {
								String codigoCita = cbxCita.getSelectedItem().toString();
								Cita laCita = Clinica.getInstance().buscarCitaCod(codigoCita);
								
								Persona persona = Clinica.getInstance().buscarPersonaPorNombre(laCita.getPersona());
								Paciente paciente = null;
								
								if (Clinica.getInstance().buscarPaciente(persona.getCedula()) == null) {
									String edad = new String(spnNacimiento.getValue().toString());
									float peso = new Float(spnPeso.getValue().toString());
									float estatura = new Float(spnEstatura.getValue().toString());
									float presion = new Float(spnPresion.getValue().toString());

									paciente = new Paciente(persona.getCedula(), persona.getNombre(),
											persona.getDireccion(), persona.getTelefono(), persona.getSexo(),
											cbxSangre.getSelectedItem().toString(), edad, peso, estatura, presion);
									
									
									Clinica.getInstance().agregarPaciemnte(paciente);
									selecteDoctor.agregarPaciente(paciente);
								}

								txtIdCita.setText(persona.getNombre());

								SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
								String spinnerValue = formater.format(spnNacimiento.getValue());
								String fechaString = spinnerValue.toString();
								
								Consulta auxConsulta = new Consulta(laCita.getCodigo(), laCita.getPersona(),
										laCita.getDoctor(), fechaString, sintomas,
										txtDiagnostico.getText(), cbxEnfermedad.getSelectedItem().toString(), laCita.getFecha().toString());

								Clinica.getInstance().agregarConsulta(auxConsulta);

								if (rdbSi.isSelected()) {
									HistorialClinico auxHistorialClinico = new HistorialClinico(laCita.getCodigo(),
											persona.getCedula(), laCita.getDoctor(), laCita.getFecha().toString(),
											auxConsulta);
									Clinica.getInstance().agregarHistorial(auxHistorialClinico);
									Clinica.getInstance().buscarPaciente(laCita.getCedula()).agregarHistorial(auxHistorialClinico);
									//paciente.agregarHistorial(auxHistorialClinico);
								}

								JOptionPane.showMessageDialog(null, "Operación exitosa", "Información",
										JOptionPane.INFORMATION_MESSAGE);
								Clinica.getClinica().getMisCitas().remove(laCita);
								loadTablePaciente(selecteDoctor);
								clean();
							}
							
							
						}

					});
					buttonPane.setLayout(null);
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
				{
					JButton cancelButton = new JButton("Cancelar");
					cancelButton.setBounds(412, 7, 91, 25);
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
						}
					});
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
			}
		}

		JPanel pnlPacientes = new JPanel();
		pnlPacientes.setBounds(1, 7, 510, 594);
		contentPanel.add(pnlPacientes, BorderLayout.CENTER);
		pnlPacientes.setLayout(null);
		{
			JScrollPane scrollPacientes = new JScrollPane();
			scrollPacientes.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPacientes.setBounds(5, 5, 502, 543);
			pnlPacientes.add(scrollPacientes);
			{
				String headersPaciente[] = { "Cedula", "Nombre", "Telefono" };
				modelListPaciente = new DefaultTableModel();
				modelListPaciente.setColumnIdentifiers(headersPaciente);
				tablaPaciente = new JTable();
				tablaPaciente.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						int row = -1;
						row = tablaPaciente.getSelectedRow();
						if(row>-1){
							btnHistorial.setEnabled(true);
							selectedPaciente = Clinica.getInstance().buscarPaciente(tablaPaciente.getValueAt(row, 0).toString());
						}
					}
				});
				tablaPaciente.setModel(modelListPaciente);
				scrollPacientes.setViewportView(tablaPaciente);
			}

		}
		
		JPanel buttonPaneHistorial = new JPanel();
		buttonPaneHistorial.setLayout(null);
		buttonPaneHistorial.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buttonPaneHistorial.setBounds(0, 552, 510, 42);
		pnlPacientes.add(buttonPaneHistorial);
		
		btnHistorial = new JButton("Historial");
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HistorialPaciente histPaciente = new HistorialPaciente(selectedPaciente);
				histPaciente.setModal(true);
				histPaciente.setVisible(true);
			}
		});
		btnHistorial.setActionCommand("Cancel");
		btnHistorial.setBounds(420, 7, 83, 25);
		buttonPaneHistorial.add(btnHistorial);

		JPanel pnlListCita = new JPanel();
		pnlListCita.setBounds(1, 7, 510, 558);
		contentPanel.add(pnlListCita, BorderLayout.CENTER);
		pnlListCita.setLayout(null);
		{
			JScrollPane scrollCita = new JScrollPane();
			scrollCita.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollCita.setBounds(5, 5, 502, 550);
			pnlListCita.add(scrollCita);
			{
				String headersCita[] = { "Cita" , "Cédula" , "Nombre", "Fecha" };
				modelListCita = new DefaultTableModel();
				modelListCita.setColumnIdentifiers(headersCita);
				tablaCita = new JTable();
				tablaCita.setModel(modelListCita);
				scrollCita.setViewportView(tablaCita);
			}
		}

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		tglConsulta = new JToggleButton("Consulta");
		tglConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglListCita.setSelected(false);
				tglPacientes.setSelected(false);
				tglConsulta.setSelected(true);
				pnlConsulta.setVisible(true);
				pnlListCita.setVisible(false);
				pnlPacientes.setVisible(false);

			}
		});
		tglConsulta.setSelected(true);
		tglConsulta.setIcon(new ImageIcon(RegConsulta.class.getResource("/Imagenes/bloc-de-notas-y-lapiz.png")));
		menuBar.add(tglConsulta);

		tglListCita = new JToggleButton("Listado de Citas");
		tglListCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglListCita.setSelected(true);
				tglPacientes.setSelected(false);
				tglConsulta.setSelected(false);
				pnlConsulta.setVisible(false);
				pnlListCita.setVisible(true);
				pnlPacientes.setVisible(false);

			}
		});
		tglListCita.setIcon(new ImageIcon(RegConsulta.class.getResource("/Imagenes/portapapeles.png")));
		menuBar.add(tglListCita);

		tglPacientes = new JToggleButton("Listado de Pacientes");
		tglPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglListCita.setSelected(false);
				tglPacientes.setSelected(true);
				tglConsulta.setSelected(false);
				pnlConsulta.setVisible(false);
				pnlListCita.setVisible(false);
				pnlPacientes.setVisible(true);

			}
		});
		tglPacientes.setIcon(new ImageIcon(RegConsulta.class.getResource("/Imagenes/medicoIcon.png")));
		menuBar.add(tglPacientes);
		if(selecteDoctor.getMisCitas().size()>0) {
			loadTableCita(selecteDoctor);
		}
		
		if(selecteDoctor.getMisPacientes().size()>0) {
			loadTablePaciente(selecteDoctor);
		}
		
		
	}


	private void clean() {
		cbxCita.removeAll();
		cbxCita.setModel(new DefaultComboBoxModel<String>(new String[] { "<Seleccione>" }));
		for (int i = 0; i < Clinica.getInstance().getMisCitas().size(); i++) {
			cbxCita.addItem(Clinica.getInstance().getMisCitas().get(i).getCodigo());
		}
		cbxCita.setSelectedIndex(0);
		spnNacimiento.setValue(new Date());
		spnPeso.setValue(0);
		spnPresion.setValue(0);
		spnEstatura.setValue(0);
		cbxSangre.setSelectedIndex(0);
		cbxEnfermedad.setSelectedIndex(0);

		txtDiagnostico.setText("");
		rdbSi.setSelected(true);
		RdbNo.setSelected(false);
		rdbtnEnfermoNo.setSelected(false);
		rdbtEnfermoSi.setSelected(false);
	}

	private void loadTablePaciente(Doctor elDoctor) {
		modelListPaciente.setRowCount(0);
		rowPaciete = new Object[modelListPaciente.getColumnCount()];
		for (int i = 0; i < elDoctor.getMisPacientes().size(); i++) {
			rowPaciete[0] = elDoctor.getMisPacientes().get(i).getCedula();
			rowPaciete[1] = elDoctor.getMisPacientes().get(i).getNombre();
			rowPaciete[2] = elDoctor.getMisPacientes().get(i).getTelefono();
			modelListPaciente.addRow(rowPaciete);

		}
	}

	private void loadTableCita(Doctor elDoctor) {
		modelListCita.setRowCount(0);
		rowCita = new Object[modelListCita.getColumnCount()];
		for (int i = 0; i < elDoctor.getMisCitas().size(); i++) {
			rowCita[0] = elDoctor.getMisCitas().get(i).getCodigo();
			rowCita[1] = elDoctor.getMisCitas().get(i).getCedula();
			rowCita[2] = elDoctor.getMisCitas().get(i).getPersona();
			rowCita[3] = elDoctor.getMisCitas().get(i).getFecha();
			
			modelListCita.addRow(rowCita);

		}
	}
}
