package dev.lancinater.cashGifts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashGiftService {

    @Autowired
    private CashGiftRepository cashGiftRepository;
    public List<CashGift> allCashGifts(){
        return cashGiftRepository.findAll();
    }
}
