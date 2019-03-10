package ack.projet1.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private String nomCategorie ;
	
	
	@OneToMany(mappedBy="categorie")
	private Collection<Produit> produits ;
	
	


	public Long getId()
	{
		return id;
	}


	public void setId(Long id)
	{
		this.id = id;
	}


	public String getNomCategorie()
	{
		return nomCategorie;
	}


	public void setNomCategorie(String nomCategorie)
	{
		this.nomCategorie = nomCategorie;
	}


	public Collection<Produit> getProduits()
	{
		return produits;
	}


	public void setProduits(Collection<Produit> produits)
	{
		this.produits = produits;
	}


	public Categorie(String nomCategorie)
	{
		super();
		this.nomCategorie = nomCategorie;
	}


	public Categorie()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
		

}
