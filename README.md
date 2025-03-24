# Diagrama entidade-relacionamento

```mermaid
erDiagram
    CLIENTE ||--o{ EQUIPAMENTO : tem
    "PEDIDO DE MANUTENCÃO" }o..o{ EQUIPAMENTO : tem
```

# Diagrama de classes

```plantuml
@startuml

package model {

    class Cliente {
        - String idCliente
        - String nomeCompleto
        - String dataNascimento
        - String endereco
        - String telefone
    }

    class Equipamento {
        - String idEquipamento
        - String tipo
        - String serial
        - Cliente dono
    }

    class PedidoManutencao {
        - String idPedido
        - BigDecimal valorTotal
        - Map<String, BigDecimal> pecas
        - List<Equipamento> equipamentos
    }

    note right of PedidoManutencao::pecas
        O sistema não fará gestão de peças;
        Elas serão introduzidas como strings
        com valores monetários arbitrários
    end note

}

@enduml
```
