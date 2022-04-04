package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalityType;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;

import logico.Cita;
import logico.Clinica;
import logico.Consulta;
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
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JToggleButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class RegConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cbxSangre;
	private JSpinner spnNacimiento;
	private JSpinner spnPeso;
	private JTextField txtSintomas;
	private JTextField txtDiagnostico;
	private JRadioButton rdbSi;
	private JRadioButton RdbNo;
	private JComboBox cbxCita;
	private JSpinner spnPresion;
	private JSpinner spnEstatura;
	private JTextField txtIdCita;
	private JTextField txtCedulaPaciente;
	private JToggleButton tglConsulta;
	private JToggleButton tglListCita;
	private JToggleButton tglPacientes;
	private JPanel pnlConsulta;
	private JTable tablaPacientes;
	private JPanel pnlListCita;
	private JPanel pnlPacientes;
	private JScrollPane scrollCita;
	private JTable tablaCitas;
	private JScrollPane scrollPacientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegConsulta dialog = new RegConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegConsulta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegConsulta.class.getResource("/Imagenes/seguro-de-salud.png")));
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setTitle("Consulta");
		setBounds(100, 100, 530, 641);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			pnlConsulta = new JPanel();
			pnlConsulta.setBounds(1, 7, 510, 558);
			contentPanel.add(pnlConsulta);
			pnlConsulta.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cita", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 11, 488, 94);
			pnlConsulta.add(panel_1);
			panel_1.setLayout(null);
			
			cbxCita = new JComboBox();
			cbxCita.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
			for(int i = 0; i < Clinica.getInstance().getMisCitas().size(); i++) {
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
			txtCedulaPaciente.setBounds(288, 28, 116, 22);
			panel_1.add(txtCedulaPaciente);
			txtCedulaPaciente.setColumns(10);
			
			JButton btnBuscarCita = new JButton("");
			btnBuscarCita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Cita laCita = null;
					laCita = Clinica.getInstance().buscarCita(txtCedulaPaciente.getText());
					txtIdCita.setText(laCita.getCodigo());
						
				}
			});
			btnBuscarCita.setIcon(new ImageIcon(RegConsulta.class.getResource("/Imagenes/lupa (2).png")));
			btnBuscarCita.setBounds(417, 18, 48, 34);
			panel_1.add(btnBuscarCita);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Datos del paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 111, 488, 167);
			pnlConsulta.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Tipo de Sangre:");
			lblNewLabel.setBounds(10, 51, 119, 14);
			panel_2.add(lblNewLabel);
			
			cbxSangre = new JComboBox();
			cbxSangre.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
			cbxSangre.setBounds(141, 48, 109, 20);
			panel_2.add(cbxSangre);
			
			JLabel lblNewLabel_1 = new JLabel("Fecha de nacimiento:");
			lblNewLabel_1.setBounds(10, 24, 137, 14);
			panel_2.add(lblNewLabel_1);
			
			spnNacimiento = new JSpinner();
			spnNacimiento.setModel(new SpinnerDateModel(new Date(1649038840570L), null, new Date(1649038840570L), Calendar.DAY_OF_YEAR));
			spnNacimiento.setEditor(new JSpinner.DateEditor(spnNacimiento,"dd/MM/yyyy"));
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
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(10, 281, 488, 222);
			pnlConsulta.add(panel_3);
			panel_3.setLayout(null);
			
			txtSintomas = new JTextField();
			txtSintomas.setBounds(10, 31, 207, 112);
			panel_3.add(txtSintomas);
			txtSintomas.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("S\u00EDntomas");
			lblNewLabel_5.setBounds(10, 17, 93, 14);
			panel_3.add(lblNewLabel_5);
			
			txtDiagnostico = new JTextField();
			txtDiagnostico.setColumns(10);
			txtDiagnostico.setBounds(269, 31, 207, 112);
			panel_3.add(txtDiagnostico);
			
			JLabel lblDiagnostico = new JLabel("Diagn\u00F3stico");
			lblDiagnostico.setBounds(269, 17, 85, 14);
			panel_3.add(lblDiagnostico);
			
			JLabel lblNewLabel_6 = new JLabel("\u00BFGuardar en el historial cl\u00EDnico?");
			lblNewLabel_6.setBounds(10, 163, 312, 14);
			panel_3.add(lblNewLabel_6);
			
			rdbSi = new JRadioButton("S\u00ED");
			rdbSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbSi.setSelected(true);
					RdbNo.setSelected(false);
				}
			});
			rdbSi.setBounds(10, 181, 57, 25);
			panel_3.add(rdbSi);
			
			RdbNo = new JRadioButton("No");
			RdbNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbSi.setSelected(false);
					RdbNo.setSelected(true);
				}
			});
			RdbNo.setBounds(88, 181, 63, 25);
			panel_3.add(RdbNo);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				buttonPane.setBounds(0, 516, 510, 42);
				pnlConsulta.add(buttonPane);
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				{
					JButton okButton = new JButton("Guardar");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String codigoCita = cbxCita.getSelectedItem().toString();
							Cita laCita = Clinica.getInstance().buscarCita(codigoCita); 
							
							Persona persona = Clinica.getInstance().buscarPersonaPorNombre(laCita.getPersona());
							
							if(Clinica.getInstance().buscarPaciente(persona.getCedula()) == null) {
								String edad = new String(spnNacimiento.getValue().toString());
								float peso = new Float(spnPeso.getValue().toString());
								float estatura = new Float(spnEstatura.getValue().toString());
								float presion = new Float(spnPresion.getValue().toString());
								
								Paciente paciente = new Paciente(persona.getCedula(),persona.getNombre(), persona.getDireccion(), persona.getTelefono(),persona.getSexo(),
										cbxSangre.getSelectedItem().toString(), edad,peso,estatura,presion);
								Clinica.getInstance().agregarPaciemnte(paciente);
							}
							
							txtIdCita.setText(persona.getNombre());

							Consulta auxConsulta = new Consulta(laCita.getCedula(),laCita.getPersona(),laCita.getDoctor(),laCita.getFecha().toString(),txtSintomas.getText(),txtDiagnostico.getText());

							Clinica.getInstance().agregarConsulta(auxConsulta);
							
							if(rdbSi.isSelected()) {
								HistorialClinico auxHistorialClinico = new HistorialClinico(laCita.getCedula(), persona.getNombre(),laCita.getDoctor(), laCita.getFecha().toString(),txtSintomas.getText(),auxConsulta);
								Clinica.getInstance().agregarHistorial(auxHistorialClinico);
							}
							
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
		
		pnlPacientes = new JPanel();
		pnlPacientes.setBounds(1, 7, 510, 558);
		contentPanel.add(pnlPacientes);
		pnlPacientes.setLayout(null);
		
		scrollCita = new JScrollPane();
		scrollCita.setBounds(0, 0, 1, 1);
		pnlPacientes.add(scrollCita);
		
		tablaCitas = new JTable();
		scrollCita.setViewportView(tablaCitas);
		
		pnlListCita = new JPanel();
		pnlListCita.setBounds(1, 7, 510, 558);
		contentPanel.add(pnlListCita);
		pnlListCita.setLayout(null);
		
		scrollPacientes = new JScrollPane();
		scrollPacientes.setBounds(0, 0, 1, 1);
		pnlListCita.add(scrollPacientes);
		
		tablaPacientes = new JTable();
		scrollPacientes.setViewportView(tablaPacientes);
		
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

	}
	private void clean() {
		cbxCita.setSelectedIndex(0);
		spnNacimiento.setValue(new Date());
		spnPeso.setValue(0);
		spnPresion.setValue(0);
		spnEstatura.setValue(0);
		cbxSangre.setSelectedIndex(0);
		txtSintomas.setText("");
		txtDiagnostico.setText("");
		rdbSi.setSelected(true);
		RdbNo.setSelected(false);
	}
}
