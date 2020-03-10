package br.com.compasso.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.apirest.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import br.com.compasso.apirest.models.Usuario;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Usuarios")
@CrossOrigin(origins = "*")
public class UsuarioResource {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/usuarios")
	@ApiOperation(value = "Retorna um usuário pelo nome.")
	public List<Usuario> listaUsuarios(String nome) {
		if(nome==null) {
		return usuarioRepository.findAll();
		}else {
			return usuarioRepository.findByNome(nome);
		}
	}


	@GetMapping("/usuario/{id}")
	@ApiOperation(value = "Retorna um usuário pelo seu id.")
	public Usuario listaUsuarios(@PathVariable(value = "id") long id) {
		return usuarioRepository.findById(id);
	}

	@PostMapping("/usuario")
	@ApiOperation(value = "Salva um usuário.")
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

//	@DeleteMapping("/usuario")
//	@ApiOperation(value = "Deleta um usuário passando seu body inteiro.")
//	public void deletaUsuario(@RequestBody Usuario usuario) {
//		usuarioRepository.delete(usuario);
//	}

	@DeleteMapping("/usuario/{id}")
	@ApiOperation(value = "Deleta um usuário pelo seu id.")
	public void deletaUsuarioComId(@PathVariable(value = "id") long id) {
		usuarioRepository.deleteById(id);
	}

	@PutMapping("/usuario")
	@ApiOperation(value = "Atualiza um usuário.")
	public void atualizaUsuario(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);
	}

}
