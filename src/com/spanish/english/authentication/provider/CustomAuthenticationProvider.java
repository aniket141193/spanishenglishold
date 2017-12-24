package com.spanish.english.authentication.provider;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.spanish.english.form.Admin;
import com.spanish.english.form.Establishment;
import com.spanish.english.form.Operator;
import com.spanish.english.form.Technician;
import com.spanish.english.services.AdminServices;
import com.spanish.english.services.EstablishmentServices;
import com.spanish.english.services.OperatorServices;
import com.spanish.english.services.TechnicianServices;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	AdminServices adminServices;
	
	@Autowired
	OperatorServices operatorServices;
	
	@Autowired
	EstablishmentServices establishmentServices; 
	
	@Autowired
	TechnicianServices technicianServices;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		System.out.println("username:"+username);
		Collection<? extends GrantedAuthority> authorities = null;
		Admin admin = adminServices.getUserByUsername(username);
		Operator operator = operatorServices.getOperatorByUsername(username);
		Establishment establishment = establishmentServices.getEstablishmentByUsername(username);
		Technician technician = technicianServices.getTechnicianByUsername(username);
		if(admin != null){
		if(admin.getAdminRole().equalsIgnoreCase("ROLE_ADMIN")){
		
		 if (admin == null || !admin.getAdminUsername().equalsIgnoreCase(username)) {
             throw new BadCredentialsException("Username not found.");
         }
  
         if (!password.equals(admin.getAdminPassword())) {
             throw new BadCredentialsException("Wrong password.");
         }
         authorities = admin.getAuthorities();
		}
		}else if(operator != null){
			
			if(operator.getOperatorRole().equalsIgnoreCase("ROLE_OPERATOR")){
				
				 if (operator == null || !operator.getOperatorUsername().equalsIgnoreCase(username)) {
		             throw new BadCredentialsException("Username not found.");
		         }
		  
		         if (!password.equals(operator.getOperatorPassword())) {
		             throw new BadCredentialsException("Wrong password.");
		         }
		         authorities = operator.getAuthorities();
			}
		}else if(establishment != null){
			if(establishment.getEstablishmentRole().equalsIgnoreCase("ROLE_ESTABLISHMENT")){
				
				 if (establishment == null || !establishment.getEstablishmentUsername().equalsIgnoreCase(username)) {
		             throw new BadCredentialsException("Username not found.");
		         }
		  
		         if (!password.equals(establishment.getEstablishmentPassword())) {
		             throw new BadCredentialsException("Wrong password.");
		         }
		         authorities = establishment.getAuthorities();
			}
		}else if(technician != null){
			if(technician.getTechnicianRole().equalsIgnoreCase("ROLE_TECHNICIAN")){
				
				 if (technician == null || !technician.getTechnicianUsername().equalsIgnoreCase(username)) {
		             throw new BadCredentialsException("Username not found.");
		         }
		  
		         if (!password.equals(technician.getTechnicianPassword())) {
		             throw new BadCredentialsException("Wrong password.");
		         }
		         authorities = technician.getAuthorities();
			}
		}
		
		
        if(admin != null){
         return new UsernamePasswordAuthenticationToken(admin, password, authorities);
        }else if(operator != null){
        	return new UsernamePasswordAuthenticationToken(operator, password, authorities);
        }else if(establishment != null){
        	return new UsernamePasswordAuthenticationToken(establishment, password, authorities);
        }else if(technician != null){
        	return new UsernamePasswordAuthenticationToken(technician, password, authorities);
        }else{
        	return null;
        }
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
