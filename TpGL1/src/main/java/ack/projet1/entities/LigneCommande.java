package ack.projet1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande
{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
	private int quantity;
	
	@ManyToOne
	private Commande commande;
	@ManyToOne
	private Produit produit;
	
	

	public Long getId()
	{
		return id;
	}


	public void setId(Long id)
	{
		this.id = id;
	}


	public int getQuantity()
	{
		return quantity;
	}


	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}


	public Commande getCommande()
	{
		return commande;
	}


	public void setCommande(Commande commande)
	{
		this.commande = commande;
	}


	public Produit getProduit()
	{
		return produit;
	}


	public void setProduit(Produit produit)
	{
		this.produit = produit;
	}

	
	
	
	
	
	    

}
