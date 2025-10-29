package br.senac.tads.dsw.dadospessoais.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioSistemaService implements UserDetailsService {

    private Map<String, UsuarioSistema> mapUsuarios;

    public UsuarioSistemaService() {
        mapUsuarios = new HashMap<>();
        mapUsuarios.put("fulano", new UsuarioSistema("fulano", 
            "Fulano da Silva", "{noop}Abcd%1234",
            List.of(new Permissao("PEAO"))));
        mapUsuarios.put("ciclano", new UsuarioSistema("ciclano",
            "Ciclano de Souza", "{noop}Abcd%1234",
            List.of(new Permissao("CHEFE"))));
    }    

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UsuarioSistema usuario = mapUsuarios.get(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário %s não encontrado".formatted(username));
        }
        return usuario;
    }

}
