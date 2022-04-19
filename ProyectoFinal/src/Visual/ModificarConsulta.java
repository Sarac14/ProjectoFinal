package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import logico.Clinica;
import logico.Consulta;
import logico.Paciente;
import logico.Persona;

import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDoctor;
	private JTextField textField_1;
	private JTextField txtIdConsuta;
	private JTextField txtNombre;
	private JTextField txtNacimiento;
	private JTextField txtEstatura;
	private JTextField txtSangre;
	private JTextField txtPeso;
	private JTextField txtEnfermedad;
	private JRadioButton rdbtnEnfermo;
	private JRadioButton rdbtnSano;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			ModificarConsulta dialog = new ModificarConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 * Create the dialog.
	 */
	public ModificarConsulta(Consulta consulta) {
		setTitle("Modificar Consulta");
		setBounds(100, 100, 509, 577);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Datos de la Consulta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 9, 460, 102);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("ID Consuta:");
			lblNewLabel.setBounds(245, 34, 99, 16);
			panel_1.add(lblNewLabel);
			
			txtDoctor = new JTextField();
			txtDoctor.setEditable(false);
			txtDoctor.setBounds(65, 31, 143, 22);
			panel_1.add(txtDoctor);
			txtDoctor.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Fecha:");
			lblNewLabel_1.setBounds(245, 63, 99, 16);
			panel_1.add(lblNewLabel_1);
			
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setBounds(324, 60, 116, 22);
			panel_1.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Doctor: ");
			lblNewLabel_2.setBounds(12, 34, 56, 16);
			panel_1.add(lblNewLabel_2);
			
			txtIdConsuta = new JTextField();
			txtIdConsuta.setEditable(false);
			txtIdConsuta.setBounds(324, 31, 116, 22);
			panel_1.add(txtIdConsuta);
			txtIdConsuta.setColumns(10);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(10, 124, 460, 108);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("Nacimiento:");
			lblNewLabel_3.setBounds(245, 31, 81, 16);
			panel_2.add(lblNewLabel_3);
			
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setBounds(65, 28, 143, 22);
			panel_2.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Nombre: ");
			lblNewLabel_4.setBounds(12, 31, 68, 16);
			panel_2.add(lblNewLabel_4);
			
			txtNacimiento = new JTextField();
			txtNacimiento.setEditable(false);
			txtNacimiento.setBounds(324, 28, 116, 22);
			panel_2.add(txtNacimiento);
			txtNacimiento.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("Estatura: ");
			lblNewLabel_5.setBounds(12, 63, 68, 16);
			panel_2.add(lblNewLabel_5);
			
			txtEstatura = new JTextField();
			txtEstatura.setEditable(false);
			txtEstatura.setBounds(65, 60, 57, 22);
			panel_2.add(txtEstatura);
			txtEstatura.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Peso: ");
			lblNewLabel_6.setBounds(191, 63, 41, 16);
			panel_2.add(lblNewLabel_6);
			
			txtSangre = new JTextField();
			txtSangre.setEditable(false);
			txtSangre.setBounds(383, 60, 57, 22);
			panel_2.add(txtSangre);
			txtSangre.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("Sangre:");
			lblNewLabel_7.setBounds(334, 63, 52, 16);
			panel_2.add(lblNewLabel_7);
			
			txtPeso = new JTextField();
			txtPeso.setEditable(false);
			txtPeso.setBounds(225, 60, 57, 22);
			panel_2.add(txtPeso);
			txtPeso.setColumns(10);
			
			JLabel lblNewLabel_9 = new JLabel("Cm.");
			lblNewLabel_9.setBounds(123, 63, 41, 16);
			panel_2.add(lblNewLabel_9);
			
			JLabel lblNewLabel_10 = new JLabel("Lb.");
			lblNewLabel_10.setBounds(284, 63, 29, 16);
			panel_2.add(lblNewLabel_10);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Diagnostico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(10, 245, 460, 229);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_8 = new JLabel("Enfermedad:");
			lblNewLabel_8.setBounds(12, 29, 83, 16);
			panel_3.add(lblNewLabel_8);
			
			txtEnfermedad = new JTextField();
			txtEnfermedad.setEditable(false);
			txtEnfermedad.setBounds(12, 55, 196, 22);
			panel_3.add(txtEnfermedad);
			txtEnfermedad.setColumns(10);
			
			JLabel lblNewLabel_11 = new JLabel("Estado del Paciente:");
			lblNewLabel_11.setBounds(245, 29, 162, 16);
			panel_3.add(lblNewLabel_11);
			
			rdbtnEnfermo = new JRadioButton("Enfermo");
			rdbtnEnfermo.setBounds(245, 54, 83, 25);
			panel_3.add(rdbtnEnfermo);
			
			rdbtnSano = new JRadioButton("Sano");
			rdbtnSano.setBounds(369, 54, 71, 25);
			panel_3.add(rdbtnSano);
			
			JLabel lblNewLabel_12 = new JLabel("Diagnostico:");
			lblNewLabel_12.setBounds(12, 100, 83, 16);
			panel_3.add(lblNewLabel_12);
			
			JTextPane textPane = new JTextPane();
			textPane.setBounds(12, 129, 428, 85);
			panel_3.add(textPane);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadConsulta(consulta);
		
	}

	private void loadConsulta(Consulta consulta) {
		Paciente auxPaciente = Clinica.getInstance().buscarPacientePorNombre(consulta.getPaciente().toString());
		
		txtIdConsuta.setText(consulta.getCodigo());
		txtDoctor.setText(consulta.getDoctor());
		txtEnfermedad.setText(consulta.getEnfermedad());
		txtEstatura.setText(auxPaciente.getNombre());
		
		
	}
}
