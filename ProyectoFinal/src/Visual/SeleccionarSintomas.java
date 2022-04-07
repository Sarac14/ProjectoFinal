package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import logico.Clinica;
import logico.Enfermedad;

public class SeleccionarSintomas extends JDialog {

	private final JPanel contentPanel = new JPanel();
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
			SeleccionarSintomas dialog = new SeleccionarSintomas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SeleccionarSintomas() {
			setIconImage(Toolkit.getDefaultToolkit().getImage(RegEnfermedad.class.getResource("/Imagenes/seguro-de-salud.png")));
			setTitle("Registro de enfermedad");
			setBounds(100, 100, 450, 332);
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
				
				rbtnTos = new JRadioButton("Tos");
				rbtnTos.setFont(new Font("Tahoma", Font.PLAIN, 13));
				rbtnTos.setBounds(8, 36, 127, 25);
				panel.add(rbtnTos);
				
				rbtnFiebre = new JRadioButton("Fiebre");
				rbtnFiebre.setFont(new Font("Tahoma", Font.PLAIN, 13));
				rbtnFiebre.setBounds(8, 66, 127, 25);
				panel.add(rbtnFiebre);
				
				rbtnNausea = new JRadioButton("Nauseas");
				rbtnNausea.setFont(new Font("Tahoma", Font.PLAIN, 13));
				rbtnNausea.setBounds(8, 96, 127, 25);
				panel.add(rbtnNausea);
				
				rbtnVomito = new JRadioButton("Vomito");
				rbtnVomito.setFont(new Font("Tahoma", Font.PLAIN, 13));
				rbtnVomito.setBounds(8, 126, 127, 25);
				panel.add(rbtnVomito);
				
				rbtnDiarrea = new JRadioButton("Diarrea");
				rbtnDiarrea.setFont(new Font("Tahoma", Font.PLAIN, 13));
				rbtnDiarrea.setBounds(8, 156, 127, 25);
				panel.add(rbtnDiarrea);
				
				rbtnIctericia = new JRadioButton("Ictericia");
				rbtnIctericia.setFont(new Font("Tahoma", Font.PLAIN, 13));
				rbtnIctericia.setBounds(8, 186, 127, 25);
				panel.add(rbtnIctericia);
				
				rbtnFatiga = new JRadioButton("Fatiga");
				rbtnFatiga.setFont(new Font("Tahoma", Font.PLAIN, 13));
				rbtnFatiga.setBounds(193, 36, 127, 25);
				panel.add(rbtnFatiga);
				
				rbtnTaquicardia = new JRadioButton("Taquicardia");
				rbtnTaquicardia.setFont(new Font("Tahoma", Font.PLAIN, 13));
				rbtnTaquicardia.setBounds(193, 66, 127, 25);
				panel.add(rbtnTaquicardia);
				
				rbtnIndigestion = new JRadioButton("Indigestion");
				rbtnIndigestion.setFont(new Font("Tahoma", Font.PLAIN, 13));
				rbtnIndigestion.setBounds(193, 96, 127, 25);
				panel.add(rbtnIndigestion);
				
				rbtnDolorCabeza = new JRadioButton("Dolor de Cabeza");
				rbtnDolorCabeza.setFont(new Font("Tahoma", Font.PLAIN, 13));
				rbtnDolorCabeza.setBounds(193, 126, 127, 25);
				panel.add(rbtnDolorCabeza);
				
				rbtnDolorMusculo = new JRadioButton("Dolor Muscular");
				rbtnDolorMusculo.setFont(new Font("Tahoma", Font.PLAIN, 13));
				rbtnDolorMusculo.setBounds(193, 156, 127, 25);
				panel.add(rbtnDolorMusculo);
				
				rbtnDolorGastrico = new JRadioButton("Dolor Gastrico");
				rbtnDolorGastrico.setFont(new Font("Tahoma", Font.PLAIN, 13));
				rbtnDolorGastrico.setBounds(193, 186, 127, 25);
				panel.add(rbtnDolorGastrico);
				
				JLabel lblNewLabel_1 = new JLabel("Seleccione s\u00EDntomas:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_1.setBounds(12, 13, 273, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBorder(UIManager.getBorder("Button.border"));
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					okButton = new JButton("Seleccionar");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						
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
							Clinica.getInstance().setSintomasPaciente(sintomas);
							dispose();
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
