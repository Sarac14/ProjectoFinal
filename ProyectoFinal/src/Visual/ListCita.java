package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cita;
import logico.Clinica;

import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ListCita extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTable  table;
	private static DefaultTableModel model;
	private static Object row[];
	private JButton btnModificar;
	private Cita selected = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListCita dialog = new ListCita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListCita() {
		setTitle("Listado de Citas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListCita.class.getResource("/Imagenes/seguro-de-salud.png")));
		setBounds(100, 100, 700, 399);
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
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String headers[] = {"Código","Cedula","    Nombre    ","Fecha","Hora","Tipo","Doctor"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
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
								selected = Clinica.getInstance().buscarCita(table.getValueAt(row, 0).toString());
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
				JButton okButton = new JButton("Volver");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				{
					btnModificar = new JButton("Modificar");
					if(!Clinica.getLoginDoctor().getNombre().equalsIgnoreCase("admin")) {
						btnModificar.setEnabled(false);
					}
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegCita modCita = new RegCita(selected);
							modCita.setModal(true);
							modCita.setVisible(true);
						}
					});
					btnModificar.setEnabled(false);
					buttonPane.add(btnModificar);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			loadTable();
		}
	}

	public static void loadTable() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < Clinica.getInstance().getMisCitas().size(); i++) {
			row[0] = Clinica.getInstance().getMisCitas().get(i).getCodigo();
			row[1] = Clinica.getInstance().getMisCitas().get(i).getCedula();
			row[2] = Clinica.getInstance().getMisCitas().get(i).getPersona();
			row[3] = Clinica.getInstance().getMisCitas().get(i).getFecha();
			row[4] = Clinica.getInstance().getMisCitas().get(i).getHora();
			row[5] = Clinica.getInstance().getMisCitas().get(i).getTipo();
			row[6] = Clinica.getInstance().getMisCitas().get(i).getDoctor();

			model.addRow(row);

		}
	}

}
