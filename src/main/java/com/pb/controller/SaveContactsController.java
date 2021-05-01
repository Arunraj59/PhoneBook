package com.pb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pb.model.Contact;
import com.pb.service.ContactService;

@Controller
public class SaveContactsController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping(path= {"/","/contacts"}, method= {RequestMethod.GET})
	public String viewSaveContactPage(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact",contact);
		return "index";
	}
	
	@RequestMapping(path= {"/save-contact"},method= {RequestMethod.POST})
	public String saveContact(@ModelAttribute("contact") Contact contact,BindingResult errors, ModelMap map) {
		boolean saveContact = contactService.saveContact(contact);
		if(saveContact) {
			map.addAttribute("succMsg", "Contact Saved Successfully");
		}else {
			map.addAttribute("errMag","Contact Saving Failed");
		}
		return "index";
	}

}
