package com.enlopes.curso.boot.web.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.enlopes.curso.boot.domain.Funcionario;

public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> classe) {
		
		return Funcionario.class.equals(classe);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Funcionario f = (Funcionario) object;
		
		LocalDate entrada = f.getDataEntrada();
		
		if (f.getDataSaida() != null) {
			if (f.getDataSaida().isBefore(entrada)) {
				errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
			}
		}
	}

}
