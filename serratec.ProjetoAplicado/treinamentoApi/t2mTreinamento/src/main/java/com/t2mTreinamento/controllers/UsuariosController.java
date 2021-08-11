package com.t2mTreinamento.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t2mTreinamento.entities.Usuarios;
import com.t2mTreinamento.services.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuariosService usuariosService;

	@GetMapping("/history/{id}")
	public ResponseEntity<Usuarios> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(usuariosService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> findByIsAtivoAndIdUsuarios(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(usuariosService.findByIsAtivoAndIdUsuarios(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history")
	public ResponseEntity<List<Usuarios>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(usuariosService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Usuarios>> findByIsAtivo() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(usuariosService.findByIsAtivo(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long Count() {
		return usuariosService.Count();
	}

	@PostMapping
	public ResponseEntity<Usuarios> save(@Valid @RequestBody Usuarios usuario) {
		HttpHeaders headers = new HttpHeaders();

		Usuarios novoUsuario = usuariosService.save(usuario);

		if (novoUsuario != null) {
			return new ResponseEntity<>(novoUsuario, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novoUsuario, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Usuarios> delete(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean removidoDeUsuarios = usuariosService.delete(id);

		if (removidoDeUsuarios) {

			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuarios> update(@Valid @RequestBody Usuarios usuario, @PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		Usuarios usuarioAtualizado = usuariosService.update(usuario, id);

		if (usuarioAtualizado != null) {
			return new ResponseEntity<>(usuarioAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(usuarioAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{idUsuario}/lider/{idColab}")
	public ResponseEntity<Usuarios> insereColaborador(@PathVariable Long idUsuario, @PathVariable Long idColab) {
		HttpHeaders headers = new HttpHeaders();

		Usuarios usuarioAtualizado = usuariosService.insereColaborador(idUsuario, idColab);

		if (usuarioAtualizado != null) {
			return new ResponseEntity<>(usuarioAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(usuarioAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Usuarios> loginUsuario(@Valid @RequestBody Usuarios usuario) {
		HttpHeaders headers = new HttpHeaders();

		Usuarios usuarioVerificado = usuariosService.verificaLogin(usuario.getUsuario(), usuario.getSenha());

		if (usuarioVerificado != null) {
			return new ResponseEntity<>(usuarioVerificado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(usuarioVerificado, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
