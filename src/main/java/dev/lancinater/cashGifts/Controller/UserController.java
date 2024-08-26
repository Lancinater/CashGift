package dev.lancinater.cashGifts.Controller;

import dev.lancinater.cashGifts.Model.CashGift;
import dev.lancinater.cashGifts.Model.CashGiftUser;
import dev.lancinater.cashGifts.Service.CashGiftService;
import dev.lancinater.cashGifts.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/cashGifts")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<CashGiftUser>> getAllUser(){
        return new ResponseEntity<List<CashGiftUser>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<CashGiftUser> registerUser(@RequestBody CashGiftUser cashGiftUser){
        CashGiftUser newUser = userService.registerNewUser(cashGiftUser);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

//    @GetMapping("/login")
//    public ResponseEntity<String> loginUser(){
//        return new ResponseEntity<>("Login successful!", HttpStatus.OK);
//    }
}
