package ack.projet1.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Produit
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private double prix ;
	private String description ;
	
	@OneToMany(mappedBy="produit")
	private Collection<LigneCommande> ligneCommandes ;
	
	@ManyToOne
	private Categorie categorie ;
	
	 
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public double getPrix()
	{
		return prix;
	}
	public void setPrix(double prix)
	{
		this.prix = prix;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}

	public Categorie getCategorie()
	{
		return categorie;
	}
	public void setCategorie(Categorie categorie)
	{
		this.categorie = categorie;
	}
	public Collection<LigneCommande> getLigneCommandes()
	{
		return ligneCommandes;
	}
	public void setLigneCommandes(Collection<LigneCommande> ligneCommandes)
	{
		this.ligneCommandes = ligneCommandes;
	}
	public Produit(double prix, String description)
	{
		super();
		this.prix = prix;
		this.description = description;
	}
	public Produit()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
