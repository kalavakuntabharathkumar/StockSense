# StockSense — Inventory Dashboard & API Integrations

Angular + TypeScript dashboard backed by Spring Boot and MySQL. Includes inventory CRUD, low-stock alerts through SendGrid, Razorpay test-mode order creation, Swagger/OpenAPI and JUnit tests.

## Requirements
Java 17+, Maven 3.9+, Node 20+, npm, Angular CLI 17+, MySQL 8+.

## Backend
Create database `stocksense`, then configure optional environment variables `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`, `SENDGRID_API_KEY`, `SENDGRID_FROM`, `RAZORPAY_KEY_ID`, `RAZORPAY_KEY_SECRET`.

```bash
cd backend
mvn spring-boot:run
```
API: `http://localhost:8081`; Swagger UI: `http://localhost:8081/swagger-ui.html`.

External integrations are safe by default: without credentials, SendGrid returns a clear `configured:false` result and Razorpay order creation reports that credentials are required. Never commit API keys. Razorpay must remain in test mode until independently reviewed.

## Frontend
```bash
cd frontend
npm install
npm start
```
Open `http://localhost:4200`.

## Tests
```bash
cd backend && mvn test
```
The sample dataset includes a small retail catalog. Metrics in the project brief describe the intended demonstration scenario and should be independently measured before being presented as production results.


## REST API reference (18 routes)

- `GET /api/products`, `POST /api/products`, `GET /api/products/{id}`, `PUT /api/products/{id}`, `DELETE /api/products/{id}`
- `GET /api/products/sku/{sku}`, `PATCH /api/products/{id}/stock`, `POST /api/products/bulk`, `GET /api/products/count`
- `GET /api/products/low-stock`, `GET /api/dashboard/summary`, `GET /api/reports/stock-value`, `GET /api/reports/low-stock`
- `GET /api/alerts/preview`, `POST /api/alerts/low-stock`, `GET /api/integrations/status`
- `POST /api/payments/orders`, `GET /api/payments/configuration`

OpenAPI is generated from the Spring MVC controller annotations and is available at `/v3/api-docs`; Swagger UI is available at `/swagger-ui.html`.
