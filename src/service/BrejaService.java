package service;

import dao.ClienteDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import model.Cliente;
import model.Pedido;
import model.Produto;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class BrejaService {

    public List<Produto> listar(){
        return ProdutoDao.ObterProdutos();
    }

    public List<Cliente> listaCliente(){ return ClienteDao.ObterClientes();}

    public void criarPedido(@WebParam(name="pedido") Pedido pedido,
        @WebParam(name="cliente", header=true) Cliente cliente) throws UsuarioNaoAutenticadoException {
        boolean check = false;
        for(Cliente c : ClienteDao.ObterClientes()){
            if(c.getLogin().equals(cliente.getLogin()) && c.getSenha().equals(cliente.getSenha())){
                PedidoDao.criarPedido(pedido);
                check = true;
                break;
            }
        }
        if(!check){
            throw new UsuarioNaoAutenticadoException();
        }

    }
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8181/brejas", new BrejaService());
        System.out.println(" serviço iniciado.");
    }
}
