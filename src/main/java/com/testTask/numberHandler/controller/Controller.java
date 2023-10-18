package com.testTask.numberHandler.controller;

import com.testTask.numberHandler.models.NumberHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String showNumberHndler() {
        return  "calculator";
    }

    @PostMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestParam("numbers") String numbers, @RequestParam("operation") String operation) {
        try {
            NumberHandler.OperationType operationType = NumberHandler.OperationType.valueOf(operation.toUpperCase());
            double result = NumberHandler.calculate(numbers, operationType);
            return ResponseEntity.ok(Double.toString(result));
        } catch (IllegalArgumentException exp) {
            return ResponseEntity.badRequest().body("Error: " + exp.getMessage());
        }
    }


}
