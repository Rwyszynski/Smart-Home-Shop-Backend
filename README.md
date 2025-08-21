

---

# README.md

````markdown
# 📦 SmartHomeShop

---

## 🖥️ Technologies Used

- **Java 17+**
- **Spring Boot**
- **Gradle**
- **Docker & Docker Compose**
- **PostgreSQL**
- **Flyway** (database migrations)
- External APIs:
  - Weather API
  - Currency API

---

## 🚀 Features

- Manage smart home products (CRUD operations)
- Handle user accounts
- Create and manage orders
- Checkout system (cart functionality)
- Weather API integration (fetch current weather and temperature)
- Currency API integration (for handling multi-currency prices)

---

## 📂 Project Structure

```text
SmartHomeShop/
├── base/
│   └── src/main/java/com/kodilla/smarthomeshop/
│       ├── controller/        # REST controllers (API endpoints)
│       ├── domain/            # Entities and DTOs
│       ├── component/         # External integrations (Weather, Currency)
│       ├── config/            # Application configuration
│       └── SmartHomeShopApplication.java
├── docker-compose.yml          # Docker setup
├── build.gradle / settings.gradle
└── gradlew / gradlew.bat       # Gradle wrappers
````

---

## 🛠️ Installation & Running

### Using Gradle

```bash
git clone https://github.com/your-username/SmartHomeShop.git
cd SmartHomeShop
./gradlew build
./gradlew bootRun
```

👉 App will be available at: `http://localhost:8080`

### Using Docker

```bash
docker-compose up --build
```

👉 App will be available at: `http://localhost:8080`

---

## 🌐 API Endpoints

### Products

| Method | Endpoint                | Description        |
| ------ | ----------------------- | ------------------ |
| GET    | `/products`             | Get all products   |
| GET    | `/products/{productId}` | Get product by ID  |
| POST   | `/products`             | Create new product |
| PUT    | `/products`             | Update product     |
| DELETE | `/products/{productId}` | Delete product     |

### Orders

| Method | Endpoint                        | Description                |
| ------ | ------------------------------- | -------------------------- |
| GET    | `/orders`                       | Get all orders             |
| GET    | `/orders/{orderId}`             | Get order by ID            |
| POST   | `/orders/fromCheckout/{userId}` | Create order from checkout |
| PUT    | `/orders`                       | Update order               |
| DELETE | `/orders/{orderId}`             | Delete order               |

### Checkout

| Method | Endpoint                            | Description                  |
| ------ | ----------------------------------- | ---------------------------- |
| GET    | `/checkout`                         | Get all checkouts            |
| GET    | `/checkout/{checkoutId}`            | Get checkout by ID           |
| POST   | `/checkout`                         | Create new checkout          |
| POST   | `/checkout/fromProduct/{productId}` | Create checkout from product |
| PUT    | `/checkout`                         | Update checkout              |
| DELETE | `/checkout/{checkoutId}`            | Delete checkout              |

### Users

| Method | Endpoint          | Description     |
| ------ | ----------------- | --------------- |
| GET    | `/users`          | Get all users   |
| GET    | `/users/{userId}` | Get user by ID  |
| POST   | `/users`          | Create new user |
| PUT    | `/users`          | Update user     |
| DELETE | `/users/{userId}` | Delete user     |

### Weather

| Method | Endpoint               | Description             |
| ------ | ---------------------- | ----------------------- |
| GET    | `/weather`             | Get current weather     |
| GET    | `/weather/temperature` | Get current temperature |

---

## 📌 Example Requests (cURL)

### 🔹 Products

```bash
# Get all products
curl -X GET http://localhost:8080/products

# Get product by ID
curl -X GET http://localhost:8080/products/1

# Create new product
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"name": "Smart Bulb", "price": 29.99, "description": "Wi-Fi LED bulb"}'

# Update product
curl -X PUT http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"id": 1, "name": "Smart Bulb v2", "price": 34.99}'

# Delete product
curl -X DELETE http://localhost:8080/products/1
```

### 🔹 Orders

```bash
# Get all orders
curl -X GET http://localhost:8080/orders

# Create order from checkout
curl -X POST http://localhost:8080/orders/fromCheckout/1
```

### 🔹 Checkout

```bash
# Get all checkouts
curl -X GET http://localhost:8080/checkout

# Create checkout from product
curl -X POST http://localhost:8080/checkout/fromProduct/1
```

### 🔹 Users

```bash
# Create user
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name": "Alice", "email": "alice@example.com"}'
```

### 🔹 Weather

```bash
# Get current weather
curl -X GET http://localhost:8080/weather

# Get temperature
curl -X GET http://localhost:8080/weather/temperature
```



```
