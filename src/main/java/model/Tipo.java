package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_tipos")
public class Tipo {
	@Id
	private int idTipo; //El atributo de la clase tiene el mismo nombre que los campos de la tabla
	private String descripcion;
}
