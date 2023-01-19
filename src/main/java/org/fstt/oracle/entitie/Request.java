package org.fstt.oracle.entitie;

import org.hibernate.annotations.Index;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="request")
public class Request {

	@SuppressWarnings("deprecation")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Index(name = "idx_column1")
	private int id_request;
	
	
	@SuppressWarnings("deprecation")
	@Index(name = "idx_column2")
	private String content;
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Request(int id_request, String content) {
		super();
		this.id_request = id_request;
		this.content = content;
	}


	public int getId_request() {
		return id_request;
	}

	public void setId_request(int id_request) {
		this.id_request = id_request;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "Request [id_request=" + id_request + ", content=" + content + "]";
	}

}
