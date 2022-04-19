package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.border.TitledBorder;
import logico.Clinica;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class Principal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FondoPanel fondoPanel = new FondoPanel();
	private Dimension dim;
	private JPanel contentPane;
	private JTextField txtDoctorLogin;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream clinica2;
				ObjectOutputStream clinicaWrite;
				try {
					clinica2 = new  FileOutputStream("clinica.dat");
					clinicaWrite = new ObjectOutputStream(clinica2);
					clinicaWrite.writeObject(Clinica.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Imagenes/seguro-de-salud.png")));
		setTitle("Cl\u00EDnica Salud");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 525);
		dim = getToolkit().getScreenSize();
		setSize(dim.width - 400, dim.height - 200);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuCitas = new JMenu("Citas");
		menuBar.add(menuCitas);
		
		JMenuItem btnAgCita = new JMenuItem("Registrar cita");
		btnAgCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegCita reg = new RegCita();
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		menuCitas.add(btnAgCita);
		
		JMenuItem btnListCita = new JMenuItem("Listado de citas");
		btnListCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListCita listaDeCitas = new ListCita();
				listaDeCitas.setModal(true);
				listaDeCitas.setVisible(true);
			}
		});
		menuCitas.add(btnListCita);
		
		JMenu menuPacientes = new JMenu("Pacientes");
		menuBar.add(menuPacientes);
		
		JMenuItem btnLisPacientes = new JMenuItem("Listado de Pacientes");
		btnLisPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListPaciente lpaciente = new ListPaciente();
				lpaciente.setModal(true);
				lpaciente.setVisible(true);
			}
		});
		menuPacientes.add(btnLisPacientes);
		
		JMenu menuDoctores = new JMenu("Doctores");
		if(!Clinica.getLoginDoctor().getNombre().equalsIgnoreCase("admin")) {
			menuDoctores.setEnabled(false);
		}
		menuBar.add(menuDoctores);
		
		JMenuItem btnListDoctores = new JMenuItem("Listado de Doctores");
		btnListDoctores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListDoctor listaDoctor = new ListDoctor();
				listaDoctor.setModal(true);
				listaDoctor.setVisible(true);
			}
		});
		menuDoctores.add(btnListDoctores);
		
		JMenuItem btnAgDoctores = new JMenuItem("Agregar Doctor");
		btnAgDoctores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegDoctor nuevo = new RegDoctor(null);
				nuevo.setModal(true);
				nuevo.setVisible(true);
			}
		});
		menuDoctores.add(btnAgDoctores);
		
		JMenu menuVacunas = new JMenu("Vacunas");
		menuBar.add(menuVacunas);
		
		JMenuItem btnListVacunas = new JMenuItem("Listado de Vacunas");
		btnListVacunas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListVacunas nuevoListVacunas = new ListVacunas();
				nuevoListVacunas.setModal(true);
				nuevoListVacunas.setVisible(true);
			}
		});
		menuVacunas.add(btnListVacunas);
		
		JMenuItem btnAgVacuna = new JMenuItem("Agregar Vacuna");
		if(!Clinica.getLoginDoctor().getNombre().equalsIgnoreCase("admin")) {
			btnAgVacuna.setEnabled(false);
		}
		btnAgVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegVacuna nueva = new RegVacuna();
				nueva.setModal(true);
				nueva.setVisible(true);
			}
		});
		menuVacunas.add(btnAgVacuna);
		
		JMenu menuEnfermedades = new JMenu("Enfermedades");
		menuBar.add(menuEnfermedades);
		
		JMenuItem btnVigilancia = new JMenuItem("Enfermedades bajo vigilancia");
		btnVigilancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListEnfermedaes listaEnf = new ListEnfermedaes();
				listaEnf.setModal(true);
				listaEnf.setVisible(true);
			}
		});
		menuEnfermedades.add(btnVigilancia);
		
		JMenuItem btnAgEnfermedades = new JMenuItem("Agregar Enfermedad");
		if(!Clinica.getLoginDoctor().getNombre().equalsIgnoreCase("admin")) {
			btnAgEnfermedades.setEnabled(false);
		}
		btnAgEnfermedades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEnfermedad aux = new RegEnfermedad(null);
				aux.setModal(true);
				aux.setVisible(true);
			}
		});
		menuEnfermedades.add(btnAgEnfermedades);
		
		JMenu menuConsultas = new JMenu("Consulta");
		menuBar.add(menuConsultas);
		
		JMenuItem btnAgConsulta = new JMenuItem("Registrar consulta");
		btnAgConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegConsulta consulta = new RegConsulta();
				consulta.setModal(true);
				consulta.setVisible(true);
			}
		});
		menuConsultas.add(btnAgConsulta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtDoctorLogin = new JTextField();
		txtDoctorLogin.setText(Clinica.getLoginDoctor().getNombre());
		txtDoctorLogin.setBounds(1320, 13, 146, 22);
		panel.add(txtDoctorLogin);
		txtDoctorLogin.setColumns(10);
		
		this.setContentPane(fondoPanel);
	}
	
	class FondoPanel extends JPanel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image imagen;
		
		@Override
		public void paint(Graphics g)
		{
			imagen = new ImageIcon(getClass().getResource("/Imagenes/Clinica Salud Transparente.png")).getImage();
			
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			
			setOpaque(false);
			
			super.paint(g);
		}
	}
}
