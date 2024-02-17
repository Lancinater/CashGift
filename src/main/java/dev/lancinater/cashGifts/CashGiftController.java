package dev.lancinater.cashGifts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cashGifts")
public class CashGiftController {

    @Autowired
    private CashGiftService cashGiftService;

    @GetMapping
    public ResponseEntity<List<CashGift>> getAllCashGifts(){
        return new ResponseEntity<List<CashGift>>(cashGiftService.allCashGifts(),HttpStatus.OK);
    }
}
