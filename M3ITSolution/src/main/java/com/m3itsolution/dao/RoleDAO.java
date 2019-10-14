package com.m3itsolution.dao;

import java.util.HashSet;
import com.m3itsolution.model.Role;

public interface RoleDAO {
	public HashSet<Role> findAll();
}