package com.pb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pb.model.Contact;
import com.pb.service.ContactService;

@Controller
public class ViewAllContactsController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(path = { "/all-contacts" }, method = { RequestMethod.GET })
	public String showAllContactsPage(Model model) {
		List<Contact> contacts = contactService.findAllContacts();
		model.addAttribute("contacts", contacts);
		return "view-allcontacts";
	}

	@RequestMapping(path = { "/edit-contact/{id}" }, method = { RequestMethod.GET })
	public String editContact(@PathVariable("id") Integer contactId, ModelMap map) {

		return "redirect";
	}
}
