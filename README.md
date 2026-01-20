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
