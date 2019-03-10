package ack.projet1.aspects;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import ack.projet1.entities.Produit;


@Component
public class LogAfter implements AfterReturningAdvice
{
	private Logger logger = Logger.getLogger("myLogger") ;

	public void afterReturning(Object returnedValue, Method method, Object[] args, Object target) throws Throwable
	{
		Produit produit = (Produit) args[0] ;
		
		String message = "Method Name : "+method.getName()+" ----- Id Of Added product is :"+produit.getId() ;
		
		logger.info(message) ;
		
	}

	

}
