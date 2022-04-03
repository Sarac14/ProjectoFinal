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

public class RegDoctor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JComboBox cbxEspecialidad;
	private JRadioButton rdbSexoM;
	private JRadioButton rdbSexoF;
	private JLabel lblMedicoF;
	private JLabel lblMedicoM;
	private JSpinner spnExperiencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegDoctor dialog = new RegDoctor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegDoctor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegDoctor.class.getResource("/Imagenes/seguro-de-salud.png")));
		setTitle("Registrar Doctor");
		setBounds(100, 100, 422, 401);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(12, 71, 56, 23);
		panel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(12, 96, 170, 22);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula: ");
		lblNewLabel_1.setBounds(12, 13, 56, 23);
		panel.add(lblNewLabel_1);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(12, 35, 170, 22);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtTelefono = new JTextField();
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
		txtDireccion.setBounds(12, 212, 370, 22);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Especialidad: ");
		lblNewLabel_4.setBounds(12, 248, 96, 16);
		panel.add(lblNewLabel_4);
		
		cbxEspecialidad = new JComboBox();
		cbxEspecialidad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Pediatra", "Cirujano", "Psicologo", "Cardiologo", "Dermatologo", "Endocrinologo", "Gastroenterologo", "Oftalmologo", "Otorrinolaringologo", "Neumologo", "Neurologo", "Radiologo", "Anestesiologo", "Oncologo", "Patologo", "Urologo"}));
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						char sexo;
						if(rdbSexoF.isSelected()) {
							sexo ='F';
						}else {
							sexo ='M';
						}
						Doctor aux = new Doctor(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(),sexo, cbxEspecialidad.getSelectedItem().toString()); 
						Clinica.getInstance().agregarDoctor(aux);
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
	}
	private void clean() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		spnExperiencia.setValue(0);
		cbxEspecialidad.setSelectedIndex(0);
	
		
	}
}
