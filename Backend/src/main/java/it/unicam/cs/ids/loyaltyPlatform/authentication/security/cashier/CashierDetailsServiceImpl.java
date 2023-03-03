package it.unicam.cs.ids.loyaltyPlatform.authentication.security.cashier;

import it.unicam.cs.ids.loyaltyPlatform.authentication.security.client.ClientDetailsImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier.Cashier;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier.CashierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CashierDetailsServiceImpl implements UserDetailsService {
    @Autowired
    CashierRepository cashierRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cashier cashier = cashierRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Cashier Not Found with username: " + username));

        return CashierDetailsImpl.build(cashier);
    }

}
