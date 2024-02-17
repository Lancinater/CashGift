package dev.lancinater.cashGifts;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashGiftRepository extends MongoRepository<CashGift, ObjectId> {

}
