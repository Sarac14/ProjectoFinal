package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 450, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(12, 13, 56, 16);
			panel.add(lblNewLabel);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(80, 10, 330, 22);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			rbtnTos = new JRadioButton("Tos");
			rbtnTos.setBounds(8, 63, 127, 25);
			panel.add(rbtnTos);
			
			rbtnFiebre = new JRadioButton("Fiebre");
			rbtnFiebre.setBounds(8, 93, 127, 25);
			panel.add(rbtnFiebre);
			
			rbtnNausea = new JRadioButton("Nauseas");
			rbtnNausea.setBounds(8, 123, 127, 25);
			panel.add(rbtnNausea);
			
			rbtnVomito = new JRadioButton("Vomito");
			rbtnVomito.setBounds(8, 153, 127, 25);
			panel.add(rbtnVomito);
			
			rbtnDiarrea = new JRadioButton("Diarrea");
			rbtnDiarrea.setBounds(8, 183, 127, 25);
			panel.add(rbtnDiarrea);
			
			rbtnIctericia = new JRadioButton("Ictericia");
			rbtnIctericia.setBounds(8, 213, 127, 25);
			panel.add(rbtnIctericia);
			
			rbtnFatiga = new JRadioButton("Fatiga");
			rbtnFatiga.setBounds(193, 63, 127, 25);
			panel.add(rbtnFatiga);
			
			rbtnTaquicardia = new JRadioButton("Taquicardia");
			rbtnTaquicardia.setBounds(193, 93, 127, 25);
			panel.add(rbtnTaquicardia);
			
			rbtnIndigestion = new JRadioButton("Indigestion");
			rbtnIndigestion.setBounds(193, 123, 127, 25);
			panel.add(rbtnIndigestion);
			
			rbtnDolorCabeza = new JRadioButton("Dolor de Cabeza");
			rbtnDolorCabeza.setBounds(193, 153, 127, 25);
			panel.add(rbtnDolorCabeza);
			
			rbtnDolorMusculo = new JRadioButton("Dolor Muscular");
			rbtnDolorMusculo.setBounds(193, 183, 127, 25);
			panel.add(rbtnDolorMusculo);
			
			rbtnDolorGastrico = new JRadioButton("Dolor Gastrico");
			rbtnDolorGastrico.setBounds(193, 213, 127, 25);
			panel.add(rbtnDolorGastrico);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
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
}
