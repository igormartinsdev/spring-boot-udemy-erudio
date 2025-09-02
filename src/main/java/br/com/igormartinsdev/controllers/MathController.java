package br.com.igormartinsdev.controllers;

import br.com.igormartinsdev.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) + convertToDouble(numberTwo);

    }

    @RequestMapping("/subtract/{numberOne}/{numberTwo}")
    public Double subtract(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping("/multiply/{numberOne}/{numberTwo}")
    public Double multiply(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/divide/{numberOne}/{numberTwo}")
    public Double divide(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping("/squareRoot/{numberOne}/{numberTwo}")
    public Double squareRoot(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return 0D;
    }

    private boolean isNumeric(String strNumber){
        if(strNumber == null || strNumber.isEmpty())
            return false;

        String number = strNumber.replace(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double convertToDouble(String strNumber){
        String number = strNumber.replace(",", ".");

        return Double.parseDouble(number);
    }

}
