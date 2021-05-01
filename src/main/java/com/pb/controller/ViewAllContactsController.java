package com.pb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(path = { "/edit-contact" }, method = { RequestMethod.GET })
	public String editContact(@RequestParam("id") Integer contactId, ModelMap map) {
		
		return "redirect";
	}
}
