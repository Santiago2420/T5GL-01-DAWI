package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {

	// eliminar un usuario pero obteniendo su información según el código
	public static void main(String[] args) {
		// conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		// obj de usuario a eliminar
		Usuario u = em.find(Usuario.class, 20);

		if (u == null) {
			System.out.println("Usuario no encontrado");
		} else {
			// proceso --> eliminar por codigo
			em.getTransaction().begin();
			em.remove(u); // busca --> solo lo elimina si encuentra el objeto!!
			System.out.println("usuario eliminado");
			em.getTransaction().commit();
		}
		em.close();
	}
}
