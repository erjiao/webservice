package com.erjiao.cxf;

import org.apache.cxf.aegis.type.java5.IgnoreProperty;
import org.apache.cxf.aegis.type.java5.XmlAttribute;
import org.apache.cxf.aegis.type.java5.XmlElement;
import org.apache.cxf.aegis.type.java5.XmlType;

/**
 * Person 
 */
@XmlType(name="person_type")
public class Person {
	private Integer id;
	private String name;
	
	private String password;
	
	@IgnoreProperty
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@XmlAttribute(name="_id__")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@XmlElement(name="_name__")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
