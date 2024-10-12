package com.bilal.hundal1.models;

import org.springframework.stereotype.Component;
/**
 * This is POJO Model class for response body
 */
@Component
public class ResponseDTO {
	private boolean requestSuccess;
	private Card card;
	
	public ResponseDTO() {
		
	}
	public ResponseDTO(boolean requestSuccess, Card card) {
		super();
		this.requestSuccess = requestSuccess;
		this.card = card;
	}
	public boolean isRequestSuccess() {
		return requestSuccess;
	}
	public void setRequestSuccess(boolean requestSuccess) {
		this.requestSuccess = requestSuccess;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	

}
