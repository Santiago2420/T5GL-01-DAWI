package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_productos")
@Data
public class Producto {
	@Id
	private String id_prod;
	private String des_prod; 
	private int stk_prod;
	private double pre_prod;
	private int idcategoria;
	private int est_prod; // True .1 / false .0
	private int idprovedor;
	
	
	@ManyToOne
	@JoinColumn(name = "idprovedor", insertable = false,updatable = false)
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "idcategoria", insertable = false,updatable = false)
	private Categoria categoria;

	
}
