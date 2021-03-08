/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.alloy.mvc.sample.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TodoList}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoList
 * @generated
 */
public class TodoListWrapper implements ModelWrapper<TodoList>, TodoList {

	public TodoListWrapper(TodoList todoList) {
		_todoList = todoList;
	}

	@Override
	public Class<?> getModelClass() {
		return TodoList.class;
	}

	@Override
	public String getModelClassName() {
		return TodoList.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("todoListId", getTodoListId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long todoListId = (Long)attributes.get("todoListId");

		if (todoListId != null) {
			setTodoListId(todoListId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public Object clone() {
		return new TodoListWrapper((TodoList)_todoList.clone());
	}

	@Override
	public int compareTo(TodoList todoList) {
		return _todoList.compareTo(todoList);
	}

	/**
	 * Returns the company ID of this todo list.
	 *
	 * @return the company ID of this todo list
	 */
	@Override
	public long getCompanyId() {
		return _todoList.getCompanyId();
	}

	/**
	 * Returns the create date of this todo list.
	 *
	 * @return the create date of this todo list
	 */
	@Override
	public Date getCreateDate() {
		return _todoList.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _todoList.getExpandoBridge();
	}

	/**
	 * Returns the modified date of this todo list.
	 *
	 * @return the modified date of this todo list
	 */
	@Override
	public Date getModifiedDate() {
		return _todoList.getModifiedDate();
	}

	/**
	 * Returns the name of this todo list.
	 *
	 * @return the name of this todo list
	 */
	@Override
	public String getName() {
		return _todoList.getName();
	}

	/**
	 * Returns the primary key of this todo list.
	 *
	 * @return the primary key of this todo list
	 */
	@Override
	public long getPrimaryKey() {
		return _todoList.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _todoList.getPrimaryKeyObj();
	}

	/**
	 * Returns the todo list ID of this todo list.
	 *
	 * @return the todo list ID of this todo list
	 */
	@Override
	public long getTodoListId() {
		return _todoList.getTodoListId();
	}

	/**
	 * Returns the user ID of this todo list.
	 *
	 * @return the user ID of this todo list
	 */
	@Override
	public long getUserId() {
		return _todoList.getUserId();
	}

	/**
	 * Returns the user name of this todo list.
	 *
	 * @return the user name of this todo list
	 */
	@Override
	public String getUserName() {
		return _todoList.getUserName();
	}

	/**
	 * Returns the user uuid of this todo list.
	 *
	 * @return the user uuid of this todo list
	 */
	@Override
	public String getUserUuid() {
		return _todoList.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _todoList.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _todoList.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _todoList.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _todoList.isNew();
	}

	@Override
	public void persist() {
		_todoList.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_todoList.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this todo list.
	 *
	 * @param companyId the company ID of this todo list
	 */
	@Override
	public void setCompanyId(long companyId) {
		_todoList.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this todo list.
	 *
	 * @param createDate the create date of this todo list
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_todoList.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_todoList.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_todoList.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_todoList.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the modified date of this todo list.
	 *
	 * @param modifiedDate the modified date of this todo list
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_todoList.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this todo list.
	 *
	 * @param name the name of this todo list
	 */
	@Override
	public void setName(String name) {
		_todoList.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_todoList.setNew(n);
	}

	/**
	 * Sets the primary key of this todo list.
	 *
	 * @param primaryKey the primary key of this todo list
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_todoList.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_todoList.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the todo list ID of this todo list.
	 *
	 * @param todoListId the todo list ID of this todo list
	 */
	@Override
	public void setTodoListId(long todoListId) {
		_todoList.setTodoListId(todoListId);
	}

	/**
	 * Sets the user ID of this todo list.
	 *
	 * @param userId the user ID of this todo list
	 */
	@Override
	public void setUserId(long userId) {
		_todoList.setUserId(userId);
	}

	/**
	 * Sets the user name of this todo list.
	 *
	 * @param userName the user name of this todo list
	 */
	@Override
	public void setUserName(String userName) {
		_todoList.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this todo list.
	 *
	 * @param userUuid the user uuid of this todo list
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_todoList.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TodoList> toCacheModel() {
		return _todoList.toCacheModel();
	}

	@Override
	public TodoList toEscapedModel() {
		return new TodoListWrapper(_todoList.toEscapedModel());
	}

	@Override
	public String toString() {
		return _todoList.toString();
	}

	@Override
	public TodoList toUnescapedModel() {
		return new TodoListWrapper(_todoList.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _todoList.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TodoListWrapper)) {
			return false;
		}

		TodoListWrapper todoListWrapper = (TodoListWrapper)object;

		if (Objects.equals(_todoList, todoListWrapper._todoList)) {
			return true;
		}

		return false;
	}

	@Override
	public TodoList getWrappedModel() {
		return _todoList;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _todoList.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _todoList.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_todoList.resetOriginalValues();
	}

	private final TodoList _todoList;

}