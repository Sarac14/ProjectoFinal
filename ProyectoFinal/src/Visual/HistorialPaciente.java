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

import logico.Clinica;
import logico.Consulta;
import logico.HistorialClinico;
import logico.Paciente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private Consulta selected = null;
	private JButton btnModificar;
	
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
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							int row = -1;
							row = table.getSelectedRow();
							if(row>-1){
								if(!Clinica.getLoginDoctor().getNombre().equalsIgnoreCase("admin")) {
									btnModificar.setEnabled(false);
								}else {
									btnModificar.setEnabled(true);
								}
								selected = Clinica.getInstance().buscarConsulta(table.getValueAt(row, 0).toString());
							}
						}
					});
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
				btnModificar = new JButton("Modificar");
				btnModificar.setEnabled(false);
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ModificarConsulta aux = new ModificarConsulta(selected);
						aux.setModal(true);
						aux.setVisible(true);
					}
				});
				buttonPane.add(btnModificar);
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
