# 🌤️ Simple Weather App (Spring Boot)

A minimal Spring Boot web application that lets users check the current weather of any city using the OpenWeatherMap API.

---

## 🔧 Features
- Search weather by city name
- Displays temperature, humidity, and description
- Error message for invalid cities

---

## 🖼️ Screenshots

### 🔍 Weather Search Page (Index)
![index](https://github.com/user-attachments/assets/37f2f43b-14e3-4e8c-8f82-e37fe9db77fb)

### 🌦️ Weather Result Page
![results](https://github.com/user-attachments/assets/4b99d6db-c70c-4d01-84fe-66de9afb254f)

---

## 🛠️ Technologies Used
- Java
- Spring Boot
- Thymeleaf
- RestTemplate
- OpenWeatherMap API

---

## 🔑 API Key Setup

1. Sign up at [OpenWeatherMap](https://openweathermap.org/api) and get your API key.
2. Open the `src/main/resources/application.properties` file.
3. Add the following line:

```properties
weather.api.key=YOUR_API_KEY_HERE
