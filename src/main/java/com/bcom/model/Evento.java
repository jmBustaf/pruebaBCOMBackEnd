package com.bcom.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="Usuario", nullable=false)
    private Usuario usuario;
	
	@Column
	private String nombre;
	
	@Column
	private Date fecha;
	
	@Column
	private String descripcion;
	
	@Column
	private Date fecha_creacion = new Date();
	
	@Column 
	private Date fecha_edicion = new Date();
	
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Asistencia> asistencias;
	
	public Evento() {
		
	}
	
	public Evento(Usuario usuario, String nombre, Date fecha, String descripcion, Date fecha_creacion, Date fecha_edicion) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
		this.fecha_edicion = fecha_edicion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_edicion() {
		return fecha_edicion;
	}

	public void setFecha_edicion(Date fecha_edicion) {
		this.fecha_edicion = fecha_edicion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", usuario=" + usuario + ", nombre=" + nombre + ", fecha=" + fecha
				+ ", descripcion=" + descripcion + ", fecha_creacion=" + fecha_creacion + ", fecha_edicion="
				+ fecha_edicion + "]";
	}
}
