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
		setTitle("Agregar Vacuna");
		setBounds(100, 100, 450, 251);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Nombre: ");
			lblNewLabel.setBounds(12, 13, 56, 16);
			panel.add(lblNewLabel);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(80, 10, 330, 22);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Codigo");
			lblNewLabel_1.setBounds(12, 52, 56, 16);
			panel.add(lblNewLabel_1);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(80, 49, 330, 22);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Enfermedad:");
			lblNewLabel_2.setBounds(12, 87, 74, 16);
			panel.add(lblNewLabel_2);
			
			cbxEnfermedad = new JComboBox();
			cbxEnfermedad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
			for(int i=0;i<Clinica.getInstance().getMiEnfermedades().size();i++) {
				cbxEnfermedad.addItem(Clinica.getInstance().getMiEnfermedades().get(i).getEnfermedadNombre());
			}
			cbxEnfermedad.setBounds(98, 84, 312, 22);
			panel.add(cbxEnfermedad);
			
			JLabel lblNewLabel_3 = new JLabel("Caducidad:");
			lblNewLabel_3.setBounds(12, 126, 74, 16);
			panel.add(lblNewLabel_3);
			
			spnFecha = new JSpinner();
			spnFecha.setModel(new SpinnerDateModel(new Date(1648526400000L), new Date(1648526400000L), null, Calendar.DAY_OF_YEAR));
			spnFecha.setBounds(98, 119, 110, 22);
			panel.add(spnFecha);
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
							
							SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
							String spinnerValue = formater.format(spnFecha.getValue());
							String fechaString = spinnerValue.toString(); 
							vacuna = new Vacuna(txtCodigo.getText(), txtNombre.getText(), Clinica.getInstance().buscarEnfermedad(cbxEnfermedad.getSelectedItem().toString()), fechaString);
							
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
