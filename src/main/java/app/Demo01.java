package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	// registrar los datos de un nuevo usuario
	public static void main(String[] args) {
		// establecer conexión --> con la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// crea el manejador de entidades 
		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> reg, act, eli --> transacciones
		em.getTransaction().begin();
		
		// obj a grabar
		// Usuario u = new Usuario(10, "Juan", "Perez", "jperez", "123", "2000/10/05", 1, 1);
		Usuario u = new Usuario(20, "Maria", "Cruz", "mcruz", "555", "2001/08/15", 1, 1, null);
		em.persist(u);  // insert!!!
		
		System.out.println("Grabación Ok");
		
		// confirmar la transacción
		em.getTransaction().commit();
		
		// cerrar la conexión
		em.close();
	}
}
