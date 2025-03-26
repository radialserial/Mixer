# Diagrama entidade-relacionamento

```mermaid
erDiagram
    EQUIPAMENTO }o -- || DONO : tem
    "PEDIDO DE MANUTENCÃO" }o..|| EQUIPAMENTO : tem
    "PEDIDO DE MANUTENCÃO" }o..o{ "REPAROS" : tem
    "PEDIDO DE MANUTENCÃO" }o..o{ "PARTES" : tem
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
        - List<Repair> repairs
        - List<Part> parts
        - Equipment equipment
        - Status status
    }

    abstract class MaintenanceItem {
        - String description
        - BigDecimal cost
    }

    class Part extends MaintenanceItem { }

    class Repair extends MaintenanceItem { }

    MaintenanceTicket -- Part
    MaintenanceTicket -- Repair
    MaintenanceTicket -- Equipment
    Equipment -- Owner

}

@enduml
```
