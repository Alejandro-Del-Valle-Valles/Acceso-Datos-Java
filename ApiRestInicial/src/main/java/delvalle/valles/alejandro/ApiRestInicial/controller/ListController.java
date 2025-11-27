package delvalle.valles.alejandro.ApiRestInicial.controller;

import delvalle.valles.alejandro.ApiRestInicial.model.ReplaceDTO;
import delvalle.valles.alejandro.ApiRestInicial.repository.NumbersRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/numeros")
public class ListController {

    @GetMapping
    public List<Integer> getList(){
        return NumbersRepository.numbersList;
    }

    @PostMapping
    public ResponseEntity<?> addNumber(@RequestParam int number) {
        if(number <= 0) {
            return ResponseEntity.badRequest().body("Incorrecto");
        } else {
            NumbersRepository.numbersList.add(number);
            return ResponseEntity.ok(NumbersRepository.numbersList);
        }
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> getListOverNumber(@PathVariable int number) {
        if(number < 0) {
            return ResponseEntity.status(HttpStatusCode.valueOf(422)).body("Incorrecto");
        } else {
            return ResponseEntity.ok(NumbersRepository.numbersList
                    .stream().filter(n -> n >= number)
                    .toList());
        }
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity<?> getListBetweenNumber(@PathVariable int min, @PathVariable int max) {
        if(min > max) {
            return ResponseEntity.badRequest().body("El número mínimo debe ser superior al máximo.");
        } else {
            return ResponseEntity.ok(NumbersRepository.numbersList
                    .stream().filter(n -> n >= min && n <= max)
                    .toList());
        }
    }

    @PutMapping()
    public ResponseEntity<?> replaceValue(@RequestBody ReplaceDTO replaceDTO) {
        try {
            NumbersRepository.numbersList.set(replaceDTO.getIndex(), replaceDTO.getValue());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("El índice no existe.");
        }
        return ResponseEntity.ok(NumbersRepository.numbersList);
    }

    @DeleteMapping("/{number}")
    public List<Integer> deleteNumber(@PathVariable int number) {
        NumbersRepository.numbersList.removeIf(n -> n == number);
        return NumbersRepository.numbersList;
    }

    @GetMapping("/media")
    public float getMedia() {
        float total = Math.round(NumbersRepository.numbersList.stream().mapToInt(n -> n).average().orElse(0));
        if(total == 0) return 0;
        return total / NumbersRepository.numbersList.size();
    }
}
