package ack.projet1.test ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ack.projet1.dao.CategorieRepository;
import ack.projet1.dao.ClientRepository;
import ack.projet1.dao.CommandeRepository;
import ack.projet1.dao.ProduitRepository;
import ack.projet1.entities.Client;
import ack.projet1.entities.IPanier;
import ack.projet1.entities.Panier;
import ack.projet1.entities.Produit;
import ack.projet1.service.StoreService;
import container.AppConfig;


public class Test
{
	
	public static void main(String[] args)
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class) ; 
		
		
		//IPanier panier = context.getBean(IPanier.class) ;
		
		
		ClientRepository clientRepository = context.getBean(ClientRepository.class) ;
		CommandeRepository commandeRepository = context.getBean(CommandeRepository.class) ;
		CategorieRepository categorieRepository = context.getBean(CategorieRepository.class) ;
		ProduitRepository produitRepository = context.getBean(ProduitRepository.class) ;
		
		StoreService storeService = context.getBean(StoreService.class) ;
		
		
		/*
		for (int i=1;i<10;i++)
		{
			clientRepository.add(new Client("client"+i, "email "+i,"tele "+i)) ;
			
	
			double prix = Math.random()*100 ;
			produitRepository.add(new Produit(prix, "produit "+i)) ;
			
			
			categorieRepository.add(new Categorie("categorie "+i)) ;
			
		}
		
		*/
		
		
		
		IPanier panierProxy =   (IPanier) context.getBean("panierProxy") ;
		
		Panier panier = (Panier) context.getBean("panier") ;
		
		Produit produit1 = produitRepository.get(1L) ;
		panierProxy.addItem(produit1, 17);
		
		Produit produit2 = produitRepository.get(2L) ;
		panierProxy.addItem(produit2, 2);
		
		Produit produit3 = produitRepository.get(3L) ;
		panierProxy.addItem(produit3,10);
		
		double totalPrix = storeService.getTotalPrix() ;
		System.out.println("Total to pay :"+totalPrix);
		
		Client client = clientRepository.get(1L) ;
		storeService.saveCommande(panier, client );
			
	}

}
