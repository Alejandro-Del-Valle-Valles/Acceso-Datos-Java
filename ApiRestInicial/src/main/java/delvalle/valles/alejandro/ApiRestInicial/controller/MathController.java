package delvalle.valles.alejandro.ApiRestInicial.controller;

import delvalle.valles.alejandro.ApiRestInicial.model.ProductDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mates")
public class MathController {

    @GetMapping("/{number}")
    public String getMultiplicationTable(@PathVariable int number) {
        StringBuilder result = new StringBuilder();
        for(byte i = 1; i < 11; i ++) {
            result.append(String.format("%d X %d = %d\n", i, number, i * number));
        }
        return result.toString();
    }

    @GetMapping
    public String getPartialMultiplicationTable(@RequestParam int number, @RequestParam int multiplier) {
        StringBuilder result = new StringBuilder();
        for(int i = 1; i < multiplier + 1; i ++) {
            result.append(String.format("%d X %d = %d\n", i, number, i * number));
        }
        return result.toString();
    }

    @GetMapping("/producto")
    public String getMultiplicationByJson(@RequestBody ProductDTO product) {
        return product.getNumberOne() + " X " +  product.getNumberTwo() + " = "
                + (product.getNumberOne() *  product.getNumberTwo());
    }

    @GetMapping("/producto/{numberOne}/{numberTwo}")
    public String getMultiplication(@PathVariable int numberOne, @PathVariable  int numberTwo) {
        return numberOne + " X " + numberTwo + " = " +  (numberOne * numberTwo);
    }
}
