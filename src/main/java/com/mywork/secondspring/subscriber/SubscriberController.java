package com.mywork.secondspring.subscriber;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubscriberController {
	

	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@GetMapping
    public String index(Subscriber subscriber) {
	//Where we want to go when our application is started
    	return "subscriber/index";
    }
	
	@PostMapping(value = "/")
	public String addNewSubscriber(Subscriber subscriber, Model model) {
		subscriberRepository.save(new Subscriber(subscriber.getFirstName(), 
	    subscriber.getLastName(), subscriber.getUsername(), subscriber.getSignedUp()));
		model.addAttribute("firstName", subscriber.getFirstName());
		model.addAttribute("lastName", subscriber.getLastName());
		model.addAttribute("username", subscriber.getUsername());
		return "subscriber/result";
	}
	@GetMapping(value = "/subscribers")
	public String getAllSubscribers(Model model) {
		List<Subscriber> listOfAllSubscribers = new ArrayList<Subscriber>();
		listOfAllSubscribers = subscriberRepository.findAll();
		model.addAttribute("listOfAllSubscribers", listOfAllSubscribers);
		return "subscriber/subscribers";
	}
}