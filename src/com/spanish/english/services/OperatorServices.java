package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.Operator;
import com.spanish.english.form.StatusOperator;

public interface OperatorServices {
	boolean addOrUpdateOperator(Operator operator);

	Set<Operator> getOperatorList();

	Operator getOperatorById(long operatorId);

	boolean deleteOperator(long operatorId);

	Operator getOperatorByUsername(String username);

	Operator getLastOperator();

	boolean addOrUpdateStatusOperator(StatusOperator statusMachine);

	Set<StatusOperator> getStatusOperator();

	boolean deleteStatusOperator(long Id);

	StatusOperator getStatusOperatorById(long id);
}
