package com.pb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		if (contact.getId() != null) {
			Optional<ContactEntity> findById = repository.findById(contact.getId());
			if (findById.isPresent()) {
				ContactEntity entity = findById.get();
				BeanUtils.copyProperties(contact, entity);
				ContactEntity savedEntity = repository.save(entity);
				return savedEntity.getId() != null;
			}

		}
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactEntity savedEntity = repository.save(entity);
		return savedEntity.getId() != null;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteContact(int contactId) {
		boolean flag = true;
		try {
			repository.deleteById(contactId);
		}catch(Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAllContacts() {
		List<ContactEntity> contactsEntity = repository.findAll();
		List<Contact> contacts = contactsEntity.stream().map(entity -> {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
		return contacts;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean updateContact(Contact contact) {
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Contact findByContactId(int id) {
		Optional<ContactEntity> contact = repository.findById(id);
		if (contact.isPresent()) {
			ContactEntity entity = contact.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		return null;
	}

}
