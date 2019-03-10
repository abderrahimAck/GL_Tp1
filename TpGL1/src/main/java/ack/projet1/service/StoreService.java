package ack.projet1.service;

import ack.projet1.entities.Client;
import ack.projet1.entities.Commande;
import ack.projet1.entities.Panier;

public interface StoreService
{
	double getTotalPrix() ;
	void setCommande(Commande commande) ;
	void saveCommande(Panier panier,Client client) ;
	
	
}
