package reservationspringboot.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import reservationspringboot.enums.UserRole;
import reservationspringboot.model.User;
import reservationspringboot.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                getGrantedAuthorities(user.getRole())
        );
    }

    private List<GrantedAuthority> getGrantedAuthorities(UserRole role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        // Utilisation de la méthode `name()` pour obtenir le nom de l'énumération
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));
        return authorities;
    }
}