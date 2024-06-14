package com.app.service;

import javax.validation.Valid;
import com.app.dto.FeedbackDTO;

public interface FeedbackService {
	String addFeedback(FeedbackDTO dto);

	String deleteFeedback(@Valid Long feedbackId);
}
