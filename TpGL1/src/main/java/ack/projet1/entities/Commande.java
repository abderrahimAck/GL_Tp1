package ack.projet1.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private Date dateCommande ;
	
	@ManyToOne
	private Client client ;
	
	
	@OneToMany(mappedBy="commande")
	private Collection<LigneCommande> ligneCommandes ;


	public Long getId()
	{
		return id;
	}


	public void setId(Long id)
	{
		this.id = id;
	}


	public Date getDateCommande()
	{
		return dateCommande;
	}


	public void setDateCommande(Date dateCommande)
	{
		this.dateCommande = dateCommande;
	}


	public Client getClient()
	{
		return client;
	}


	public void setClient(Client client)
	{
		this.client = client;
	}


	public Collection<LigneCommande> getLigneCommandes()
	{
		return ligneCommandes;
	}


	public void setLigneCommandes(Collection<LigneCommande> ligneCommandes)
	{
		this.ligneCommandes = ligneCommandes;
	}
	
	
	
	
		
	

}
