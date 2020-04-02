package com.grk.usuario.controller;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.primefaces.model.UploadedFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.grk.model.UsuarioModel;
import com.grk.repository.UsuarioRepository;
import com.grk.usuario.controller.UsuarioController;
import com.grk.uteis.Uteis;

@Named(value = "cadastrarUsuarioController")
@RequestScoped
public class CadastrarUsuarioController {

	@Inject
	UsuarioModel usuarioModel;

	@Inject
	UsuarioController usuarioController;

	@Inject
	UsuarioRepository usuarioRepository;

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}

	/**
	 * SALVA UM NOVO REGISTRO VIA INPUT
	 */
	public void SalvarNovoUsuario() {

		usuarioRepository.SalvarNovoRegistro(this.usuarioModel);

		this.usuarioModel = null;

		Uteis.MensagemInfo("Usuario cadastrado com sucesso");

	}

}