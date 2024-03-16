package Com.jsp.shoopingcart.dao;


	import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Com.jsp.shoopingcart.dto.Product;


		@Repository
       public class ProductDao {
		@Autowired
		EntityManagerFactory emf;
		public void saveProduct(Product Product) {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			et.begin();
			em.persist(Product);
			et.commit();
		}
		
		public Product login(String email, String password) {
			EntityManager em=emf.createEntityManager();
			Query query=em.createQuery("select m from Product m where m.email=?1 and m.password=?2");
			query.setParameter(1,email);
			query.setParameter(2,password);
			
			Product m=(Product) query.getSingleResult();
			if(m!=null){
				return m;
			}
			else {
				return null;
				
			}
		}
		public void deleteProductById(int id) {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			 Product m=em.find(Product.class, id);
			 et.begin();
			 em.remove(m);
			 et.commit();
			 
		}
		
		public Product findProductBYId(int id) {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			Product m=em.find(Product.class, id);
			
			if(m!=null) {
				return m;
				
			}
			else {
				return null;
			}
		}
		
		public Product findProductById(int id) {
			EntityManager em=emf.createEntityManager();
			 Product p=em.find(Product.class, id);
			 if(p!=null) {
				 return p;
				 
			 }
			 else {
				return null;
			 }
		}
		public List<Product> fetchAllProducts(){
			EntityManager em=emf.createEntityManager();
			Query query=em.createQuery("select p from Product p");
			return query.getResultList();
		}
		
		public List<Product>findProductByBrand(String brand){
			EntityManager em=emf.createEntityManager();
			Query query =em.createQuery("select p from Product p where p.brand=?1");
			query.setParameter(1, brand);
			return query.getResultList();
		}
		
		public List<Product>findProductByCategory(String Category){
			EntityManager em=emf.createEntityManager();
			Query query=em.createQuery("select c from Product c where c.Category=?1");
			query.setParameter(1, Category);
			return query.getResultList();
			
		}
		public List<Product>findProductByCost(long Price){
			EntityManager em=emf.createEntityManager();
			Query query=em.createQuery("select c from Product c where c.Price=?1");
			query.setParameter(1, Price);
			return null;
			
		}

		public void updateProduct(Product p) {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			et.begin();
			em.merge(p);
			et.commit();
			
		}


}



