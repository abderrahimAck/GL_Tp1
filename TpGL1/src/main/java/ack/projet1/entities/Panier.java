package ack.projet1.entities;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Panier implements IPanier
{
	
	private Map<Long,LigneCommande> items = new HashMap<Long,LigneCommande>() ;
	
	
	
	
	public void addItem(Produit produit, int qte)
	{
		
		LigneCommande ligneCommande ;
		
		
		if(!items.isEmpty() && items.containsKey(produit.getId()))
		{
		   ligneCommande = items.get(produit.getId()) ;
		   ligneCommande.setQuantity(ligneCommande.getQuantity()+qte) ;
		   
		}
		
		else
		{
			ligneCommande = new LigneCommande() ;
			ligneCommande.setId(produit.getId()) ;
			ligneCommande.setQuantity(qte) ;
			ligneCommande.setProduit(produit);
			
		}
		
		items.put(produit.getId(),ligneCommande) ;
			
	}

	public void removeItem(Long id)
	{
		if(items.containsKey(id))
		{
			items.remove(items.get(id)) ;
			
		}

	}

	public Map<Long, LigneCommande> getItems()
	{
		return items;
	}

	public void setItems(Map<Long, LigneCommande> items)
	{
		this.items = items;
	}
	
	
	
}
