package dev.lancinater.cashGifts;

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

    @Autowired
    private CashGiftService cashGiftService;

    @GetMapping
    public ResponseEntity<List<CashGift>> getAllCashGifts(){
        return new ResponseEntity<List<CashGift>>(cashGiftService.allCashGifts(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CashGift>> getCashGiftById(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<CashGift>>(cashGiftService.getOneMovie(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CashGift> addCashGift(@RequestBody CashGift cashGift) {
        CashGift savedCashGift = cashGiftService.saveCashGift(cashGift);
        return new ResponseEntity<>(savedCashGift, HttpStatus.CREATED);
    }
}
