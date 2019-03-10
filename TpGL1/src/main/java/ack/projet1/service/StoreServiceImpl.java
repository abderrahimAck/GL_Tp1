package ack.projet1.service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ack.projet1.dao.CategorieRepository;
import ack.projet1.dao.CommandeRepository;
import ack.projet1.dao.LigneCommandeRepository;
import ack.projet1.dao.ProduitRepository;
import ack.projet1.entities.Client;
import ack.projet1.entities.Commande;
import ack.projet1.entities.LigneCommande;
import ack.projet1.entities.Panier;

@Service
public class StoreServiceImpl implements StoreService
{
	
	@Autowired
	private Panier panier ;
	
	
	@Autowired
	private CommandeRepository commandeRepository ;
	
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository ;
	
	@Autowired
	private ProduitRepository produitRepository ;
	
	@Autowired
	private CategorieRepository categorieRepository ;
	

	public double getTotalPrix()
	{
		double totalPrix = 0 ;
		
		 Map<Long,LigneCommande> items = panier.getItems() ;
		 
		 Collection<LigneCommande> ligneCommandes = items.values() ;
		 
		 for (LigneCommande ligneCommande : ligneCommandes)
		{
			totalPrix += ligneCommande.getQuantity()*ligneCommande.getProduit().getPrix() ;
		}
		
		return totalPrix ;
	}

	public void setCommande(Commande commande)
	{
		commandeRepository.update(commande) ;
	}

	public void saveCommande(Panier panier, Client client)
	{
		Commande commande = new Commande() ;
				
		Collection<LigneCommande> ligneCommandes = panier.getItems().values() ;
		
		commande.setClient(client) ;
		commande.setDateCommande(new Date()) ;
		
		commandeRepository.add(commande) ;
		
		
		for (LigneCommande ligneCommande : ligneCommandes)
		{
			ligneCommande.setCommande(commande) ;
			ligneCommandeRepository.add(ligneCommande) ;
			
		}
		
		
		
	}

	

}
