/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.fm.expboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.expboot.db.mapper.UserMapper;
import com.fm.expboot.db.model.User;
import com.fm.expboot.service.UserService;
import com.github.pagehelper.PageHelper;

/**
 * 用户服务实现
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getAll(User user) {
		if (user.getPageNum() != null && user.getPageSize() != null) {
			PageHelper.startPage(user.getPageNum(), user.getPageSize(), "id");
		}
		return userMapper.selectAll();
	}

	@Override
	public User getById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int merge(User user) {
		int inflRows = 0;
		if (user.getId() != null) {
			inflRows = userMapper.updateByPrimaryKey(user);
		} else {
			inflRows = userMapper.insertSelective(user);
		}
		return inflRows;
	}

}
