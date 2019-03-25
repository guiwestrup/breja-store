package dao;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    private static List<Produto> produtos = new ArrayList<Produto>();

    static {
        Produto produto = new Produto();
        produto.setNome("Corona");
        produto.setDescricao("La Cerveza Mas Fina");
        produto.setUN("ML");
        produto.setVolume(350);
        produto.setPreco(5.50);
        produto.setQuantidade(10);
        produtos.add(produto);
    }

    public static List<Produto> ObterProdutos(){
        return produtos;
    }
}
