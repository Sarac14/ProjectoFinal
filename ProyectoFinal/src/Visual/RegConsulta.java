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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class RegConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cbxSangre;
	private JSpinner spnEdad;
	private JSpinner spnPeso;
	private JTextField txtSintomas;
	private JTextField txtDiagnostico;
	private JRadioButton rdbSi;
	private JRadioButton RdbNo;
	private JComboBox cbxCita;
	private JSpinner spnPresion;
	private JSpinner spnEstatura;
	private JTextField txtFecha;

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
		setBounds(100, 100, 394, 508);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cita", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 11, 344, 62);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			cbxCita = new JComboBox();
			cbxCita.setModel(new DefaultComboBoxModel(new String[] {"Seleccione"}));
			for(int i = 0; i < Clinica.getInstance().getMisCitas().size(); i++) {
				cbxCita.addItem(Clinica.getInstance().getMisCitas().get(i).getCedula());
			}
			cbxCita.setBounds(10, 30, 171, 20);
			panel_1.add(cbxCita);
			
			txtFecha = new JTextField();
			txtFecha.setEditable(false);
			txtFecha.setBounds(209, 30, 86, 20);
			panel_1.add(txtFecha);
			txtFecha.setColumns(10);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Datos del paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 74, 344, 152);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Tipo de Sangre:");
			lblNewLabel.setBounds(10, 118, 92, 14);
			panel_2.add(lblNewLabel);
			
			cbxSangre = new JComboBox();
			cbxSangre.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
			cbxSangre.setBounds(111, 115, 109, 20);
			panel_2.add(cbxSangre);
			
			JLabel lblNewLabel_1 = new JLabel("Edad:");
			lblNewLabel_1.setBounds(10, 38, 46, 14);
			panel_2.add(lblNewLabel_1);
			
			spnEdad = new JSpinner();
			spnEdad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnEdad.setBounds(45, 35, 59, 20);
			panel_2.add(spnEdad);
			
			JLabel lblNewLabel_2 = new JLabel("Peso:");
			lblNewLabel_2.setBounds(10, 77, 46, 14);
			panel_2.add(lblNewLabel_2);
			
			spnPeso = new JSpinner();
			spnPeso.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			spnPeso.setBounds(45, 74, 59, 20);
			panel_2.add(spnPeso);
			
			JLabel lblNewLabel_3 = new JLabel("Estatura:");
			lblNewLabel_3.setBounds(141, 38, 72, 14);
			panel_2.add(lblNewLabel_3);
			
			spnEstatura = new JSpinner();
			spnEstatura.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			spnEstatura.setBounds(243, 35, 59, 20);
			panel_2.add(spnEstatura);
			
			JLabel lblNewLabel_4 = new JLabel("Presi\u00F3n alterial:");
			lblNewLabel_4.setBounds(141, 77, 109, 14);
			panel_2.add(lblNewLabel_4);
			
			spnPresion = new JSpinner();
			spnPresion.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
			spnPresion.setBounds(243, 74, 59, 20);
			panel_2.add(spnPresion);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(10, 230, 344, 194);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			txtSintomas = new JTextField();
			txtSintomas.setBounds(10, 31, 140, 112);
			panel_3.add(txtSintomas);
			txtSintomas.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Sintomas");
			lblNewLabel_5.setBounds(10, 17, 93, 14);
			panel_3.add(lblNewLabel_5);
			
			txtDiagnostico = new JTextField();
			txtDiagnostico.setColumns(10);
			txtDiagnostico.setBounds(194, 31, 140, 112);
			panel_3.add(txtDiagnostico);
			
			JLabel lblDiagnostico = new JLabel("Diagnostico");
			lblDiagnostico.setBounds(194, 17, 85, 14);
			panel_3.add(lblDiagnostico);
			
			JLabel lblNewLabel_6 = new JLabel("\u00BFGuardar en el historial cl\u00EDnico?");
			lblNewLabel_6.setBounds(10, 154, 312, 14);
			panel_3.add(lblNewLabel_6);
			
			rdbSi = new JRadioButton("Si");
			rdbSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbSi.setSelected(true);
					RdbNo.setSelected(false);
				}
			});
			rdbSi.setBounds(6, 173, 57, 14);
			panel_3.add(rdbSi);
			
			RdbNo = new JRadioButton("No");
			RdbNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbSi.setSelected(false);
					RdbNo.setSelected(true);
				}
			});
			RdbNo.setBounds(88, 174, 109, 12);
			panel_3.add(RdbNo);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBounds(-12, 423, 378, 33);
				panel.add(buttonPane);
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				{
					JButton okButton = new JButton("Guardar");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String codigoCita = cbxCita.getSelectedItem().toString();
							Cita laCita = Clinica.getInstance().buscarCita(codigoCita); 
							/*SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
							txtFecha.setText(format.format(laCita.getFecha()));*/
							Persona persona = Clinica.getInstance().buscarPersonaPorNombre(laCita.getPersona());
							
							if(Clinica.getInstance().buscarPaciente(persona.getCedula()) == null) {
								int edad = new Integer(spnEdad.getValue().toString());
								float peso = new Float(spnPeso.getValue().toString());
								float estatura = new Float(spnEstatura.getValue().toString());
								float presion = new Float(spnPresion.getValue().toString());
								
								Paciente paciente = new Paciente(persona.getCedula(),persona.getNombre(), persona.getDireccion(), persona.getTelefono(),
										cbxSangre.getSelectedItem().toString(), edad,peso,estatura,presion);
								Clinica.getInstance().agregarPaciemnte(paciente);
							}
							
							txtFecha.setText(persona.getNombre());

							Consulta auxConsulta = new Consulta(laCita.getCedula(),laCita.getPersona(),laCita.getDoctor(),laCita.getFecha().toString(),txtSintomas.getText(),txtDiagnostico.getText());

							//Consulta auxConsulta = new Consulta(laCita.getCedula().get,codigoCita.getPersona(),codigoCita.getDoctor(),codigoCita.getFecha().to,txtSintomas.getText(),txtDiagnostico.getText());
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

	}
	private void clean() {
		cbxCita.setSelectedIndex(0);
		spnEdad.setValue(0);
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
