package com.app.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.FeedbackDTO;
import com.app.entities.DoctorEntity;
import com.app.entities.FeedBackEntity;
import com.app.entities.UserEntity;
import com.app.exception.InvalidCredentialExc;
import com.app.repository.DoctorRepository;
import com.app.repository.FeedbackRepository;
import com.app.repository.UserRepository;
@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackRepository feedbackRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public String addFeedback(FeedbackDTO dto) {
		UserEntity commentor=userRepository.findById(dto.getCommenterId())
				.orElseThrow(()->new InvalidCredentialExc("Invalid Commentor id"));
		DoctorEntity doctor=doctorRepository.findById(dto.getDoctorId())
				.orElseThrow(()->new InvalidCredentialExc("Invalid doctor id"));
		
		FeedBackEntity feedback=modelMapper.map(dto, FeedBackEntity.class);
		feedback.setPatient_id(commentor);
		feedback.setDostor_id(doctor);
		feedbackRepository.save(feedback);
		return "Comment added...";
	}
	@Override
	public String deleteFeedback(@Valid Long feedbackId) {
		if(feedbackRepository.existsById(feedbackId)) {
			feedbackRepository.deleteById(feedbackId);
			return "feedback deleted";
		}
		return "Invalid feedback id..feedback not deleted";
	}

}
