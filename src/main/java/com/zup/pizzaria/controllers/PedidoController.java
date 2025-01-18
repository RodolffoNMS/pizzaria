package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController//Indica que essa é uma classe RESTController
/*
* Padrão REST: Não mantém o estado da requisição, mantém o estado do cliente.
* Podemos ter:
* STATELESS = REST, ou seja, a cada nova requisição, recebe todas as inf. que precisa para fazer a requisição.
* STATEFULL = Mantém dentro dela, o estado de cada cliente é mantido no servidor.
* Combina duas anotações:
* @Controller----> Em Controller ele não precisa retornar uma JASON ou XML. Antes ela retornava uma View.(Back e Front Juntos)
* @ResponseBody-->
*/

@RequestMapping("/pedidos")
/*
* É uma notation "diferente" pois ela recebe um parâmetro
* Além de adicionar configuração de mapeamento de um request, o parâmetro diz: "Qual request" queremos mapear.
* Esse controller "escuta" todas as requisições que chegarem no endpoint /pedidos.
*
* !!!!Isso significa que esse Controller é um RESTController(REST = STATELESS), que "escuta" todas as requisições que chegam no endpois /pedidos.
*/

public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
    //post, get, delete, put, patch, options, head
    @PostMapping
    /*
    * Esse metodo aqui, "responde" as requisições POST
    * POST/pedido
    * Caso queira, posso adicionar um parâmetro na notation.
    * Ou seja:
    * @PostMapping pode receber um parâmetro.
    * @PostMapping("/post")
    * Assim o metodo abbaixo responderia "/pedidos/post"
    */

    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody Pedido pedido) {
        PedidoDTO pedidoDTO = pedidoService.criarPedido(pedido);
        return ResponseEntity.ok(pedidoDTO);
    }

}

