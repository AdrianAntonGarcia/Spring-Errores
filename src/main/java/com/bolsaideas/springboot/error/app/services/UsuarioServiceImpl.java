package com.bolsaideas.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsaideas.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	private List<Usuario> lista;

	public UsuarioServiceImpl() {
		this.lista = new ArrayList<Usuario>();
		this.lista.add(new Usuario(1, "Adrián", "Antón"));
		this.lista.add(new Usuario(2, "Ana", "Romeu"));
		this.lista.add(new Usuario(3, "Pedro", "Guzmán"));
		this.lista.add(new Usuario(4, "Juana", "Beltraneja"));
		this.lista.add(new Usuario(5, "Isabel", "Católica"));
		this.lista.add(new Usuario(6, "Fernando", "Católico"));
		this.lista.add(new Usuario(7, "Pepe", "Eras"));
	}

	@Override
	public List<Usuario> listar() {
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;
		for (Usuario usuario : this.lista) {
			if (id.equals(usuario.getId())) {
				resultado = usuario;
				break;
			}
		}
		return resultado;
	}

}
