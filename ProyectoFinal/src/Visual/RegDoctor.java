package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Clinica;
import logico.Doctor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;

import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.KeyAdapter;

public class RegDoctor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JButton btnCancelar;
	private JComboBox<Object> cbxEspecialidad;
	private JRadioButton rdbSexoM;
	private JRadioButton rdbSexoF;
	private JLabel lblMedicoF;
	private JLabel lblMedicoM;
	private JSpinner spnExperiencia;
	private JPanel panel_1;
	private JLabel lblNewLabel_5;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JLabel lblNewLabel_8;
	private Doctor elDoctor = null;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			RegDoctor dialog = new RegDoctor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public RegDoctor(Doctor doctor) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegDoctor.class.getResource("/Imagenes/seguro-de-salud.png")));
		elDoctor = doctor;
		if(elDoctor == null) {
			setTitle("Registrar Prestamos");
		}else {
			setTitle("Modificar Prestamo");
			txtCedula.setEnabled(false);
		}
		setBounds(100, 100, 433, 502);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);


		JPanel panel = new JPanel();
		panel.setBounds(12, 5, 391, 302);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(12, 71, 56, 23);
		panel.add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {                                    
				int key = evt.getKeyChar();

				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;

				if (!(minusculas || mayusculas || espacio))
				{
					evt.consume();
				}
			}    
		});
		txtNombre.setBounds(12, 96, 170, 22);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Cedula: ");
		lblNewLabel_1.setBounds(12, 13, 56, 23);
		panel.add(lblNewLabel_1);

		txtCedula = new JTextField();
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {                                    
				int key = evt.getKeyChar();

				boolean numeros = key >= 48 && key <= 57;

				if (!numeros)
				{
					evt.consume();
				}

				if (txtCedula.getText().trim().length() == 10) {
					evt.consume();
				}
			}  


		});
		txtCedula.setBounds(12, 35, 170, 22);
		panel.add(txtCedula);
		txtCedula.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {                                    
				int key = evt.getKeyChar();

				boolean numeros = key >= 48 && key <= 57;

				if (!numeros)
				{
					evt.consume();
				}

				if (txtTelefono.getText().trim().length() == 10) {
					evt.consume();
				}
			}  
		});
		txtTelefono.setBounds(12, 155, 170, 22);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Telefono: ");
		lblNewLabel_2.setBounds(12, 132, 96, 23);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n: ");
		lblNewLabel_3.setBounds(12, 191, 96, 23);
		panel.add(lblNewLabel_3);

		txtDireccion = new JTextField();
		txtDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {                                    
				int key = evt.getKeyChar();

				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;

				if (!(minusculas || mayusculas || espacio))
				{
					evt.consume();
				}
			}    
		});
		txtDireccion.setBounds(12, 212, 370, 22);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Especialidad: ");
		lblNewLabel_4.setBounds(12, 248, 96, 16);
		panel.add(lblNewLabel_4);

		cbxEspecialidad = new JComboBox<Object>();
		cbxEspecialidad.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Seleccione>", "Pediatra", "Cirujano", "Psicólogo", "Cardiologo", "Dermatologo", "Endocrinologo", "Gastroenterologo", "Oftalmologo", "Otorrinolaringologo", "Neumologo", "Neurologo", "Radiologo", "Anestesiologo", "Oncologo", "Patologo", "Urologo"}));
		cbxEspecialidad.setBounds(12, 266, 125, 22);
		panel.add(cbxEspecialidad);

		lblMedicoM = new JLabel("New label");
		lblMedicoM.setIcon(new ImageIcon(RegDoctor.class.getResource("/Imagenes/medico.png")));
		lblMedicoM.setBounds(224, 37, 125, 140);
		panel.add(lblMedicoM);

		JLabel lblNewLabel_6 = new JLabel("Experiencia:");
		lblNewLabel_6.setBounds(165, 248, 88, 16);
		panel.add(lblNewLabel_6);

		spnExperiencia = new JSpinner();
		spnExperiencia.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnExperiencia.setBounds(165, 266, 66, 22);
		panel.add(spnExperiencia);

		JLabel lblNewLabel_7 = new JLabel("Sexo:");
		lblNewLabel_7.setBounds(293, 248, 56, 16);
		panel.add(lblNewLabel_7);

		rdbSexoM = new JRadioButton("M");
		rdbSexoM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbSexoM.setSelected(true);
				lblMedicoM.setVisible(true);
				lblMedicoF.setVisible(false);
				rdbSexoF.setSelected(false);

			}
		});
		rdbSexoM.setSelected(true);
		lblMedicoM.setVisible(true);
		rdbSexoM.setBounds(266, 265, 46, 22);
		panel.add(rdbSexoM);

		rdbSexoF = new JRadioButton("F");
		rdbSexoF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbSexoM.setSelected(false);
				lblMedicoM.setVisible(false);
				lblMedicoF.setVisible(true);
				rdbSexoF.setSelected(true);
			}
		});

		rdbSexoF.setBounds(317, 265, 46, 22);
		panel.add(rdbSexoF);

		lblMedicoF = new JLabel("New label");
		lblMedicoF.setVisible(false);
		lblMedicoF.setIcon(new ImageIcon(RegDoctor.class.getResource("/Imagenes/doctora.png")));
		lblMedicoF.setBounds(224, 38, 125, 139);
		panel.add(lblMedicoF);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de Inicio de Sesi\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(12, 320, 391, 87);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_5 = new JLabel("Usuario:");
		lblNewLabel_5.setBounds(12, 23, 56, 16);
		panel_1.add(lblNewLabel_5);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(12, 52, 170, 22);
		panel_1.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContraseña = new JTextField();
		txtContraseña.setBounds(209, 52, 170, 22);
		panel_1.add(txtContraseña);
		txtContraseña.setColumns(10);

		lblNewLabel_8 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_8.setBounds(209, 23, 78, 16);
		panel_1.add(lblNewLabel_8);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("");
				if(elDoctor == null) {
					btnRegistrar.setText("Registrar");
				}else {
					btnRegistrar.setText("Modificar");
				}

				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						char sexo;
						if(rdbSexoF.isSelected()) {
							sexo ='F';
						}else {
							sexo ='M';
						}
						if (elDoctor == null) {
							Doctor aux = new Doctor(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(),sexo, cbxEspecialidad.getSelectedItem().toString(),new Integer(spnExperiencia.getValue().toString()),txtUsuario.getText(),txtContraseña.getText()); 
							Clinica.getInstance().agregarDoctor(aux);

						}else {
							elDoctor.setNombre(txtNombre.getText());
							elDoctor.setCedula(txtCedula.getText());
							elDoctor.setTelefono(txtTelefono.getText());
							elDoctor.setEspecialidad(cbxEspecialidad.getSelectedItem().toString());
							elDoctor.setDireccion(txtDireccion.getText());
							elDoctor.setAnioExp(new Integer(spnExperiencia.getValue().toString()));
							elDoctor.setUsuarioDoctor(txtUsuario.getText());
							elDoctor.setContrasenaDoctor(txtContraseña.getText());
							Clinica.getInstance().modificarDoctor(elDoctor);
							dispose();
						}


						//UserDoc user = new UserDoc(txtUsuario.getText(), txtContraseña.getText());
						//InicioSesion.getInstance().regUser(user);

						JOptionPane.showMessageDialog(null, "Operacion exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}


				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadDoctor(elDoctor);
	}

	private void loadDoctor(Doctor elDoctor2) {
		if(elDoctor2 != null) {
			txtNombre.setText(elDoctor2.getNombre());
			txtCedula.setText(elDoctor2.getCedula());
			txtDireccion.setText(elDoctor2.getDireccion());
			txtTelefono.setText(elDoctor2.getTelefono());
			txtUsuario.setText(elDoctor2.getUsuarioDoctor());
			txtContraseña.setText(elDoctor2.getContrasenaDoctor());
			spnExperiencia.setValue(new Integer(elDoctor2.getAnioExp()));
		}
	}

	private void clean() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		spnExperiencia.setValue(0);
		cbxEspecialidad.setSelectedIndex(0);

		txtUsuario.setText("");
		txtContraseña.setText("");


	}
}
