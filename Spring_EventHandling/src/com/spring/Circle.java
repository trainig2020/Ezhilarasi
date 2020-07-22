package com.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class Circle implements Shape, ApplicationEventPublisherAware{

	private Points center;
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	public Points getCenter() {
		return center;
	}
	@Resource
	public void setCenter(Points center) {
		this.center = center;
	}

	@Override
	public void draw() {
		//System.out.println("Drawing circle : ");
		//System.out.println("center is ("+ center.getX()+" , "+center.getY()+")");
		
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "default message", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[]{center.getX(),center.getY()}, "default message", null));
		System.out.println(this.messageSource.getMessage("greeting", null, "default message", null));
		
		DrawEvent drawEvent= new DrawEvent(this);
		publisher.publishEvent(drawEvent);
		
	}
	
	@PostConstruct
	public void initializeCircle(){
		System.out.println("Init method");
	}
	
	@PreDestroy
	public void destruction(){
		System.out.println("Destroy method");
	}
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher=publisher;
		
	}

}
