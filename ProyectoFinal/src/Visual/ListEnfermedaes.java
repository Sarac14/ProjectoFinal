package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Clinica;
import logico.Enfermedad;

import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ListEnfermedaes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel model;
	private static Object row[];
	private Enfermedad selected = null;
	private JButton btnModificar;
	private JButton btnSintomas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListEnfermedaes dialog = new ListEnfermedaes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListEnfermedaes() {
		setTitle("Enfermedades bajo vigilancia");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListEnfermedaes.class.getResource("/Imagenes/seguro-de-salud.png")));
		setBounds(100, 100, 358, 266);
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
					String headers[] = {"Nombre"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							int row = -1;
							row = table.getSelectedRow();
							if(row>-1){
								btnModificar.setEnabled(true);
								btnSintomas.setEnabled(true);
								selected = Clinica.getInstance().buscarEnfermedad(table.getValueAt(row, 0).toString());
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
				btnSintomas = new JButton("S\u00EDntomas");
				btnSintomas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListSintomas sintomas = new ListSintomas(selected);
						sintomas.setModal(true);
						sintomas.setVisible(true);
					}
				});
				btnSintomas.setEnabled(false);
				buttonPane.add(btnSintomas);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						RegEnfermedad modEnf = new RegEnfermedad(selected);
						modEnf.setModal(true);
						modEnf.setVisible(true);
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				JButton cancelButton = new JButton("Ok");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			loadTable();
		}
	}

	public static void loadTable() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < Clinica.getInstance().getMiEnfermedades().size(); i++) {
			row[0] = Clinica.getInstance().getMiEnfermedades().get(i).getEnfermedadNombre();
			model.addRow(row);
		}
	}
}
