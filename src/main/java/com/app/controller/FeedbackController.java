package com.app.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.FeedbackDTO;
import com.app.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping
	public ApiResponse addFeedback(@RequestBody FeedbackDTO dto) {
		return new ApiResponse(feedbackService.addFeedback(dto));
	}
	@DeleteMapping("/{feedbackId}")
	public ApiResponse deleteFeedback(@PathVariable @Valid Long feedbackId) {
		return new ApiResponse(feedbackService.deleteFeedback(feedbackId));
				
	}
}
