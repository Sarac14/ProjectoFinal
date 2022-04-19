package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

import logico.Clinica;
import logico.Enfermedad;

public class ListSintomas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Enfermedad laEnfermedad = null;
	private JList<String> listSintomas;
	
	private DefaultListModel<String> modelSintomas = new DefaultListModel<String>();


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ListSintomas dialog = new ListSintomas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ListSintomas(Enfermedad enf) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListSintomas.class.getResource("/Imagenes/seguro-de-salud.png")));
		laEnfermedad = enf;
		setTitle("Listado de Sintomas");
		setBounds(100, 100, 292, 332);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			for(int i = 0; i < laEnfermedad.getSintomas().size(); i++) {
				modelSintomas.addElement(laEnfermedad.getSintomas().get(i));
			}
			
			listSintomas = new JList<String>(modelSintomas);
			listSintomas.setBorder(new TitledBorder(null, "S\u00EDntomas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			listSintomas.setBounds(12, 13, 250, 224);
			contentPanel.add(listSintomas);

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Volver");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
