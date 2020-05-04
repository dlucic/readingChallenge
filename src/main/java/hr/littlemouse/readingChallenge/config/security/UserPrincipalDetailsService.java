package hr.littlemouse.readingChallenge.config.security;

import hr.littlemouse.readingChallenge.data.entity.User;
import hr.littlemouse.readingChallenge.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserPrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(this::toUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("Wrong login"));
    }

    private UserDetails toUserDetails(User user) {
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getUserRoles().stream().map(Enum::name).toArray(String[]::new))
                .build();
    }
}
