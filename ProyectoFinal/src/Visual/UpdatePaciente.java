package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Clinica;
import logico.Paciente;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UpdatePaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private Paciente newPaciente = null;
	private JSpinner spnFechaNac;
	private JSpinner spnPeso;
	private JSpinner spnEstatura;
	private JComboBox cbxSangre;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			UpdatePaciente dialog = new UpdatePaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public UpdatePaciente(Paciente paciente) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdatePaciente.class.getResource("/Imagenes/seguro-de-salud.png")));
		newPaciente = paciente;
		setTitle("Modificar paciente");
		setBounds(100, 100, 590, 343);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("C\u00E9dula:");
				lblNewLabel.setBounds(10, 24, 61, 14);
				panel.add(lblNewLabel);
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
				txtCedula.setBounds(89, 21, 446, 20);
				panel.add(txtCedula);
				txtCedula.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(10, 73, 68, 14);
				panel.add(lblNewLabel_1);
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
				txtNombre.setBounds(89, 70, 180, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				JLabel telefono = new JLabel("Tel\u00E9fono:");
				telefono.setBounds(279, 67, 75, 27);
				panel.add(telefono);
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

				txtTelefono.setBounds(366, 70, 169, 20);
				panel.add(txtTelefono);
				txtTelefono.setColumns(10);
			}

			JLabel lblNewLabel_3 = new JLabel("F. Nacimiento:");
			lblNewLabel_3.setBounds(10, 127, 90, 14);
			panel.add(lblNewLabel_3);

			spnFechaNac = new JSpinner();
			spnFechaNac.setModel(new SpinnerDateModel(new Date(1650168000000L), null, null, Calendar.DAY_OF_YEAR));
			spnFechaNac.setEditor(new JSpinner.DateEditor(spnFechaNac, "dd/MM/yyyy"));
			spnFechaNac.setBounds(89, 124, 180, 20);
			panel.add(spnFechaNac);

			JLabel lblNewLabel_2 = new JLabel("Direcci\u00F3n:");
			lblNewLabel_2.setBounds(10, 220, 75, 20);
			panel.add(lblNewLabel_2);

			txtDireccion = new JTextField();
			txtDireccion.setBounds(89, 220, 446, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Peso:");
			lblNewLabel_4.setBounds(10, 170, 46, 14);
			panel.add(lblNewLabel_4);
			
			spnPeso = new JSpinner();
			spnPeso.setBounds(89, 167, 180, 20);
			panel.add(spnPeso);
			
			JLabel lblNewLabel_5 = new JLabel("Estatura:");
			lblNewLabel_5.setBounds(279, 170, 46, 14);
			panel.add(lblNewLabel_5);
			
			spnEstatura = new JSpinner();
			spnEstatura.setBounds(366, 167, 169, 20);
			panel.add(spnEstatura);
			{
				JLabel lblNewLabel_6 = new JLabel("Tipo de Sangre:");
				lblNewLabel_6.setBounds(279, 127, 90, 14);
				panel.add(lblNewLabel_6);
			}
			
			cbxSangre = new JComboBox();
			cbxSangre.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
			cbxSangre.setBounds(366, 124, 169, 20);
			panel.add(cbxSangre);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						newPaciente.setNombre(txtNombre.getText());
						newPaciente.setDireccion(txtDireccion.getText());
						newPaciente.setTelefono(txtTelefono.getText());
						newPaciente.setCedula(txtCedula.getText());
						String edad = new String(spnFechaNac.getValue().toString());
						newPaciente.setEdad(edad);
						float estatura = new Float(spnEstatura.getValue().toString());						
						newPaciente.setEstatura(estatura);
						float peso = new Float(spnPeso.getValue().toString());
						newPaciente.setPeso(peso);
						newPaciente.setTipoSangre(cbxSangre.getSelectedItem().toString());
						Clinica.getInstance().modificarPaciente(newPaciente);
						JOptionPane.showMessageDialog(null, "Operacion exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						ListPaciente.loadTable();
						dispose();
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
		loadPaciente(newPaciente);
	}

	private void loadPaciente(Paciente newPaciente2) {
		txtNombre.setText(newPaciente2.getNombre());
		txtCedula.setText(newPaciente2.getCedula());
		txtDireccion.setText(newPaciente2.getDireccion());
		txtTelefono.setText(newPaciente2.getTelefono());
		//spnFechaNac.setValue(newPaciente2.getEdad());
		spnEstatura.setValue(newPaciente2.getEstatura());
		spnPeso.setValue(newPaciente2.getPeso());
		cbxSangre.setSelectedItem(newPaciente2.getTipoSangre());
	}	
}
