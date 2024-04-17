package dev.lancinater.cashGifts.Repository;

import dev.lancinater.cashGifts.Model.CashGift;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashGiftRepository extends MongoRepository<CashGift, ObjectId> {

}
