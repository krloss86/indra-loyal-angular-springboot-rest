package ar.com.loyalindra.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "numero_telefono", length = 15)
    private String numeroTelefono;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cliente_equipos",
    	joinColumns = @JoinColumn(name="cliente_id"),
    	inverseJoinColumns = @JoinColumn(name="equipo_id")
	) 
    private Set<Equipo> clienteEquipos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cliente_promocion",
    	joinColumns = @JoinColumn(name="cliente_id"),
    	inverseJoinColumns = @JoinColumn(name="promocion_id")
	)
    private Set<Promocion> clientePromocion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cliente_saldos",
    	joinColumns = @JoinColumn(name="cliente_id"),
    	inverseJoinColumns = @JoinColumn(name="saldo_id")
	)
    private Set<Saldo> clienteSaldos;

    public Cliente() {
        // Default constructor
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Set<Equipo> getClienteEquipos() {
		return clienteEquipos;
	}

	public Set<Promocion> getClientePromocion() {
		return clientePromocion;
	}

	public Set<Saldo> getClienteSaldos() {
		return clienteSaldos;
	}

}

