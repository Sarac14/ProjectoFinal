package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Clinica;
import logico.Enfermedad;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.UIManager;

public class RegEnfermedad extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JButton cancelButton;
	private JButton okButton;
	private JRadioButton rbtnDolorGastrico;
	private JRadioButton rbtnTos;
	private JRadioButton rbtnFiebre;
	private JRadioButton rbtnNausea;
	private JRadioButton rbtnDiarrea;
	private JRadioButton rbtnVomito;
	private JRadioButton rbtnIctericia;
	private JRadioButton rbtnFatiga;
	private JRadioButton rbtnTaquicardia;
	private JRadioButton rbtnIndigestion;
	private JRadioButton rbtnDolorCabeza;
	private JRadioButton rbtnDolorMusculo;
	private Enfermedad enfermedad;
	private ArrayList<String>sintomas = new ArrayList<>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEnfermedad dialog = new RegEnfermedad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEnfermedad() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegEnfermedad.class.getResource("/Imagenes/seguro-de-salud.png")));
		setTitle("Registro de enfermedad");
		setBounds(100, 100, 450, 353);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(UIManager.getBorder("CheckBox.border"));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel.setBounds(12, 13, 56, 16);
			panel.add(lblNewLabel);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(80, 10, 288, 22);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			rbtnTos = new JRadioButton("Tos");
			rbtnTos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			rbtnTos.setBounds(8, 63, 127, 25);
			panel.add(rbtnTos);
			
			rbtnFiebre = new JRadioButton("Fiebre");
			rbtnFiebre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			rbtnFiebre.setBounds(8, 93, 127, 25);
			panel.add(rbtnFiebre);
			
			rbtnNausea = new JRadioButton("Nauseas");
			rbtnNausea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			rbtnNausea.setBounds(8, 123, 127, 25);
			panel.add(rbtnNausea);
			
			rbtnVomito = new JRadioButton("Vomito");
			rbtnVomito.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			rbtnVomito.setBounds(8, 153, 127, 25);
			panel.add(rbtnVomito);
			
			rbtnDiarrea = new JRadioButton("Diarrea");
			rbtnDiarrea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			rbtnDiarrea.setBounds(8, 183, 127, 25);
			panel.add(rbtnDiarrea);
			
			rbtnIctericia = new JRadioButton("Ictericia");
			rbtnIctericia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			rbtnIctericia.setBounds(8, 213, 127, 25);
			panel.add(rbtnIctericia);
			
			rbtnFatiga = new JRadioButton("Fatiga");
			rbtnFatiga.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			rbtnFatiga.setBounds(193, 63, 127, 25);
			panel.add(rbtnFatiga);
			
			rbtnTaquicardia = new JRadioButton("Taquicardia");
			rbtnTaquicardia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			rbtnTaquicardia.setBounds(193, 93, 127, 25);
			panel.add(rbtnTaquicardia);
			
			rbtnIndigestion = new JRadioButton("Indigestion");
			rbtnIndigestion.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			rbtnIndigestion.setBounds(193, 123, 127, 25);
			panel.add(rbtnIndigestion);
			
			rbtnDolorCabeza = new JRadioButton("Dolor de Cabeza");
			rbtnDolorCabeza.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			rbtnDolorCabeza.setBounds(193, 153, 127, 25);
			panel.add(rbtnDolorCabeza);
			
			rbtnDolorMusculo = new JRadioButton("Dolor Muscular");
			rbtnDolorMusculo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			rbtnDolorMusculo.setBounds(193, 183, 127, 25);
			panel.add(rbtnDolorMusculo);
			
			rbtnDolorGastrico = new JRadioButton("Dolor Gastrico");
			rbtnDolorGastrico.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			rbtnDolorGastrico.setBounds(193, 213, 127, 25);
			panel.add(rbtnDolorGastrico);
			
			JLabel lblNewLabel_1 = new JLabel("Seleccione s\u00EDntomas:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblNewLabel_1.setBounds(12, 40, 273, 14);
			panel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(UIManager.getBorder("Button.border"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(Clinica.getInstance().buscarEnfermedad(txtNombre.getText()) != null) {
							JOptionPane.showMessageDialog(null, "La enfermedad que intenta registrar ya existe.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}else {
							
							if(rbtnDolorCabeza.isSelected()) {
								sintomas.add("Dolor de Cabeza");
							}
							if(rbtnDiarrea.isSelected()) {
								sintomas.add("Diarrea");
							}
							if(rbtnDolorGastrico.isSelected()) {
								sintomas.add("Dolor Gastrico");
							}
							if(rbtnDolorMusculo.isSelected()) {
								sintomas.add("Dolor Muscular");
							}
							if(rbtnFatiga.isSelected()) {
								sintomas.add("Fatiga");
							}
							if(rbtnFiebre.isSelected()) {
								sintomas.add("Fiebre");
							}
							if(rbtnIctericia.isSelected()) {
								sintomas.add("Ictericia");
							}
							if(rbtnNausea.isSelected()) {
								sintomas.add("Nausea");
							}
							if(rbtnTaquicardia.isSelected()) {
								sintomas.add("Taquicardia");
							}
							if(rbtnTos.isSelected()) {
								sintomas.add("Tos");
							}
							if(rbtnVomito.isSelected()) {
								sintomas.add("Vomito");
							}
							if(rbtnIndigestion.isSelected()) {
								sintomas.add("Indigestion");
							}
							
							enfermedad = new Enfermedad(txtNombre.getText(), sintomas);
							Clinica.getInstance().agregarEnfermedad(enfermedad);
							JOptionPane.showMessageDialog(null, "Operacion exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}
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

	protected void clean() {
		txtNombre.setText("");
		rbtnDiarrea.setSelected(false);
		rbtnDolorCabeza.setSelected(false);
		rbtnDolorGastrico.setSelected(false);
		rbtnDolorMusculo.setSelected(false);
		rbtnFatiga.setSelected(false);
		rbtnFiebre.setSelected(false);
		rbtnIctericia.setSelected(false);
		rbtnIndigestion.setSelected(false);
		rbtnNausea.setSelected(false);
		rbtnTaquicardia.setSelected(false);
		rbtnTos.setSelected(false);
		rbtnVomito.setSelected(false);
		
	}
}
