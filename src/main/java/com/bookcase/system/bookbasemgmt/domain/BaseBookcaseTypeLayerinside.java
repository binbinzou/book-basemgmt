package com.bookcase.system.bookbasemgmt.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;


/**
 * The persistent class for the base_bookcase_type_layerinside database table.
 * 
 */
@Entity
@Table(name="base_bookcase_type_layerinside")
@NamedQuery(name="BaseBookcaseTypeLayerinside.findAll", query="SELECT b FROM BaseBookcaseTypeLayerinside b")
public class BaseBookcaseTypeLayerinside implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name="BOOKCASE_LAYERINSIDESIZE_ID")
	private String bookcaseLayerinsidesizeId;

	@Column(name="BOOKCASE_TYPE_ID")
	private String bookcaseTypeId;

	@Column(name="BOX_X")
	private float boxX;

	@Column(name="BOX_Y")
	private float boxY;

	@Column(name="BOX_Z")
	private float boxZ;

	@Column(name="CREATE_TIME",insertable=false,updatable=false)
	private Timestamp createTime;

	private String creator;

	@Column(name="ORG_ID")
	private String orgId;

	private short status;

	@Column(name="UPDATE_TIME",insertable=false)
	private Timestamp updateTime;

	public BaseBookcaseTypeLayerinside() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookcaseLayerinsidesizeId() {
		return this.bookcaseLayerinsidesizeId;
	}

	public void setBookcaseLayerinsidesizeId(String bookcaseLayerinsidesizeId) {
		this.bookcaseLayerinsidesizeId = bookcaseLayerinsidesizeId;
	}

	public String getBookcaseTypeId() {
		return this.bookcaseTypeId;
	}

	public void setBookcaseTypeId(String bookcaseTypeId) {
		this.bookcaseTypeId = bookcaseTypeId;
	}

	public float getBoxX() {
		return this.boxX;
	}

	public void setBoxX(float boxX) {
		this.boxX = boxX;
	}

	public float getBoxY() {
		return this.boxY;
	}

	public void setBoxY(float boxY) {
		this.boxY = boxY;
	}

	public float getBoxZ() {
		return this.boxZ;
	}

	public void setBoxZ(float boxZ) {
		this.boxZ = boxZ;
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

}