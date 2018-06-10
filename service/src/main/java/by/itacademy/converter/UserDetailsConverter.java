package by.itacademy.converter;

import by.itacademy.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsConverter {

    public org.springframework.security.core.userdetails.User.UserBuilder convert(User user) {
        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getName())
                .password(user.getPassword())
                .authorities(String.valueOf(user.getGymUserRole()));
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode("pass");
        System.out.println(pass);
    }
}
