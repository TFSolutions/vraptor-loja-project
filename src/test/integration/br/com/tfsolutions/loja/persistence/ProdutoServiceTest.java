package br.com.tfsolutions.loja.persistence;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.tfsolutions.loja.dbunit.DbUnitManager;
import br.com.tfsolutions.loja.model.Produto;
import br.com.tfsolutions.loja.persistence.ProdutoService;
import br.com.tfsolutions.util.ResourceLoader;
import static com.google.common.collect.Lists.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:applicationContext-persistenceTest.xml" })

@Transactional
public class ProdutoServiceTest {
  
  private static final String PRODUTO = "/datasets/Produto.xml";

  @Autowired
  private DbUnitManager manager;
  
  @Autowired
  private ProdutoService service;
  
  @Before public void
  setUp(){
    manager.cleanAndInsert(ResourceLoader.filePath(PRODUTO));
  }
  
  @Test public void
  quandoListar_entao_devoObterTodosOsProdutos(){
    assertEquals(newArrayList(caderno(), agenda(), caneta()), service.listar());
  }

  private Produto caneta() {
    Produto produto = new Produto();
    produto.setId(3L);    
    produto.setDescricao("caneta");
    produto.setValor(new BigDecimal("1.00"));
    return produto;
  }

  private Produto agenda() {
    Produto produto = new Produto();
    produto.setId(2L);    
    produto.setDescricao("agenda");
    produto.setValor(new BigDecimal("15.00"));
    return produto;
  }

  private Produto caderno() {
    Produto produto = new Produto();
    produto.setId(1L);    
    produto.setDescricao("caderno");
    produto.setValor(new BigDecimal("10.50"));
    return produto;
  }
  
}
