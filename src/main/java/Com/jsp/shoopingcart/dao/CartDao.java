package Com.jsp.shoopingcart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Com.jsp.shoopingcart.dto.Cart;

@Repository

public class CartDao {
	@Autowired
	EntityManagerFactory emf;

	public void saveCartDao(Cart cart) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(cart);
		et.commit();
	}

	public void UpdateItemsDaoById(Cart id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Cart m = em.find(Cart.class, id);
		et.begin();
		em.merge(m);
		et.commit();

	}

	public void deleteCartDaoById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Cart m = em.find(Cart.class, id);
		et.begin();
		em.remove(m);
		et.commit();

	}

	public Cart findCartDaoBYId(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Cart m = em.find(Cart.class, id);

		if (m != null) {
			return m;

		} else {
			return null;
		}
	}

	public Cart removeAllItemsFromCart(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Cart c = em.find(Cart.class, id);
		c.setItems(null);
		c.setTotal_Price(0);

		et.begin();
		em.merge(c);
		et.commit();
		return c;

	}

	public void removeItemFromCartById(int cart_id, int item_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(null);
		et.commit();
	}

	public void updateCart(Cart c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(c);
		et.commit();
	}

}
