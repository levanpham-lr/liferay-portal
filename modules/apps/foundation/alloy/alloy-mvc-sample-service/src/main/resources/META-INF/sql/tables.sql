create table AlloyMVCSample_TodoItem (
	todoItemId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	todoListId LONG,
	description VARCHAR(75) null,
	priority INTEGER,
	status INTEGER
);

create table AlloyMVCSample_TodoList (
	todoListId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
);