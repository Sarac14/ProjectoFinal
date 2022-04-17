package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Clinica;
import logico.Doctor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListDoctor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];
	private Doctor selected = null;
	private JButton btnModificar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListDoctor dialog = new ListDoctor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListDoctor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListDoctor.class.getResource("/Imagenes/seguro-de-salud.png")));
		setTitle("Listado de doctores");
		setBounds(100, 100, 744, 442);
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
					String headers[] = {"Nombre","Cedula","Telefono","Direccion","Especialidad"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							int row = -1;
							row = table.getSelectedRow();
							if(row>-1){
								btnModificar_1.setEnabled(true);
								selected = Clinica.getInstance().buscarDoctor(table.getValueAt(row, 0).toString());
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
				btnModificar_1 = new JButton("Modificar");
				btnModificar_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegDoctor modDoctor = new RegDoctor(selected);
						modDoctor.setModal(true);
						modDoctor.setVisible(true);
						
					}
				});
				btnModificar_1.setEnabled(false);
				btnModificar_1.setActionCommand("OK");
				buttonPane.add(btnModificar_1);
				getRootPane().setDefaultButton(btnModificar_1);
			}
		}
		loadTable();
	}

	private void loadTable() {

		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 1; i < Clinica.getInstance().getMisDoctores().size(); i++) {
			row[0] = Clinica.getInstance().getMisDoctores().get(i).getCedula();
			row[1] = Clinica.getInstance().getMisDoctores().get(i).getNombre();
			row[2] = Clinica.getInstance().getMisDoctores().get(i).getTelefono();
			row[3] = Clinica.getInstance().getMisDoctores().get(i).getDireccion();
			row[4] = Clinica.getInstance().getMisDoctores().get(i).getEspecialidad();
			model.addRow(row);
		}
	}
}

