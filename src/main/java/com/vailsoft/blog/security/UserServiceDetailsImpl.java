package com.vailsoft.blog.security;

import com.vailsoft.blog.model.Usuario;
import com.vailsoft.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<Usuario> user = userRepository.findByUsuario(username);
        user.orElseThrow(() -> new UsernameNotFoundException(username + "not found."));

        return user.map(UserDetailsImpl::new).get();

    }

}
