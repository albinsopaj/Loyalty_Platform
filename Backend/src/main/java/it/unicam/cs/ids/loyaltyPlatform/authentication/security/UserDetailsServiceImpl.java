package it.unicam.cs.ids.loyaltyPlatform.authentication.security;

import it.unicam.cs.ids.loyaltyPlatform.authentication.security.cashier.CashierDetailsImpl;
import it.unicam.cs.ids.loyaltyPlatform.authentication.security.client.ClientDetailsImpl;
import it.unicam.cs.ids.loyaltyPlatform.authentication.security.manager.ManagerDetailsImpl;
import it.unicam.cs.ids.loyaltyPlatform.authentication.security.owner.OwnerDetailsImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier.Cashier;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager.Manager;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AuthenticatedUserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthenticatedUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Client Not Found with username: " + username));
        if(user instanceof Client){
            return ClientDetailsImpl.build((Client) user);
        } else if(user instanceof Cashier) {
            return CashierDetailsImpl.build((Cashier) user);
        } else if(user instanceof Manager){
            return ManagerDetailsImpl.build((Manager) user);
        } else {
            return OwnerDetailsImpl.build((Owner) user);
        }
    }

}
