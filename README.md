
## Diagrama UML e Implementação da Classe "Pagamento"

### 1. Diagrama UML para a classe Pagamento

```
+---------------------------------------------------+
|                     Pagamento                     |
+---------------------------------------------------+
| - id: Long                                        |
| - pedidoId: Long                                  |
| - formaPagamento: String                          |
| - valorPago: double                               |
| - dataHoraPagamento: LocalDateTime                |
+---------------------------------------------------+
| + validarPagamento(valorPagoiTotal: double): void |
+---------------------------------------------------+
```
### Modo mermaid
````
---
NomeClasse: Pagamento
---
classDiagram
    class Pagamento
    Pagamento : -Long id
    Pagamento : -Long pedidoId
    Pagamento : -String formaPagamento
    Pagamento : -double valorPago  
    Pagamento : -LocalDateTime dataHoraPagamento
    Pagamento : +double validarPagamento(valorPagoTotal)
````
