package com.niit.shoppingcart.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	

	@Autowired
	private SessionFactory sessionFactory;


	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Transactional
	public void saveOrUpdate1(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
			
	}

	@Transactional
	public void delete(String id) {
		User user = new User();
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);
	}

	@Transactional
	public User get1(String id) {
		String hql = "from User where id=" + "'"+ id +"'";
		//  from user where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<User> listUser = (List<User>) query.list();
		
		Object listUs = null;
		if (listUs != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}



	public User get(String id) {
		// TODO Auto-generated method stub
		return null;
	}



	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		
	}
}


	
	
	
	



