package controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Evento;
import model.Location;
import model.Partecipazione;
import model.Persona;
import model.SessoPersona;
import model.StatoEvento;
import model.TipoEvento;



public class MainProject {
	
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("day2JPA");
	static EntityManager em=emf.createEntityManager();

	public static void main(String[] args) {
		
		try {
			
			//inserisciEvento(new Evento("Serata Gala",LocalDate.of(2023, 12, 25),"Natale con i Lakers",TipoEvento.PUBBLICO,20));
		//Evento e=(cercaEvento(2));
		//e.setDescrizione("Concerto di Travis Scott");
		//modificaEvento(e);
			
			
		//System.out.println(e);
		//statoPrecedenteEvento(e);
		//System.out.println(e);
		//inserisciPersona(new Persona("Martina", "Bianchi", "m.bianchi@icloud.com", LocalDate.of(1990,10,28), SessoPersona.Femmina));
		//cancellaPersona(new Persona("Hansel", "Adjei", "h.adjei@icloud.com", LocalDate.of(2003,10,18), SessoPersona.Maschio));
		//System.out.println(cercaPersona(1));	
		//Persona Hansel=(cercaPersona(1));
		//Location l=new Location("Old Fashion", "Milano");
		//inserisciLocation(l);
		Location l=(cercaLocation(1));
		Evento e= new Evento("Mambo disco", LocalDate.of(2023,06,18), "Serata con Mambolosco", TipoEvento.PUBBLICO, 100, l);
		//inserisciEvento(e);
		Persona h=(cercaPersona(1));
		h.addEventoPartecipazione(new Partecipazione(h,e,StatoEvento.CONFERMATA));
		//Hansel.addEventoPartecipazione(new Partecipazione(Hansel, null, StatoEvento.DA_CONFERMARE));
		
		}catch(Exception e) {
			System.out.println("ERRORE! "+e);
		}finally {
			emf.close();
			em.close();
		}
		
		
	}
	
	
	
	
	public static void inserisciEvento(Evento e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("L'evento: "+e.getTitolo()+" è stato salvato nel Database");
	}
	
	public static void inserisciPersona(Persona p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("La persona: "+p.getNome()+" è stato salvato nel Database");
	}
	
	public static void inserisciLocation(Location l) {
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		System.out.println("La location: "+l.getNome()+" è stato salvato nel Database");
	}
	
	
	public static Evento cercaEvento(long i) {
		em.getTransaction().begin();
		Evento s=em.find(Evento.class, i);
		em.getTransaction().commit();
		return s;
	}
	
	public static Persona cercaPersona(long i) {
		em.getTransaction().begin();
		Persona p=em.find(Persona.class, i);
		em.getTransaction().commit();
		return p;
	}
	
	public static Location cercaLocation(long i) {
		em.getTransaction().begin();
		Location l=em.find(Location.class, i);
		em.getTransaction().commit();
		return l;
	}
	
	
	public static void cancellaEvento(Evento e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("L'evento: "+e.getTitolo()+" è rimosso dal Database");
	}
	
	public static void cancellaPersona(Persona p) {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("la persona: "+p.getNome()+" è rimosso dal Database");
	}
	
	public static void modificaEvento(Evento e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		System.out.println("L'evento: "+e.getTitolo()+" è stato modificato nel Database");
	}
	
	public static void statoPrecedenteEvento(Evento e) {
		em.getTransaction().begin();
		em.refresh(e);
		em.getTransaction().commit();
		System.out.println("L'evento: "+e.getTitolo()+" è ripristinato allo stato precedente nel Database");
	}

}
