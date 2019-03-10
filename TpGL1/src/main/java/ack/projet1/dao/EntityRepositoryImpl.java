package ack.projet1.dao;



import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public abstract  class EntityRepositoryImpl<T> implements EntityRepository<T>
{
	
	//Class<T> maClass   ;
	
	@Autowired
	private SessionFactory sessionFactory ;
	
	

	public T add(T t)
	{
		Session session ;
		try
		{
			session = sessionFactory.getCurrentSession() ;
		}
		catch(Exception e) { session = sessionFactory.openSession() ; }
		
		t = (T) session.save(t) ;
		
		
		return t;
	}

	public void delete(Long id)
	{
		Session session ;
		try
		{
			session = sessionFactory.getCurrentSession() ;
		}
		catch(Exception e) { session = sessionFactory.openSession() ; }
		
		session.delete(get(id)) ;
		

		session.close();
		sessionFactory.close() ;
	}

	public T update(T t)
	{
		Session session ;
		
		try
		{
			session = sessionFactory.getCurrentSession() ;
		}
		catch(Exception e) { session = sessionFactory.openSession() ; }
				
		session.update(t) ;
		

		return t ;
	}
	

	public T get(Long id)
	{
		T objet = null ;
		
		String nomOfClass = this.getClass().getGenericSuperclass().getTypeName().substring(this.getClass().getGenericSuperclass().getTypeName().lastIndexOf("<")+1, this.getClass().getGenericSuperclass().getTypeName().indexOf(">")) ;
		//System.out.println(nomOfClass) ;
		
		
		Session session = null ;
	
		Class maClass = null ;
		
			try 
			{
				maClass = Class.forName(nomOfClass) ;
				session = sessionFactory.getCurrentSession() ;
					
			} 
			catch (Exception e)
			{
				session = sessionFactory.openSession()  ;
				e.printStackTrace();
			} 
		
		
		
		//System.out.println(maClass.getName());
			
		objet = (T) session.find(maClass, id) ;
		

		
		if(objet==null)
			throw new RuntimeException("Object with this ID could NOT FOUNED !") ;
						
		
		
		return objet ;
	}

	
	
	

	
}

