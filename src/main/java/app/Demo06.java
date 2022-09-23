package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo06 {

	// listado de todos los usuarios
	public static void main(String[] args) {
		// conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();

		// proceso --> consulta ->                   select * from tb_usuarios
		//                                  JPQL     select var from Entidad var
		List<Usuario> lstUsuarios = em.createQuery("select u from Usuario u", Usuario.class).getResultList();
		
		System.out.println("Listado de Usuarios");
		for (Usuario us : lstUsuarios) {
			System.out.println("Código...:"+ us.getCodigo());
			System.out.println("Nombre...:"+ us.getNombre()+ " " + us.getApellido());
			System.out.println("Tipo...:"+ us.getTipo()+ " - " + us.getObjTipo().getDescripcion());
			System.out.println("---------------------------------");
		}
		
		em.close();
	}
}
