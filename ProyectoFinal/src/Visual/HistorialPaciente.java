package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.HistorialClinico;
import logico.Paciente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistorialPaciente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];
	private Paciente elPaciente = null; 
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public HistorialPaciente(Paciente miPaciente) {
		setTitle("Historial Cl\u00EDnico");
		elPaciente = miPaciente;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListDoctor.class.getResource("/Imagenes/seguro-de-salud.png")));
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String titulos[] = {"Código", "Fecha", "Doctor"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(titulos);
					table = new JTable();
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton = new JButton("Modificar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton cancelButton = new JButton("Volver");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadTable(elPaciente);
	}
	
	
	private void loadTable(Paciente miPaciente) {
		
	
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < miPaciente.getMiHistorialClinicos().size(); i++) {
			row[0] = miPaciente.getMiHistorialClinicos().get(i).getCodigo();
			row[1] = miPaciente.getMiHistorialClinicos().get(i).getFecha();
			row[2] = miPaciente.getMiHistorialClinicos().get(i).getDoctor();
			model.addRow(row);
		}
	}
}
