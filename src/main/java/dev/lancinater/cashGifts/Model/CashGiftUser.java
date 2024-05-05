package dev.lancinater.cashGifts.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashGiftUser {
    @Id
    private ObjectId id;
    private String username;
    private String password;
    private List<CashGift> cashGifts;
    private Set<Role> roles;
}
