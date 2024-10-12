package com.bilal.hundal1.controllers;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bilal.hundal1.models.Card;
import com.bilal.hundal1.models.ResponseDTO;
import com.bilal.hundal1.services.CardService;
/**
 * This is the Controller class in Spring boot where all API calls are listened 
 */
@CrossOrigin()
@RestController
public class FirebaseOperationController {
	@Autowired
	private CardService cardService;
	@Autowired
	private ResponseDTO responseDto;
	/**
	 * Method for listening get Card call
	 * @param id
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@GetMapping("get_Card")
	public Card getCard(@RequestParam("id") String id) throws InterruptedException, ExecutionException {
		Card card=cardService.getCard(id);
		//responseDto.setCard(card);
//		if(card==null) {
//		responseDto.setRequestSuccess(false);
//		}else {
//			responseDto.setRequestSuccess(true);
//		}
		return card;
	}
	/**
	 * method for listening add card request call
	 * @param card
	 * @return
	 */
	@PostMapping("add_card")
	public ResponseDTO addCard(@RequestBody Card card) {
		boolean success=cardService.addCard(card);
		responseDto.setCard(card);
		responseDto.setRequestSuccess(success);
		return responseDto;
	}
	/**
	 * method for listening delete card request call
	 * @param card
	 * @return
	 */
	@DeleteMapping("delete_card")
	public ResponseDTO deleteCard(@RequestBody Card card) {
		boolean success=cardService.deleteCard(card.getId());
		responseDto.setCard(card);
		responseDto.setRequestSuccess(success);
		return responseDto;
	}
	/**
	 * method for listening update card request call
	 * @param card
	 * @return
	 */
	@PutMapping("update_card")
	public ResponseDTO updateCard(@RequestBody Card card) {
		boolean success=cardService.updateCard(card);
		responseDto.setCard(card);
		responseDto.setRequestSuccess(success);
		return responseDto;
	}

}






















