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
 * This class is a wrapper for {@link TodoItem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItem
 * @generated
 */
public class TodoItemWrapper implements ModelWrapper<TodoItem>, TodoItem {

	public TodoItemWrapper(TodoItem todoItem) {
		_todoItem = todoItem;
	}

	@Override
	public Class<?> getModelClass() {
		return TodoItem.class;
	}

	@Override
	public String getModelClassName() {
		return TodoItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("todoItemId", getTodoItemId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("todoListId", getTodoListId());
		attributes.put("description", getDescription());
		attributes.put("priority", getPriority());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long todoItemId = (Long)attributes.get("todoItemId");

		if (todoItemId != null) {
			setTodoItemId(todoItemId);
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

		Long todoListId = (Long)attributes.get("todoListId");

		if (todoListId != null) {
			setTodoListId(todoListId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Object clone() {
		return new TodoItemWrapper((TodoItem)_todoItem.clone());
	}

	@Override
	public int compareTo(TodoItem todoItem) {
		return _todoItem.compareTo(todoItem);
	}

	/**
	 * Returns the company ID of this todo item.
	 *
	 * @return the company ID of this todo item
	 */
	@Override
	public long getCompanyId() {
		return _todoItem.getCompanyId();
	}

	/**
	 * Returns the create date of this todo item.
	 *
	 * @return the create date of this todo item
	 */
	@Override
	public Date getCreateDate() {
		return _todoItem.getCreateDate();
	}

	/**
	 * Returns the description of this todo item.
	 *
	 * @return the description of this todo item
	 */
	@Override
	public String getDescription() {
		return _todoItem.getDescription();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _todoItem.getExpandoBridge();
	}

	/**
	 * Returns the modified date of this todo item.
	 *
	 * @return the modified date of this todo item
	 */
	@Override
	public Date getModifiedDate() {
		return _todoItem.getModifiedDate();
	}

	/**
	 * Returns the primary key of this todo item.
	 *
	 * @return the primary key of this todo item
	 */
	@Override
	public long getPrimaryKey() {
		return _todoItem.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _todoItem.getPrimaryKeyObj();
	}

	/**
	 * Returns the priority of this todo item.
	 *
	 * @return the priority of this todo item
	 */
	@Override
	public int getPriority() {
		return _todoItem.getPriority();
	}

	/**
	 * Returns the status of this todo item.
	 *
	 * @return the status of this todo item
	 */
	@Override
	public int getStatus() {
		return _todoItem.getStatus();
	}

	/**
	 * Returns the todo item ID of this todo item.
	 *
	 * @return the todo item ID of this todo item
	 */
	@Override
	public long getTodoItemId() {
		return _todoItem.getTodoItemId();
	}

	/**
	 * Returns the todo list ID of this todo item.
	 *
	 * @return the todo list ID of this todo item
	 */
	@Override
	public long getTodoListId() {
		return _todoItem.getTodoListId();
	}

	/**
	 * Returns the user ID of this todo item.
	 *
	 * @return the user ID of this todo item
	 */
	@Override
	public long getUserId() {
		return _todoItem.getUserId();
	}

	/**
	 * Returns the user name of this todo item.
	 *
	 * @return the user name of this todo item
	 */
	@Override
	public String getUserName() {
		return _todoItem.getUserName();
	}

	/**
	 * Returns the user uuid of this todo item.
	 *
	 * @return the user uuid of this todo item
	 */
	@Override
	public String getUserUuid() {
		return _todoItem.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _todoItem.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _todoItem.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _todoItem.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _todoItem.isNew();
	}

	@Override
	public void persist() {
		_todoItem.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_todoItem.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this todo item.
	 *
	 * @param companyId the company ID of this todo item
	 */
	@Override
	public void setCompanyId(long companyId) {
		_todoItem.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this todo item.
	 *
	 * @param createDate the create date of this todo item
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_todoItem.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this todo item.
	 *
	 * @param description the description of this todo item
	 */
	@Override
	public void setDescription(String description) {
		_todoItem.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_todoItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_todoItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_todoItem.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the modified date of this todo item.
	 *
	 * @param modifiedDate the modified date of this todo item
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_todoItem.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_todoItem.setNew(n);
	}

	/**
	 * Sets the primary key of this todo item.
	 *
	 * @param primaryKey the primary key of this todo item
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_todoItem.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_todoItem.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the priority of this todo item.
	 *
	 * @param priority the priority of this todo item
	 */
	@Override
	public void setPriority(int priority) {
		_todoItem.setPriority(priority);
	}

	/**
	 * Sets the status of this todo item.
	 *
	 * @param status the status of this todo item
	 */
	@Override
	public void setStatus(int status) {
		_todoItem.setStatus(status);
	}

	/**
	 * Sets the todo item ID of this todo item.
	 *
	 * @param todoItemId the todo item ID of this todo item
	 */
	@Override
	public void setTodoItemId(long todoItemId) {
		_todoItem.setTodoItemId(todoItemId);
	}

	/**
	 * Sets the todo list ID of this todo item.
	 *
	 * @param todoListId the todo list ID of this todo item
	 */
	@Override
	public void setTodoListId(long todoListId) {
		_todoItem.setTodoListId(todoListId);
	}

	/**
	 * Sets the user ID of this todo item.
	 *
	 * @param userId the user ID of this todo item
	 */
	@Override
	public void setUserId(long userId) {
		_todoItem.setUserId(userId);
	}

	/**
	 * Sets the user name of this todo item.
	 *
	 * @param userName the user name of this todo item
	 */
	@Override
	public void setUserName(String userName) {
		_todoItem.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this todo item.
	 *
	 * @param userUuid the user uuid of this todo item
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_todoItem.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TodoItem> toCacheModel() {
		return _todoItem.toCacheModel();
	}

	@Override
	public TodoItem toEscapedModel() {
		return new TodoItemWrapper(_todoItem.toEscapedModel());
	}

	@Override
	public String toString() {
		return _todoItem.toString();
	}

	@Override
	public TodoItem toUnescapedModel() {
		return new TodoItemWrapper(_todoItem.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _todoItem.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TodoItemWrapper)) {
			return false;
		}

		TodoItemWrapper todoItemWrapper = (TodoItemWrapper)object;

		if (Objects.equals(_todoItem, todoItemWrapper._todoItem)) {
			return true;
		}

		return false;
	}

	@Override
	public TodoItem getWrappedModel() {
		return _todoItem;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _todoItem.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _todoItem.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_todoItem.resetOriginalValues();
	}

	private final TodoItem _todoItem;

}