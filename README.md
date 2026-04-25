# 🛒 E-Commerce Selenium Automation Framework

## 📌 Project Overview

This project is a **production-level Selenium Automation Framework** designed to test real-world e-commerce workflows such as login, add product to cart, and checkout.

It follows best practices used in modern QA automation including **Page Object Model (POM)**, **Data-Driven Testing**, and **BDD (Cucumber)**.

---

## 🚀 Features

* ✅ Page Object Model (POM) design pattern
* ✅ Data-driven testing (JSON / Excel support)
* ✅ BDD with Cucumber
* ✅ TestNG integration
* ✅ Reusable utilities & base classes
* ✅ Logging
* ✅ Scalable and maintainable architecture
* ✅ Extent Report and Allure Report
* ✅ Jenkins

---

## 🧪 Test Scenarios Covered

* 🔐 Login (valid, invalid, locked account)
* 🛍️ Product Click
* 🛒 Add to cart
* 💳 Checkout process
* ❌ Error validations

---

## 🛠️ Tech Stack

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **BDD:** Cucumber
* **Build Tool:** Maven
* **Version Control:** Git & GitHub
* **Report:** Extent Report,Allure Report
* **CICD:** Jenkins

---

## 📁 Project Structure
```
src
 ├── main
 │   ├── java
 │   │   ├── Driverfactory
 │   │   ├── model
 │   │   ├── pages
 │   │   ├── utils
 │   │
 ├── test
 │   ├── java
 │   │   ├── hooks
 │   │   ├── runners
 │   │   ├── stepdefinitions
 │   │
 ├── resources
 │   ├── config.properties
 │   ├── features
 │── Jekinsfile
 │── testng.xml
 │── pom.xml
 │── extent.properties
 |── README.md 

```

---

## ▶️ How to Run the Project

1.Clone the repository

```bash
git clone https://github.com/dhivyacheuwz/E-commerce-Selenium.git
```

2.Navigate to project

```bash
cd E-commerce-Selenium
```

3. Run tests

```bash
mvn clean test
```

---

## 🔐 Configuration

Update `config.properties`:

```
browser=chrome
baseUrl=https://automationexercise.com
ExcelFileLocation=/src/test/resources/testdata/Credential.xlsx
JsonPay=/src/test/resources/testdata/payment.json

```

---

## 💡 Future Enhancements

* 🌐 Parallel execution
* 📱 Mobile testing support
* 🔗 API automation integration

---

## 👩‍💻 Author

**Dhivya Bharathi**
QA Automation Engineer | Selenium | API Testing

---

## ⭐ Show Your Support

If you like this project, give it a ⭐ on GitHub!
