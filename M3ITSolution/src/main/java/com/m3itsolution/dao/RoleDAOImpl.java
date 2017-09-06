package com.m3itsolution.dao;

import java.util.HashSet;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.m3itsolution.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO{
	
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public HashSet<Role> findAll() {
		
      //Find the correct way to add default long id
		DetachedCriteria criteria= DetachedCriteria.forClass(Role.class);
		@SuppressWarnings("unchecked")
		HashSet<Role> role =(HashSet<Role>) hibernateTemplate.findByCriteria(criteria);
		
		return role;
	}

}
