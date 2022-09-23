package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	// eliminar un usuario
	public static void main(String[] args) {
		// conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		// proceso -> reg, act, eli --> transacciones
		em.getTransaction().begin();
		
		// obj de usuario a eliminar
		Usuario u = new Usuario();
		u.setCodigo(20);
		em.remove(u);  // busca --> solo lo elimina si encuentra el objeto!!
		
		
		System.out.println("usuario eliminado");
		
		em.getTransaction().commit();
		
		em.close();
	}
}
