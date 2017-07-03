package com.bookcase.system.bookbasemgmt.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;


/**
 * The persistent class for the base_book_commonmsg database table.
 * 
 */
@Entity
@Table(name="base_book_commonmsg")
@NamedQuery(name="BaseBookCommonmsg.findAll", query="SELECT b FROM BaseBookCommonmsg b")
public class BaseBookCommonmsg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@Column(name="ANOTHER_NAME")
	private String anotherName;

	@Column(name="AUTHOR_ID")
	private String authorId;

	@Column(name="BOOKTYPE_ID")
	private String booktypeId;

	@Column(name="BRIEFING")
	private String briefing;

	@Column(name="CATALOG")
	private String catalog;

	@Column(name="CREATE_TIME",insertable=false,updatable=false)
	private Timestamp createTime;

	@Column(name="CREATOR")
	private String creator;

	@Column(name="name")
	private String name;

	@Column(name="PAGE_CNT")
	private short pageCnt;

	@Column(name="READ_OVERTIME")
	private short readOvertime;

	@Column(name="STATUS")
	private short status;

	@Column(name="TRANSLATOR_ID")
	private String translatorId;

	@Column(name="UPDATE_TIME",insertable=false)
	private Timestamp updateTime;

	public BaseBookCommonmsg() {
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

	public String getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getBooktypeId() {
		return this.booktypeId;
	}

	public void setBooktypeId(String booktypeId) {
		this.booktypeId = booktypeId;
	}

	public String getBriefing() {
		return this.briefing;
	}

	public void setBriefing(String briefing) {
		this.briefing = briefing;
	}

	public String getCatalog() {
		return this.catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getPageCnt() {
		return this.pageCnt;
	}

	public void setPageCnt(short pageCnt) {
		this.pageCnt = pageCnt;
	}

	public short getReadOvertime() {
		return this.readOvertime;
	}

	public void setReadOvertime(short readOvertime) {
		this.readOvertime = readOvertime;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getTranslatorId() {
		return this.translatorId;
	}

	public void setTranslatorId(String translatorId) {
		this.translatorId = translatorId;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}