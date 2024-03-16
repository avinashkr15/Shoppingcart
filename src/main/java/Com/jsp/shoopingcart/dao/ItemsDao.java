
	 package Com.jsp.shoopingcart.dao;
	 import javax.persistence.EntityManager;
     import javax.persistence.EntityManagerFactory;
     import javax.persistence.EntityTransaction;
     import org.springframework.beans.factory.annotation.Autowired;
     import org.springframework.stereotype.Repository;

import Com.jsp.shoopingcart.dto.Items;


       @Repository
       public class ItemsDao {
		@Autowired
		EntityManagerFactory emf;
		public void saveItems(Items item) {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			et.begin();
			em.persist(item);
			et.commit();
		}
		public void deleteItemsDaoById(int id) {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			 Items m=em.find(Items .class, id);
			 et.begin();
			 em.remove(m);
			 et.commit();
			 
		}
		

		public void UpdateItemsDaoById(Items i) {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			 et.begin();
			 em.merge(i);
			 et.commit();
			 
		}
		
		public Items findItemsDaoBYId(int id) {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			Items m=em.find(Items.class, id);
			
			if(m!=null) {
				return m;
				
			}
			else {
				return null;
			}
		}




}
