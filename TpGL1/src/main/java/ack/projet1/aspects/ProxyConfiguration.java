package ack.projet1.aspects;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ack.projet1.entities.IPanier;


@Configuration
public class ProxyConfiguration 
{
	
	@Autowired
	private IPanier panier ;
	
	@Autowired
	private LogAfter logAfter ;
	
	
	@Bean(name="panierProxy")
	public ProxyFactoryBean getProxyBean()
	{
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean() ;
		
		
		proxyFactoryBean.setTarget(panier) ;
		
		proxyFactoryBean.setInterceptorNames("logAfter");
		
		
		try
		{
			Class<?>[] proxyInterfaces = {IPanier.class} ;
			
			proxyFactoryBean.setProxyInterfaces(proxyInterfaces) ;
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		return proxyFactoryBean ;
	}
	
	
	
	
	

}
