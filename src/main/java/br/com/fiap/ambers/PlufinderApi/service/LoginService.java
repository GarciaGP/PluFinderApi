package br.com.fiap.ambers.PlufinderApi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.ambers.PlufinderApi.entity.Login;
import br.com.fiap.ambers.PlufinderApi.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repository;
	
	@Autowired
	private TokenService tokenService;
	
	public void incluirLogin(Login login) {
		
		login.setSenha(AuthenticationService.getPasswordEnconder().encode(login.getSenha()));
		
		this.repository.save(login);
	}
	
	public Optional<Login> buscarPorId(Long id) {
		return this.repository.findById(id);
	}
	
	public Optional<Login> verificaLogin(String email) {
		return this.repository.findByEmail(email);
	}

}
