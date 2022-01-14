package org.springframework.samples.petclinic.vacination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vaccination")
public class VaccinationController {
	
	@Autowired
	private VaccinationService vaccinationService;
	
	private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "vaccinations/createOrUpdateVaccinationForm";
    
	@GetMapping(path ="/create")
	public String initCreationForm(ModelMap modelMap) {
		String view = VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
		modelMap.addAttribute("product", new Vaccination());
		modelMap.addAttribute("productType", vaccinationService.getAllVaccines());
		return view;
}
	
	
}

