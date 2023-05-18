package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="partecipazione")
public class Partecipazione {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(cascade =  CascadeType.ALL )
	private Persona persona;
	
	@ManyToOne(cascade =  {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH} )
	private Evento evento;
	
	private StatoEvento stato;

	public Partecipazione(Persona persona, Evento evento, StatoEvento stato) {
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}

	public Partecipazione() {
		super();
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public StatoEvento getStato() {
		return stato;
	}

	public void setStato(StatoEvento stato) {
		this.stato = stato;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", persona=" + persona + ", evento=" + evento + ", stato=" + stato + "]";
	}
	
	
}
