# 📦 Sistema de Seguimiento de Paquetes (Tracking System)

Un microservicio RESTful desarrollado con Spring Boot y Arquitectura Hexagonal modular para gestionar el ciclo de vida (máquina de estados) y el seguimiento de envíos.

---

## 🚀 Tecnologías Clave

* **Lenguaje:** Java 24
* **Framework:** Spring Boot 3.x
* **Persistencia:** Spring Data JPA (Hibernate)
* **Base de Datos:** PostgreSQL
* **Arquitectura:** Hexagonal (Puertos y Adaptadores)
* **Herramientas:** Lombok, MapStruct (para mapeo de DTOs)

---

## 🛠️ Estructura del Proyecto

El proyecto está organizado según los principios de la Arquitectura Hexagonal:

* `co.com.quind.domain`: **Núcleo de la Aplicación. core del negocio** Contiene la lógica de negocio, las entidades inmutables, los *Value Objects*, Agregados, las excepciones de negocio y los Puertos (`PackagePersistencePort`).
* `co.com.quind.application`: **Capa de Aplicación.** Contiene los Casos de Uso (`*UseCase`) que orquestan las operaciones y los Mappers de DTO.
* `co.com.quind.infrastructure.driven.adapters`: **driven adapter (Adaptadores salida).** Contiene la implementación de los Puertos (ej. `PackagePersistenceAdapter`), las Entidades JPA y los Repositorios de Spring Data.
* `co.com.quind.infrastructure.entry-point`: **Capa de Presentación o (Adaptadores entrada).** Contiene los Controladores REST (`PackageController`) y los DTOs de entrada/salida.

---

## ⚙️ Configuración y Ejecución

### Requisitos Previos

* JDK 21+
* Maven 3.6+
* Instancia de PostgreSQL activa al usar docker compose, se genera una bd con las configuraciones por defecto. las tablas se generan automaticamente por JPA
