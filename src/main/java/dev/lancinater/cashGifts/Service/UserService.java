package dev.lancinater.cashGifts.Service;

import dev.lancinater.cashGifts.Model.CashGiftUser;
import dev.lancinater.cashGifts.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CashGiftUser cashGiftUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: "+ username));
        return new User(cashGiftUser.getUsername(),cashGiftUser.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }

    public CashGiftUser registerNewUser(CashGiftUser cashGiftUser){
        String encodedPassword = passwordEncoder.encode(cashGiftUser.getPassword());
        cashGiftUser.setUsername(cashGiftUser.getUsername());
        cashGiftUser.setPassword(encodedPassword);
        return userRepository.save(cashGiftUser);
    }

    public List<CashGiftUser> getAllUsers(){
        return userRepository.findAll();
    }
}
