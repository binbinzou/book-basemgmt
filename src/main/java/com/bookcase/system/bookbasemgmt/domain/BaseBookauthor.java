package com.bookcase.system.bookbasemgmt.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;


/**
 * The persistent class for the base_bookauthor database table.
 * 
 */
@Entity
@Table(name="base_bookauthor")
@NamedQuery(name="BaseBookauthor.findAll", query="SELECT b FROM BaseBookauthor b")
public class BaseBookauthor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name="ANOTHER_NAME")
	private String anotherName;

	@Column(name="BIRTHDAY")
	private String birthday;

	@Column(name="CREATE_TIME",insertable=false,updatable=false)
	private Timestamp createTime;

	@Column(name="CREATOR")
	private String creator;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="NAME")
	private String name;

	@Column(name="NATIONALITY")
	private String nationality;

	@Column(name="PEN_NAME")
	private String penName;

	@Column(name="STATUS")
	private short status;

	@Column(name="UPDATE_TIME",insertable=false)
	private Timestamp updateTime;

	public BaseBookauthor() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAnotherName() {
		return this.anotherName;
	}

	public void setAnotherName(String anotherName) {
		this.anotherName = anotherName;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPenName() {
		return this.penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}