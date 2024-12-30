package dev.lancinater.cashGifts.Service;

import dev.lancinater.cashGifts.Model.CashGift;
import dev.lancinater.cashGifts.Repository.CashGiftRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashGiftService {


    private final CashGiftRepository cashGiftRepository;

    @Autowired
    public CashGiftService(CashGiftRepository cashGiftRepository) {
        this.cashGiftRepository = cashGiftRepository;
    }

    public List<CashGift> allCashGifts(){
        return cashGiftRepository.findAll();
    }
    public Optional<CashGift> getOneCashGift(ObjectId id){
        return cashGiftRepository.findById(id);
    }
    public CashGift saveCashGift (CashGift cashGift){
        return cashGiftRepository.save(cashGift);
    }
    public CashGift getCashGiftsByName(String name){
        return cashGiftRepository.findCashGiftByName(name);
    }

    public CashGift returnCashGift(String name) {
        CashGift cashGift = cashGiftRepository.findCashGiftByName(name);
        if(cashGift.getIsReturned().equals("✅")){
            cashGift.setIsReturned("❌");
        }else{
            cashGift.setIsReturned("✅");
        }
        return cashGiftRepository.save(cashGift);
    }

    public void deleteCashGift(CashGift cashGift) {
        cashGiftRepository.delete(cashGift);
        System.out.println("Cash Gift deleted");
    }
}
