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
        - Long idCliente
        - String nomeCompleto
        - LocalDate dataNascimento
        - String endereco
        - String telefone
    }

    class Equipamento {
        - Long idEquipamento
        - String tipo
        - String serial
        - Cliente dono
    }

    class PedidoManutencao {
        - Long idPedido
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
