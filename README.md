# 📦 SmartHomeShop

SmartHomeShop to aplikacja e-commerce do obsługi **inteligentnych urządzeń domowych**.  
Pozwala zarządzać produktami, użytkownikami, zamówieniami i koszykiem zakupowym, a także integruje się z zewnętrznymi API (pogoda, waluty).

---

## 🖥️ Technologie

- **Java 17+**
- **Spring Boot**
- **Gradle**
- **Docker & Docker Compose**
- **PostgreSQL**
- **Flyway** (migracje bazy danych)
- **Lombok**
- **Testcontainers + JUnit 5 + MockMvc** (testy)
- Zewnętrzne API:
    - **Weather API** 🌤️
    - **Currency API** 💱

---

## 🚀 Funkcjonalności

- Zarządzanie produktami (CRUD)
- Obsługa użytkowników
- Koszyk zakupowy + składanie zamówień
- Integracja z pogodą i przelicznikiem walut
- Obsługa wielu walut przy zakupach
- Automatyczne migracje DB (Flyway)
- Testy jednostkowe i integracyjne

---

## 📂 Struktura projektu

```text
SmartHomeShop/
├── base/
│   └── src/main/java/com/kodilla/smarthomeshop/
│       ├── controller/        # REST API
│       ├── domain/            # Encje i DTO
│       ├── component/         # Integracje z API zewnętrznymi
│       ├── config/            # Konfiguracja aplikacji
│       └── SmartHomeShopApplication.java
├── src/test/java/              # Testy JUnit / MockMvc / Testcontainers
├── docker-compose.yml          # Konfiguracja Dockera
├── build.gradle / settings.gradle
└── gradlew / gradlew.bat
```

---

## ⚙️ Konfiguracja środowiska

Aplikacja korzysta z **plików konfiguracyjnych Spring Boot** (`application.yml`).

Możesz też stworzyć plik `.env` dla Dockera:

```env
POSTGRES_DB=smarthomeshop
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/smarthomeshop
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
WEATHER_API_KEY=your_api_key_here
CURRENCY_API_KEY=your_api_key_here
```

---

## 🛠️ Instalacja i uruchomienie

### 🔹 Gradle

```bash
git clone https://github.com/your-username/SmartHomeShop.git
cd SmartHomeShop
./gradlew build
./gradlew bootRun
```

👉 Aplikacja dostępna pod: `http://localhost:8080`

### 🔹 Docker

```bash
docker-compose up --build
```

👉 Aplikacja dostępna pod: `http://localhost:8080`

---

## 🌐 API – pełna lista endpointów

> **Prefiksy ścieżek**: większość zasobów działa pod **`/v1/*`**, natomiast usługa pogody pod **`/api/weather`**.  
> **Paginacja** (tam gdzie dostępna): parametry `page`, `size`, `sort` (Spring Pageable).

### 🧩 Produkty (`/v1/products`)

| Metoda | Ścieżka                               | Opis |
|-------:|---------------------------------------|------|
| GET    | `/v1/products`                        | Pobierz listę produktów (paginacja) |
| GET    | `/v1/products/{productId}`            | Pobierz produkt po ID |
| POST   | `/v1/products`                        | Utwórz nowy produkt |
| PUT    | `/v1/products`                        | Zaktualizuj produkt |
| DELETE | `/v1/products/{productId}`            | Usuń produkt |
| GET    | `/v1/products/{type}`                 | Pobierz produkty po **typie** |
| GET    | `/v1/products/{name}`                 | Pobierz produkty po **nazwie** |

> ℹ️ **Uwaga:** dwa ostatnie endpointy mają taki sam wzorzec ścieżki (`/{...}`) jak pobieranie po ID – może to powodować niejednoznaczność rozwiązywaną kolejnością metod w kontrolerze.

### 🧾 Zamówienia (`/v1/orders`)

| Metoda | Ścieżka                               | Opis |
|-------:|---------------------------------------|------|
| GET    | `/v1/orders`                          | Pobierz listę zamówień (paginacja) |
| GET    | `/v1/orders/{orderId}`                | Pobierz zamówienie po ID |
| POST   | `/v1/orders/fromCheckout/{userId}`    | Utwórz zamówienie z koszyka użytkownika |
| PUT    | `/v1/orders`                          | Zaktualizuj zamówienie |
| DELETE | `/v1/orders/{orderId}`                | Usuń zamówienie |
| GET    | `/v1/orders/{id}`                     | Pobierz **zamówienia użytkownika** po jego ID |

