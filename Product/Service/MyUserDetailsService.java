//package Product.Service;
//
//import Product.Entity.Users;
//import Product.Repository.UserRepository;
//import Product.Security.UserPrinciple;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public Users createUser (Users users){
//        users.setPassword(new BCryptPasswordEncoder(12).encode(users.getPassword()));
//        return userRepository.save(users);
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Users> user = userRepository.findByUsername(username);
//        if(user.isEmpty()) throw new UsernameNotFoundException("User not found!");
//        return new UserPrinciple(user.get());
//    }
//}
