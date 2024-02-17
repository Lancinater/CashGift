package dev.lancinater.cashGifts;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashGiftService {

    @Autowired
    private CashGiftRepository cashGiftRepository;
    public List<CashGift> allCashGifts(){
        return cashGiftRepository.findAll();
    }
    public Optional<CashGift> getOneMovie(ObjectId id){
        return cashGiftRepository.findById(id);
    }
}
