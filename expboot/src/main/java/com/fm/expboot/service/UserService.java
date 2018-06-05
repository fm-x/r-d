package com.fm.expboot.service;

import java.util.List;

import com.fm.expboot.db.model.User;

/**
 * 用户服务
 *
 */
public interface UserService {

	List<User> getAll(User user);

	User getById(Long id);

	int deleteById(Long id);

	int merge(User user);

}
