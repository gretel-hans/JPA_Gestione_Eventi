package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="persona")

public class Persona {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	private String cognome;
	
	private String email;
	
	@Column(name="data_di_nascita")
	private LocalDate dataDiNascita;
	
	@Enumerated(EnumType.STRING)
	private SessoPersona sesso;
	
	@OneToMany
	@Column(name="lista_partecipazioni")
	private List<Partecipazione> listaPartecipazioni;
	
	
	
	
	
	public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, SessoPersona sesso) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
	}
	
	

	public Persona() {
		super();
	}


	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}



	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}



	public SessoPersona getSesso() {
		return sesso;
	}



	public void setSesso(SessoPersona sesso) {
		this.sesso = sesso;
	}



	public long getId() {
		return id;
	}



	public void addEventoPartecipazione(Partecipazione p) {
		listaPartecipazioni.add(p);
	}
	
	public List<Partecipazione> getListaPartecipazioni() {
		return listaPartecipazioni;
	}



	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", dataDiNascita="
				+ dataDiNascita + ", sesso=" + sesso + ", numeroPartecipazioni=" + listaPartecipazioni.size() + "]";
	}
	
	

}