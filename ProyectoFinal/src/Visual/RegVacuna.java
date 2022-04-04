package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Clinica;
import logico.Persona;
import logico.Vacuna;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class RegVacuna extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JComboBox cbxEnfermedad;
	private JButton okButton;
	private JButton cancelButton;
	private JSpinner spnFecha;
	private Vacuna vacuna;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegVacuna dialog = new RegVacuna();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegVacuna() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegVacuna.class.getResource("/Imagenes/seguro-de-salud.png")));
		setTitle("Agregar Vacuna");
		setBounds(100, 100, 454, 266);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de Vacuna", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Nombre: ");
			lblNewLabel.setBounds(12, 65, 56, 16);
			panel.add(lblNewLabel);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(90, 62, 153, 22);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Codigo:");
			lblNewLabel_1.setBounds(12, 31, 56, 16);
			panel.add(lblNewLabel_1);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(90, 28, 110, 22);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Enfermedad:");
			lblNewLabel_2.setBounds(12, 100, 74, 16);
			panel.add(lblNewLabel_2);
			
			cbxEnfermedad = new JComboBox();
			cbxEnfermedad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
			for(int i=0;i<Clinica.getInstance().getMiEnfermedades().size();i++) {
				cbxEnfermedad.addItem(Clinica.getInstance().getMiEnfermedades().get(i).getEnfermedadNombre());
			}
			cbxEnfermedad.setBounds(90, 97, 153, 22);
			panel.add(cbxEnfermedad);
			
			JLabel lblNewLabel_3 = new JLabel("Caducidad:");
			lblNewLabel_3.setBounds(12, 136, 74, 16);
			panel.add(lblNewLabel_3);
			
			spnFecha = new JSpinner();
			spnFecha.setModel(new SpinnerDateModel(new Date(1649043054181L), new Date(1649042868084L), null, Calendar.DAY_OF_YEAR));
			spnFecha.setEditor(new JSpinner.DateEditor(spnFecha,"dd/MM/yyyy"));
			spnFecha.setBounds(90, 132, 110, 22);
			panel.add(spnFecha);
			spnFecha.setValue(new Date());
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(RegVacuna.class.getResource("/Imagenes/virus.png")));
			lblNewLabel_4.setBounds(273, 15, 129, 137);
			panel.add(lblNewLabel_4);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(vacuna == null) {
							
							String caducacion = new String(spnFecha.toString());
							vacuna = new Vacuna(txtCodigo.getText(), txtNombre.getText(), Clinica.getInstance().buscarEnfermedad(cbxEnfermedad.getSelectedItem().toString()), caducacion);
							
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
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void clean() {
		txtNombre.setText("");
		txtCodigo.setText("");
		spnFecha.setValue(new Date());
		cbxEnfermedad.setSelectedIndex(0);
		
	}
}