> ℹ️ **Uwaga:** ostatni endpoint (`/{id}`) koliduje wzorcem z `/{orderId}` – to również może być niejednoznaczne w rutingu.

### 🛒 Koszyki / Checkouts (`/v1/checkouts`)

| Metoda | Ścieżka                                      | Opis |
|-------:|----------------------------------------------|------|
| GET    | `/v1/checkouts`                              | Pobierz listę koszyków (paginacja) |
| GET    | `/v1/checkouts/{checkoutId}`                 | Pobierz koszyk po ID |
| GET    | `/v1/checkouts/ordered?ordered=true|false`   | Pobierz koszyki po statusie „zamówiony” |
| POST   | `/v1/checkouts`                              | Utwórz nowy koszyk |
| POST   | `/v1/checkouts/fromProduct/{productId}`      | Utwórz koszyk na podstawie produktu |
| PUT    | `/v1/checkouts`                              | Zaktualizuj koszyk |
| DELETE | `/v1/checkouts/{checkoutId}`                 | Usuń koszyk |

### 👤 Użytkownicy (`/v1/users`)

| Metoda | Ścieżka                    | Opis |
|-------:|----------------------------|------|
| GET    | `/v1/users`                | Pobierz listę użytkowników |
| GET    | `/v1/users/{userId}`       | Pobierz użytkownika po ID |
| POST   | `/v1/users`                | Utwórz użytkownika |
| PUT    | `/v1/users`                | Zaktualizuj użytkownika |
| DELETE | `/v1/users/{userId}`       | Usuń użytkownika |
| POST   | `/v1/users/login`          | Logowanie (email + hasło) |
| GET    | `/v1/users/standard`       | Lista użytkowników bez uprawnień |

> ℹ️ W kodzie parametr ścieżki w `GET /v1/users/{userId}` bywa nazwany `orderId`, jednak reprezentuje **ID użytkownika**.

### 🌦️ Pogoda (`/api/weather`)

| Metoda | Ścieżka                     | Opis |
|-------:|-----------------------------|------|
| GET    | `/api/weather`              | Bieżąca temperatura jako tekst |
| GET    | `/api/weather/temperature`  | Bieżąca temperatura jako liczba |

---

## 📌 Przykładowe zapytania (cURL)

```bash
# Produkty
curl -X GET "http://localhost:8080/v1/products?page=0&size=10"
curl -X GET "http://localhost:8080/v1/products/1"
curl -X POST "http://localhost:8080/v1/products"   -H "Content-Type: application/json"   -d '{"brand":"Acme","model":"Smart Bulb","price":29.99,"type":"BULB"}'

# Zamówienia
curl -X GET "http://localhost:8080/v1/orders"
curl -X POST "http://localhost:8080/v1/orders/fromCheckout/1"

# Checkouts
curl -X GET "http://localhost:8080/v1/checkouts?size=20"
curl -X GET "http://localhost:8080/v1/checkouts/ordered?ordered=true"
curl -X POST "http://localhost:8080/v1/checkouts/fromProduct/1"

# Użytkownicy
curl -X POST "http://localhost:8080/v1/users"   -H "Content-Type: application/json"   -d '{"name":"Alice","email":"alice@example.com","password":"secret"}'
curl -X POST "http://localhost:8080/v1/users/login"   -H "Content-Type: application/json"   -d '{"email":"alice@example.com","password":"secret"}'

# Pogoda
curl -X GET "http://localhost:8080/api/weather"
curl -X GET "http://localhost:8080/api/weather/temperature"
```

---

## 🧪 Testy

- **JUnit 5** – testy logiki biznesowej
- **MockMvc** – testy warstwy kontrolerów
- **Testcontainers** – uruchamianie PostgreSQL w izolowanym kontenerze do testów

Uruchomienie testów:
```bash
./gradlew test
```

---

## 🚀 Deployment

- **Docker Hub** (obrazy Dockera)
- **Heroku / Railway** (deploy w chmurze)
- **Kubernetes** (jeśli użyjesz manifestów)

---

## 🤝 Contribution

1. Zrób fork repozytorium
2. Utwórz nowy branch (`feature/my-feature`)
3. Commituj zmiany (`git commit -m 'Add new feature'`)
4. Wypchnij branch (`git push origin feature/my-feature`)
5. Stwórz Pull Request

---

## 📜 Licencja

MIT License © 2025
