package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Clinica;
import logico.Paciente;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListPaciente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel model;
	private static Object row[];
	private JButton okButton;
	private JButton btnHistorial;
	private Paciente selected = null;
	private JButton btnModificar;
	private JButton btnVacunas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListPaciente dialog = new ListPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListPaciente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListPaciente.class.getResource("/Imagenes/seguro-de-salud.png")));
		setTitle("Listado de Pacientes");
		setBounds(100, 100, 673, 376);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String headers[] = {"Cédula","Nombre","Teléfono","Dirección","F. Nacimiento","Tipo de Sangre","Estatura","Peso"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							int row = -1;
							row = table.getSelectedRow();
							if(row > -1) {
								btnHistorial.setEnabled(true);
								btnModificar.setEnabled(true);
								btnVacunas.setEnabled(true);
								selected = Clinica.getInstance().buscarPaciente(table.getValueAt(row, 0).toString());
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
			}
			{
				btnHistorial = new JButton("Historial");
				btnHistorial.setEnabled(false);
				btnHistorial.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						HistorialPaciente nuevo = new HistorialPaciente(selected);
						nuevo.setModal(true);
						nuevo.setVisible(true);
					}
				});
				{
					btnModificar = new JButton("Modificar");
					if(!Clinica.getLoginDoctor().getNombre().equalsIgnoreCase("admin")) {
						btnModificar.setEnabled(false);
					}
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							UpdatePaciente newPaciente = new UpdatePaciente(selected);
							newPaciente.setModal(true);
							newPaciente.setVisible(true);
						}
					});
					{
						btnVacunas = new JButton("Vacunas");
						btnVacunas.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								ListVacunasPacientes newListVac = new ListVacunasPacientes(selected);
								newListVac.setModal(true);
								newListVac.setVisible(true);
							}
						});
						btnVacunas.setEnabled(false);
						buttonPane.add(btnVacunas);
					}
					btnModificar.setEnabled(false);
					buttonPane.add(btnModificar);
				}
				buttonPane.add(btnHistorial);
			}
			okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		loadTable();
	}

	public static void loadTable() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < Clinica.getInstance().getMisPacientes().size(); i++) {
			row[0] = Clinica.getInstance().getMisPacientes().get(i).getCedula();
			row[1] = Clinica.getInstance().getMisPacientes().get(i).getNombre();
			row[2] = Clinica.getInstance().getMisPacientes().get(i).getTelefono();
			row[3] = Clinica.getInstance().getMisPacientes().get(i).getDireccion();
			row[4] = Clinica.getInstance().getMisPacientes().get(i).getEdad();
			
			row[5] = Clinica.getClinica().getMisPacientes().get(i).getTipoSangre();
			row[6] = Clinica.getClinica().getMisPacientes().get(i).getEstatura();
			row[7] = Clinica.getClinica().getMisPacientes().get(i).getPeso();


			model.addRow(row);

		}
	}

}
