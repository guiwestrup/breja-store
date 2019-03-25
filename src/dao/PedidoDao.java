package dao;

import model.Cliente;
import model.Pedido;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class PedidoDao {
    private static List<Pedido> pedidos = new ArrayList<Pedido>();

    static {
        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente());
        pedido.getProdutos().add(new Produto());
        pedido.setQuantidade(1);
        pedido.setValorTotal(10.00);
    }

    public static List<Pedido> ObterPedidos(){return pedidos;}

    public static void criarPedido(Pedido pedido){
        ProdutoDao.ObterProdutos().forEach(p -> {
            pedido.getProdutos().stream().filter(produto -> produto.getNome().equals(p.getNome())).forEach(pr -> {
                p.setQuantidade(pedido.getQuantidade() - pr.getQuantidade());
            });
        });
        pedidos.add(pedido);
    }
}