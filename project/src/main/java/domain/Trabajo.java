package domain;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.*;

@Entity
public class Trabajo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String trabajo_id;
	private String titulo;
	private String grupo;
	
	@OneToMany(mappedBy="trabajo")
	private List<Pregunta> preguntas = new ArrayList<Pregunta>();

	public Trabajo(){
		super();
	}

	public Trabajo (String trabajo_id,String titulo, String grupo){
		super();
		this.trabajo_id=trabajo_id;
		this.titulo=titulo;
		this.grupo=grupo;
	}

	public String getTrabajoID(){
		return trabajo_id;
	}

	public void setTrabajoID(String trabajo_id){
		this.trabajo_id=trabajo_id;
	}

	public String getTitulo(){
		return titulo;
	}

	public void setTitulo(String titulo){
		this.titulo=titulo;
	}

	public String getGrupo(){
		return grupo;
	}

	public void setGrupo(String grupo){
		this.grupo=grupo;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}


}