# Diagrama entidade-relacionamento

```mermaid
erDiagram
    EQUIPAMENTO }o -- || DONO : tem
    "PEDIDO DE MANUTENCÃO" }o..|| EQUIPAMENTO : tem
    "PEDIDO DE MANUTENCÃO" }o..o{ ITEM : tem
```

# Diagrama de classes

```plantuml
@startuml

package model {

    class Owner {
        - String fullName
        - LocalDate birthDate
        - String address
        - String phone
    }

    class Equipment {
        - String type
        - String serialCode
        - Owner owner
    }

    class MaintenanceTicket {
        - List<Item> repairs
        - List<Item> parts
        - Equipment equipment
        - Status status
    }

    class Item {
        - String description
        - BigDecimal cost
    }

    MaintenanceTicket -- Item
    MaintenanceTicket -- Equipment
    Equipment -- Owner

}

@enduml
```
