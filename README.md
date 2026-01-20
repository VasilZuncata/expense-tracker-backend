# Expense Tracker Backend (Spring Boot)

## Описание
Този проект представлява **Spring Boot backend приложение** за управление на разходи (Expense Tracker).
Приложението предоставя **REST API**, чрез което могат да се създават потребители, разходи, категории и тагове,
както и да се управляват връзките между тях.

Проектът е разработен **само като backend**, без frontend, съгласно изискванията на курсовата задача.

---

## Архитектура
Проектът използва **слоеста архитектура**:

Controller → Service → Repository → Database

- **Controller** – REST endpoints
- **Service** – бизнес логика
- **Repository** – достъп до базата (Spring Data JPA)
- **DTO + Mapper** – разделяне на API моделите от entity-тата
- **Entity** – JPA модели (таблици)

---

## Използвани технологии
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 In-Memory Database
- Lombok
- Swagger (Springdoc OpenAPI)
- Maven

---

## База данни
Използва се **H2 In-Memory Database**.
Таблиците се създават автоматично от Hibernate при стартиране на приложението.

⚠️ Данните се изтриват при рестарт на приложението.

---

## Таблици (Entity-та)
Общо: **10 таблици**

- User
- Role
- user_roles (ManyToMany)
- Expense
- Category
- Tag
- expense_tags (ManyToMany)
- Budget
- Comment
- Payment

---

## Връзки между таблиците

### ManyToMany
- User ↔ Role
- Expense ↔ Tag

### ManyToOne
- Expense → User
- Expense → Category

---

## Бизнес логика
Проектът съдържа реална бизнес логика:
- Създаване на потребител
- Създаване на разход
- Създаване на таг
- Добавяне на таг към разход
  - ако тагът съществува → използва се
  - ако тагът не съществува → създава се автоматично
- Реално попълване на join таблиците

---

## Custom @Query заявки
В repository слоя са реализирани **няколко JPQL @Query заявки**, включително:
- Разходи по потребител
- Разходи по категория
- Разходи над определена сума
- Потребител по email

---

## Стартиране на проекта

### 1. Клониране
```bash
git clone <repository-url>
cd expense-tracker 

2. Стартиране
mvn spring-boot:run

При успешно стартиране:

Tomcat started on port(s): 8080

Достъп до приложението
Swagger UI (API тестове)
http://localhost:8080/swagger-ui/index.html

H2 Console (база данни)
http://localhost:8080/h2-console


Настройки:

JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (празно)

Примерни API заявки

Създаване на потребител
POST /users

{
  "username": "testuser",
  "email": "test@test.com",
  "password": "123456"
}

Създаване на таг
POST /tags

{
  "name": "food"
}

Добавяне на таг към разход
POST /tags/expense/{expenseId}?tagName=food

Проверка на ManyToMany връзката

В H2 Console:

SELECT * FROM EXPENSE_TAGS;


Разпределение на задачите

Васил Зунков – Users, Roles, DTO, Mapper

Тодор Траянов – Expenses, Categories

Любен Аратлъков – Tags, ManyToMany логика

Борислав Колев – Custom Queries, Tests, Документация






