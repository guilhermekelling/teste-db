package com.grk.repository;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.grk.model.PessoaModel;
import com.grk.model.UsuarioModel;
import com.grk.repository.entity.UsuarioEntity;
import com.grk.uteis.Uteis;

public class UsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	UsuarioEntity usuarioEntity;
 
	EntityManager entityManager;
	
	
	/***
	 * M�TODO RESPONS�VEL POR SALVAR UM NOVO USU�RIO
	 * @param usuarioModel
	 */
	public void SalvarNovoRegistro(UsuarioModel usuarioModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		usuarioEntity = new UsuarioEntity();
		usuarioEntity.setUsuario(usuarioModel.getUsuario());
		usuarioEntity.setSenha(usuarioModel.getSenha());

		entityManager.persist(usuarioEntity);
 
	}
	
	

	public UsuarioEntity ValidaUsuario(UsuarioModel usuarioModel) {

		try {

			// QUERY QUE VAI SER EXECUTADA (UsuarioEntity.findUser)
			Query query = Uteis.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");

			// PAR�METROS DA QUERY
			query.setParameter("usuario", usuarioModel.getUsuario());
			query.setParameter("senha", usuarioModel.getSenha());

			// RETORNA O USU�RIO SE FOR LOCALIZADO
			return (UsuarioEntity) query.getSingleResult();

		} catch (Exception e) {

			return null;
		}

	}
}
