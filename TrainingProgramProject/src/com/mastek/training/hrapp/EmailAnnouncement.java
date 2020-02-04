package com.mastek.training.hrapp;

public class EmailAnnouncement extends Announcement {

	@Override
	public void sendAnnouncement() {
		System.out.println("Sending Emails TO:"+getForGroup()+" By "+getFrom()+
			" with Title: "+getSubject()+" and Text :"+getContentText());

	}

}
