package service;

import entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repositories.UserRepositories;
import security.WebSecurityConfig;


@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepositories userRepository;
    private WebSecurityConfig webSecurityConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRole()));
    }

   public entity.User findByUsername(String username) {

       return userRepository.findByUsername(username);
   }

    public void saveUser(User user) {
        userRepository.save(user);
    }
    public dto.User addUser(dto.User user) {
        User userEntity = new User();
        if (user.getUsername() != Character) {

        }
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userEntity.setRole("USER");
        userRepository.save(userEntity);
        return user;
    }
}
