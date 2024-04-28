package dev.lancinater.cashGifts.Repository;

import dev.lancinater.cashGifts.Model.CashGiftUser;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<CashGiftUser, ObjectId> {
    Optional<CashGiftUser> findByUsername(String username);
}
