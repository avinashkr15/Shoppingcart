package Com.jsp.shoopingcart.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Com.jsp.shoopingcart.dto.Merchant;
import Com.jsp.shoopingcart.dto.Product;

@Repository
public class Merchantdao {
	@Autowired
	ProductDao pdao;

	@Autowired
	EntityManagerFactory emf;

	public void saveMerchant(Merchant Merchant) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(Merchant);
		et.commit();
	}

	public Merchant login(String email, String password) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);

		try {
			@SuppressWarnings("unused")
			Merchant merchant = (Merchant) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

		Merchant m = (Merchant) query.getSingleResult();
		if (m != null) {
			return m;
		} else {
			return null;

		}
	}

	public void deleteMerchantById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Merchant m = em.find(Merchant.class, id);
		et.begin();
		em.remove(m);
		et.commit();

	}

	public Merchant findMerchantBYId(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Merchant m = em.find(Merchant.class, id);

		if (m != null) {
			return m;

		} else {
			return null;
		}
	}

	public void updateMerchant(Merchant Merchant) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(Merchant);
		et.commit();
	}

	public Merchant deleteProductFormMerchant(int Merchant_id, int product_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Merchant merchant = em.find(Merchant.class, Merchant_id);
		List<Product> products = merchant.getProduct();

		List<Product> productList = new ArrayList<Product>();

		for (Product p : products) {
			if (p.getId() != product_id)
				productList.add(p);
		}
		/*
		 * Product p=pdao.findProductById(product_id); p roducts.remove(p);
		 */
		
		merchant.setProduct(productList);
		
		return merchant;
	}

}
