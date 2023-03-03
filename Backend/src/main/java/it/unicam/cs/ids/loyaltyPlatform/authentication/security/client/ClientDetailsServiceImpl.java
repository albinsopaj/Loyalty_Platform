package it.unicam.cs.ids.loyaltyPlatform.authentication.security.client;

import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientDetailsServiceImpl implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Client Not Found with username: " + username));

        return ClientDetailsImpl.build(client);
    }

}
