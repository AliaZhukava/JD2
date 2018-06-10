package by.itacademy.service;

import by.itacademy.converter.UserDetailsConverter;
import by.itacademy.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final ClientRepository clientRepository;
    private final UserDetailsConverter detailsConverter;

    @Autowired
    public UserServiceImpl(ClientRepository clientRepository, UserDetailsConverter detailsConverter) {
        this.clientRepository = clientRepository;
        this.detailsConverter = detailsConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) Optional.of(name)
                .map(clientRepository::findByName)
                .map(detailsConverter::convert)
                .orElseThrow(() -> new UsernameNotFoundException("User does not exist!"));
    }
}
