package ack.projet1.entities ;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private String nom ;
	private String email ;
	private String tele ;
	
	@OneToMany(mappedBy="client")
	private Collection<Commande> commandes ; 
	
	

	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getTele()
	{
		return tele;
	}

	public void setTele(String tele)
	{
		this.tele = tele;
	}

	public Collection<Commande> getCommandes()
	{
		return commandes;
	}

	public void setCommandes(Collection<Commande> commandes)
	{
		this.commandes = commandes;
	}

	
	
	
	

	public Client()
	{
		super();
	}

	public Client(String nom, String email, String tele)
	{
		super();
		this.nom = nom;
		this.email = email;
		this.tele = tele;
	}
	
	
	
	

}
