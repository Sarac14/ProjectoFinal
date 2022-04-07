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

public class HistorialPaciente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public HistorialPaciente(Paciente miPaciente) {
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
					String titulos[] = {"Fecha", "Doctor", "Código", "Síntomas", "Diagnóstico"};
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
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadTable(miPaciente);
	}
	
	
	private void loadTable(Paciente miPaciente) {
		
		//ArrayList<HistorialClinico> miPaciente.getMiHistorialClinicos().get(i).getFecha(); = miPaciente.getMiHistorialClinicos();
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
