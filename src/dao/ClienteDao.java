package dao;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    private static List<Cliente> clientes = new ArrayList<Cliente>();

    static {
        Cliente cliente = new Cliente();
        cliente.setNome("Guizao");
        cliente.setLogin("gui");
        cliente.setSenha("123");
        cliente.setTelefone("48-230923333");
        clientes.add(cliente);
    }

    public static List<Cliente> ObterClientes() {return clientes;}

}
