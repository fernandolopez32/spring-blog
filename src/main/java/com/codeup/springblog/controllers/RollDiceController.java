package com.codeup.springblog.controllers;

// CONTROLLER
import com.codeup.springblog.models.Dice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roll-dice")
public class RollDiceController {

    @GetMapping
    public String welcome(){
        return "roll-dice";
    }

    @GetMapping("/{number}")
    @ResponseBody
    public String guess(@PathVariable int number, Model model) {
        Dice dice = new Dice();
//        instance of model

//        generate random number with method from model
        int randNum = dice.roll();

        model.addAttribute("select", dice);


        if (randNum == number) {
            return "YOU WON!!!";
        } else {
            return "You lost, the number to guess was: " + randNum;
        }
    }
}
