package com.bookcase.system.bookbasemgmt.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;


/**
 * The persistent class for the base_bookcase_type database table.
 * 
 */
@Entity
@Table(name="base_bookcase_type")
@NamedQuery(name="BaseBookcaseType.findAll", query="SELECT b FROM BaseBookcaseType b")
public class BaseBookcaseType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name="BOX_COUNT")
	private int boxCount;

	@Column(name="CREATE_TIME",insertable=false,updatable=false)
	private Timestamp createTime;

	private String creator;

	private float height;

	private float length;

	private String name;

	@Column(name="ORG_ID")
	private String orgId;

	private short status;

	@Column(name="UPDATE_TIME",insertable=false)
	private Timestamp updateTime;

	private float wide;

	public BaseBookcaseType() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBoxCount() {
		return this.boxCount;
	}

	public void setBoxCount(int boxCount) {
		this.boxCount = boxCount;
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

	public float getHeight() {
		return this.height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getLength() {
		return this.length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
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

	public float getWide() {
		return this.wide;
	}

	public void setWide(float wide) {
		this.wide = wide;
	}

}