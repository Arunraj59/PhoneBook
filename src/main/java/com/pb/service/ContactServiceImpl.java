package com.pb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pb.entity.ContactEntity;
import com.pb.model.Contact;
import com.pb.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository repository;

	@Override
	@Transactional(readOnly = false)
	public boolean saveContact(Contact contact) {
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactEntity savedEntity = repository.save(entity);
		return savedEntity.getId() != null;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteContact(int contactId) {
		repository.deleteById(contactId);
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAllContacts() {
		//return repository.findAll();
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean updateContact(Contact contact) {
		return false;
	}

	@Override
	public Contact findByContactId(int id) {
		Optional<ContactEntity> contact = repository.findById(id);
		return null;
	}

}
