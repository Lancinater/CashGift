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
@RequestMapping("/api/v1/cashGifts")
public class CashGiftController {


    private final CashGiftService cashGiftService;
    private final UserService userService;

    @Autowired
    public CashGiftController(CashGiftService cashGiftService, UserService userService) {
        this.cashGiftService = cashGiftService;
        this.userService = userService;
    }

    @GetMapping 
    public ResponseEntity<List<CashGift>> getAllCashGifts(){
        return new ResponseEntity<List<CashGift>>(cashGiftService.allCashGifts(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CashGift>> getCashGiftById(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<CashGift>>(cashGiftService.getOneCashGift(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CashGift> addCashGift(@RequestBody CashGift cashGift) {
        CashGift savedCashGift = cashGiftService.saveCashGift(cashGift);
        return new ResponseEntity<>(savedCashGift, HttpStatus.CREATED);
    }


}
