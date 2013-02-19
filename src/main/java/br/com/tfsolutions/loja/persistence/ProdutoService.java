package br.com.tfsolutions.loja.persistence;

import java.util.List;

import br.com.tfsolutions.loja.model.Produto;

public interface ProdutoService {
    
  public void adicionar(Produto produto);
  
  public void alterar(Produto produto);
  
  public void remover(Produto produto);
  
  public List<Produto> listar();
  
}
