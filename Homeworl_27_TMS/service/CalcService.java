package Homeworl_27_TMS.service;

import Homeworl_27_TMS.entity.Operation;

import Homeworl_27_TMS.storage.OperationStorage;

import java.util.List;

public class CalcService {

	private final OperationStorage operationStorage = new OperationStorage();

	public Operation calc(double a, double b, String operation) {
		switch (operation) {
			case "sum":
				Operation operation1 = new Operation(a, b, operation, a + b);
				operationStorage.save(operation1);
				return operation1;
			case "sub":
				Operation operation2 = new Operation(a, b, operation, a - b);
				operationStorage.save(operation2);
				return operation2;
			case "div":
				Operation operation3 = new Operation(a, b, operation, a - b);
				operationStorage.save(operation3);
				return operation3;
			case "mul":
				Operation operation4 = new Operation(a, b, operation, a - b);
				operationStorage.save(operation4);
				return operation4;
		}
		return null;
	}

	public List<Operation> findAll(){
		return operationStorage.getAll();
	}
}
