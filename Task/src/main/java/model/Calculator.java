package model;

import javax.ejb.Stateless;
@Stateless
public class Calculator {
	
	public Calculator() {
		
	}
	
	 int number1;
	 int number2;
	 String operation;
	 //int result;
	
    public void setNumber1(int num1) {
    	this.number1= num1;
    }
    
    public void setNumber2(int num2) {
    	this.number2= num2;
    }
    
    public void setOperation(String symbol) {
    	this.operation= symbol;
    }
    

    public int getNum1() {
        return number1;
    }

    public int getNum2() {
        return number2;
    }

    public String getOperation() {
        return operation;
    }

}