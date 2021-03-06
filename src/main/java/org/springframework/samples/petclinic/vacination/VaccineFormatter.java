package org.springframework.samples.petclinic.vacination;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class VaccineFormatter implements Formatter<Vaccine>{
	
	@Autowired
	private VaccinationService v;

    @Override
    public String print(Vaccine object, Locale locale) {
    	String nombre = object.getName();
        return nombre;
    }

    @Override
    public Vaccine parse(String text, Locale locale) throws ParseException {
    	Vaccine va = this.v.getVaccine(text);
        if(va == null) {
        	throw new ParseException(text, 0);
        }else {
        	return va;
        }
    }
    
}
