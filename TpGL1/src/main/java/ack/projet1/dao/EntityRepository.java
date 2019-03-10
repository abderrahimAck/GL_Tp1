package ack.projet1.dao;

public interface EntityRepository<T> 
{
	T add(T t) ;
	void delete(Long id) ;
	T update(T t) ;
	T get(Long id) ;
}
