package com.apress.messaging.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IndentHint {
	private Long indentId;
	private String code;
	private String status;
	private String message;
	private String petOwner;
	private String petServer;
	private Date sent;


	public Long getIndentId() {
		return indentId;
	}


	public void setIndentId(Long indentId) {
		this.indentId = indentId;
	}
	public IndentHint() {
		this.sent = new Date();
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getPetOwner() {
		return petOwner;
	}


	public void setPetOwner(String petOwner) {
		this.petOwner = petOwner;
	}


	public String getPetServer() {
		return petServer;
	}


	public void setPetServer(String petServer) {
		this.petServer = petServer;
	}


	public Date getSent() {
		return sent;
	}


	public void setSent(Date sent) {
		this.sent = sent;
	}


	@Override
	public String toString() {
		return "IndentHint [indentId"+indentId+", code=" + code + ", status=" + status + ", sent="
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sent) + "]";
	}

}
