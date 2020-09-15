package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;

@RestController
public class MathController {
	   
    @RequestMapping(value="/sum/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne , @PathVariable("numberTwo") String numberTwo ) throws Exception {
    	return soma(numberOne,numberTwo);
    }
    
    @RequestMapping(value="/sub/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne , @PathVariable("numberTwo") String numberTwo ) throws Exception {
    	return subtracao(numberOne,numberTwo);
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne , @PathVariable("numberTwo") String numberTwo ) throws Exception {
    	return divisao(numberOne,numberTwo);
    }
    
    @RequestMapping(value="/mult/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne , @PathVariable("numberTwo") String numberTwo ) throws Exception {
    	return multiplicacao(numberOne,numberTwo);
    }
    
    @RequestMapping(value="/med/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double med(@PathVariable("numberOne") String numberOne , @PathVariable("numberTwo") String numberTwo ) throws Exception {
    	return media(numberOne,numberTwo);
    }
    
    @RequestMapping(value="/raiz/{numberOne}",method=RequestMethod.GET)
    public Double raiz(@PathVariable("numberOne") String numberOne) throws Exception {
    	return raizQuadrada(numberOne);
    }
    
	private Double convertToDouble(String strNumber) {
		if(strNumber==null) return 0D;
		
		String number= strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber==null) return false;
		
		String number= strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	private Double soma(String n1,String n2) {
		if(!isNumeric(n1) || !isNumeric(n2)) {
    		throw new UnsuportedMathOperationException("Please set a numeric value");
    	}
    	return convertToDouble(n1) + convertToDouble(n2);
	}
	
	private Double subtracao(String n1,String n2) {
		if(!isNumeric(n1) || !isNumeric(n2)) {
    		throw new UnsuportedMathOperationException("Please set a numeric value");
    	}
    	return convertToDouble(n1) - convertToDouble(n2);
	}
	
	private Double multiplicacao(String n1,String n2) {
		if(!isNumeric(n1) || !isNumeric(n2)) {
    		throw new UnsuportedMathOperationException("Please set a numeric value");
    	}
    	return convertToDouble(n1) * convertToDouble(n2);
	}
	
	private Double divisao(String n1,String n2) {
		if(!isNumeric(n1) || !isNumeric(n2)) {
    		throw new UnsuportedMathOperationException("Please set a numeric value");
    	}
    	return convertToDouble(n1) / convertToDouble(n2);
	}
	
	private Double media(String n1,String n2) {
		if(!isNumeric(n1) || !isNumeric(n2)) {
    		throw new UnsuportedMathOperationException("Please set a numeric value");
    	}
    	return (convertToDouble(n1) + convertToDouble(n2)) /2;
	}
	
	private Double raizQuadrada(String n) {
		if(!isNumeric(n)) {
    		throw new UnsuportedMathOperationException("Please set a numeric value");
    	}
    	return Math.sqrt(convertToDouble(n));
	}
	
}
