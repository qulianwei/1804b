package com.jk.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="t_event")
public class Event {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer eventId       ;
private String eventBrand    ;
private String languages     ;
private String eventName     ;
private Integer actType       ;
private String synopsis      ;
private String actLocation   ;
private String startLocation ;
@DateTimeFormat(pattern="yyyy-MM-dd")
@Temporal(TemporalType.DATE)
private Date startTime     ;
@DateTimeFormat(pattern="yyyy-MM-dd")
@Temporal(TemporalType.DATE)
private Date endTile       ;
@DateTimeFormat(pattern="yyyy-MM-dd")
@Temporal(TemporalType.DATE)
private Date enroStart     ;
@DateTimeFormat(pattern="yyyy-MM-dd")
@Temporal(TemporalType.DATE)
private Date enroEnd       ;
private Integer joinNo        ;
private String eventDetails  ;
private String eventUrl      ;
private Integer servic        ;
private String lineType      ;
private Integer status;
private Integer accStatus;

//业务字段
@Transient
private String yearTime;
@Transient
private String monthTime;


public Integer getEventId() {
	return eventId;
}
public void setEventId(Integer eventId) {
	this.eventId = eventId;
}
public String getEventBrand() {
	return eventBrand;
}
public void setEventBrand(String eventBrand) {
	this.eventBrand = eventBrand;
}
public String getLanguages() {
	return languages;
}
public void setLanguages(String languages) {
	this.languages = languages;
}
public String getEventName() {
	return eventName;
}
public void setEventName(String eventName) {
	this.eventName = eventName;
}
public Integer getActType() {
	return actType;
}
public void setActType(Integer actType) {
	this.actType = actType;
}
public String getSynopsis() {
	return synopsis;
}
public void setSynopsis(String synopsis) {
	this.synopsis = synopsis;
}
public String getActLocation() {
	return actLocation;
}
public void setActLocation(String actLocation) {
	this.actLocation = actLocation;
}
public String getStartLocation() {
	return startLocation;
}
public void setStartLocation(String startLocation) {
	this.startLocation = startLocation;
}
public Date getStartTime() {
	return startTime;
}
public void setStartTime(Date startTime) {
	this.startTime = startTime;
}
public Date getEndTile() {
	return endTile;
}
public void setEndTile(Date endTile) {
	this.endTile = endTile;
}
public Date getEnroStart() {
	return enroStart;
}
public void setEnroStart(Date enroStart) {
	this.enroStart = enroStart;
}
public Date getEnroEnd() {
	return enroEnd;
}
public void setEnroEnd(Date enroEnd) {
	this.enroEnd = enroEnd;
}
public Integer getJoinNo() {
	return joinNo;
}
public void setJoinNo(Integer joinNo) {
	this.joinNo = joinNo;
}
public String getEventDetails() {
	return eventDetails;
}
public void setEventDetails(String eventDetails) {
	this.eventDetails = eventDetails;
}
public String getEventUrl() {
	return eventUrl;
}
public void setEventUrl(String eventUrl) {
	this.eventUrl = eventUrl;
}
public Integer getServic() {
	return servic;
}
public void setServic(Integer servic) {
	this.servic = servic;
}
public String getLineType() {
	return lineType;
}
public void setLineType(String lineType) {
	this.lineType = lineType;
}

public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public Integer getAccStatus() {
	return accStatus;
}
public void setAccStatus(Integer accStatus) {
	this.accStatus = accStatus;
}
public String getYearTime() {
	return yearTime;
}
public void setYearTime(String yearTime) {
	this.yearTime = yearTime;
}
public String getMonthTime() {
	return monthTime;
}
public void setMonthTime(String monthTime) {
	this.monthTime = monthTime;
}






}
