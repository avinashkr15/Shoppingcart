package Com.jsp.shoopingcart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Com.jsp.shoopingcart.dto.Orders;

@Repository
public class OrderDao {
	@Autowired
	EntityManagerFactory emf;

	public void saveOrderProduct(Orders p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(p);
		et.commit();
	}

	public void deleteOrderDaoById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Orders m = em.find(Orders.class, id);
		et.begin();
		em.remove(m);
		et.commit();

	}

	public Orders findOrderDaoBYId(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Orders m = em.find(Orders.class, id);

		if (m != null) {
			return m;

		} else {
			return null;
		}
	}

	public void updateOrderProduct(Orders p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(p);
		et.commit();
	}

}
