package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

	// obtener la info de un usuario según su código
	public static void main(String[] args) {
		// conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		// proceso --> consulta --> select * from tb_xx where xxx -> obj de usuario
		Usuario u = em.find(Usuario.class, 20);
		
		if (u == null) {
			System.out.println("Usuario no encontrado");
		} else {
			System.out.println("Usuario encontrado");
			System.out.println(u);
		}
		
		em.close();
	}
}
