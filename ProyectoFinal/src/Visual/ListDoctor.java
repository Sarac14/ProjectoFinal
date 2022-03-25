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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class ListDoctor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];

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
		setBounds(100, 100, 744, 442);
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
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String headers[] = {"Nombre","Cedula","Telefono","Direccion","Especialidad"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
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
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		loadTable();
	}

	private void loadTable() {

		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < Clinica.getInstance().getMisDoctores().size(); i++) {
			row[0] = Clinica.getInstance().getMisDoctores().get(i).getNombre();
			row[1] = Clinica.getInstance().getMisDoctores().get(i).getCedula();
			row[2] = Clinica.getInstance().getMisDoctores().get(i).getTelefono();
			row[3] = Clinica.getInstance().getMisDoctores().get(i).getDireccion();
			row[4] = Clinica.getInstance().getMisDoctores().get(i).getEspecialidad();
			model.addRow(row);
		}
	}
}

