# Expense Tracker – Backend Documentation

## 1. Общо описание на проекта

Проектът **Expense Tracker** представлява **Spring Boot backend приложение**, което позволява управление на потребители, роли, разходи и бюджети. Системата е изградена като **REST API**, без frontend, и предоставя автоматично генерирана документация чрез **Swagger (OpenAPI)**.

Основната цел на проекта е:
- демонстрация на работа със Spring Boot
- използване на релации между обекти (JPA)
- прилагане на бизнес логика с транзакции
- работа в екип от 4-ма души с ясно разпределени отговорности

---

## 2. Използвани технологии

- Java 17
- Spring Boot
- Spring Web (REST Controllers)
- Spring Data JPA
- H2 Database (in-memory)
- Lombok
- Swagger / OpenAPI (springdoc-openapi)
- Maven
- JUnit (Unit tests)

---

## 3. Архитектура на проекта

Проектът следва **слоеста архитектура**, разделена на отделни логически слоеве:

- **Controller layer** – REST endpoints
- **Service layer** – бизнес логика
- **Repository layer** – достъп до база данни
- **Entity layer** – JPA entity класове
- **DTO + Mapper layer** – трансфер и преобразуване на данни

### Package структура:
```
com.example.expensetracker
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── mapper
 ├── config
 └── exception
```

---

## 4. Entity модели и връзки

### Основни Entities:
- User
- Role
- Expense
- Category
- Tag
- Wallet
- Budget
- Transaction
- AuditLog

### Връзки между entity-та:

#### ManyToMany:
- User ↔ Role
- Expense ↔ Tag

#### ManyToOne:
- Expense → User
- Expense → Category

#### OneToOne:
- User → Wallet
- User → Budget

Тези релации покриват напълно изискванията по задание за 4-ма души.

---

## 5. REST API и Swagger

Проектът използва **Swagger (OpenAPI)** за автоматично генериране на API документация.

Swagger UI е достъпен на адрес:
```
http://localhost:8080/swagger-ui/index.html
```

Swagger предоставя:
- визуализация на всички REST endpoints
- описание на request и response модели
- възможност за тестване на API без frontend

---

## 6. Бизнес логика и транзакции

Ключов компонент на системата е бизнес логиката при добавяне на разходи.

### Проблем:
Какво се случва, ако двама потребители едновременно добавят разход, който надвишава бюджета?

### Решение:
- използване на `@Transactional`
- проверка за наличен бюджет
- хвърляне на custom exception при надвишаване
- по избор: optimistic locking чрез `@Version`

Този подход предотвратява race conditions и осигурява консистентност на данните.

---

## 7. DTO и Mapper слой

Проектът използва DTO-та за:
- входни данни (request)
- изходни данни (response)

Mapper слой преобразува Entity ↔ DTO, което:
- подобрява сигурността
- намалява зависимостите между слоевете
- улеснява бъдещо разширяване на проекта

---

## 8. Тестване

Реализирани са unit тестове за:
- Repository слой
- Service слой

Тестовете валидират:
- коректност на бизнес логиката
- правилна работа с базата данни

---

## 9. Работа в екип

Проектът е разработен от екип от **4-ма души**, с ясно разпределени задачи:

| Член | Отговорности |
|------|--------------|
| Васил Зунков | User, Role, Swagger, DataSeeder |
| Тодор Траянов | Expense, Category, Tag, @Query |
| Любен Аратлъков | Wallet, Budget, Transaction logic |
| Борислав Колев | DTO, Mapper, Tests |

---

## 10. Заключение

Проектът **Expense Tracker** покрива всички изисквания по задание:
- сложни entity релации
- транзакционна бизнес логика
- слоеста архитектура
- Swagger документация
- екипна разработка

Приложението представлява стабилна основа за бъдещо разширяване с frontend или външни API услуги.

