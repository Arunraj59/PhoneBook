package com.pb.service;

import java.util.List;

import com.pb.model.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact contact);

	public boolean deleteContact(int contactId);

	public List<Contact> findAllContacts();

	public boolean updateContact(Contact contact);
	
	public Contact findByContactId(int id);
	
}
