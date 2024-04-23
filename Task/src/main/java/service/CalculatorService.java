package service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Calculator;

@Stateless
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculatorService {
	
	private List<Calculator> calculations = new ArrayList<>();
	
	@POST
	@Path("/calc")
	public String calculation(Calculator calc) {
		int number1 = calc.getNum1();
		int number2 = calc.getNum2();
		String operation = calc.getOperation();
		double result;
		calculations.add(calc);
		switch (operation) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
            	if (number2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                result =(double) number1 / number2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operation, try another valid one");
		}
		
//		calc.setnum1(number1);
//		calc.setnum2(number2);
//		calc.setOp(operation);
//		calc.setRes(result);
//		
		
		
		return "Result: " + result;
	}
	
	@GET
	@Path("/calculations")
	public List<Calculator> getAllCalculations() {
		return calculations;
	}
}
