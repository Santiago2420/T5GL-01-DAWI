package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLogueo extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogueo frame = new FrmLogueo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogueo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(24, 31, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(91, 28, 159, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(24, 59, 46, 14);
		contentPane.add(lblClave);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(91, 59, 159, 20);
		contentPane.add(txtClave);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					ingresar();
				
			}
		});
		btnIngresar.setBounds(300, 27, 89, 23);
		contentPane.add(btnIngresar);
	}
	void ingresar() {
		// leer los campos
		String usuario = leerUsuario();
		String clave = leerClave();
		// Obtener un Usuario según los campos de Usuario y Clave
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		Usuario u;
		try {
			TypedQuery<Usuario> consulta = em.createQuery("select u from Usuario u where u.usuario = :xusr and u.clave = :xpas", Usuario.class);
			consulta.setParameter("xusr", usuario);
			consulta.setParameter("xpas", clave);
			u = consulta.getSingleResult(); //En caso de no encontrar un resultado lanza un excepcion
			aviso("Bienvenido", "Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			u = null;
			aviso("Usuario no existe", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
			
		}
	}
		void aviso(String msg, String tit, int icono) {
			JOptionPane.showMessageDialog(this, msg, tit, icono);
		
	}

	private String leerClave() {
		return String.valueOf(txtClave.getPassword());
	}
	private String leerUsuario() {
		return txtUsuario.getText();
	}
	}

