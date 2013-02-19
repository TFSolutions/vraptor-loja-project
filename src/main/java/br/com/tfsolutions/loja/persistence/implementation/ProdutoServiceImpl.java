package br.com.tfsolutions.loja.persistence.implementation;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.tfsolutions.loja.model.Produto;
import br.com.tfsolutions.loja.persistence.ProdutoService;

@Component
@Transactional
public class ProdutoServiceImpl implements ProdutoService{
  
  @PersistenceContext
  private EntityManager entityManager;

  public void adicionar(Produto produto) {
    entityManager.persist(produto);
  }

  public void alterar(Produto produto) {
    entityManager.merge(produto);
  }

  public void remover(Produto produto) {
    entityManager.remove(entityManager.find(Produto.class, produto.getId()));
  }
  
  @SuppressWarnings("unchecked")
  public List<Produto> listar(){
    Session sessao = (Session) entityManager.getDelegate();
    return sessao.createCriteria(Produto.class).list();
  }
  
}
