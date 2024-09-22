package dev.lancinater.cashGifts.Service;

import dev.lancinater.cashGifts.Model.CashGiftUser;
import dev.lancinater.cashGifts.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

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
        String[] roles = cashGiftUser.getRoles().toArray(new String[0]);
        return new User(cashGiftUser.getUsername(),cashGiftUser.getPassword(), AuthorityUtils.createAuthorityList(roles));
    }

    public CashGiftUser registerNewUser(CashGiftUser cashGiftUser){

        if(userRepository.findByUsername(cashGiftUser.getUsername()).isPresent()){
            System.out.println("User already exists");
            throw new RuntimeException("User already exists");
        }
        String encodedPassword = passwordEncoder.encode(cashGiftUser.getPassword());
        cashGiftUser.setUsername(cashGiftUser.getUsername());
        cashGiftUser.setPassword(encodedPassword);
        cashGiftUser.setRoles(Set.of("ROLE_USER"));
        return userRepository.save(cashGiftUser);
    }

    public List<CashGiftUser> getAllUsers(){
        return userRepository.findAll();
    }
}
