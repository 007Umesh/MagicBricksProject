# MagicBricks Automation Framework

A Java-based Selenium WebDriver automation framework built for the [MagicBricks](https://www.magicbricks.com) real estate web application, following the **Page Object Model (POM)** design pattern.

---

## 📌 Project Overview

This framework automates end-to-end user flows on MagicBricks — covering property search, filter selection, and agent enquiry/appointment booking across multiple property categories including Flat, House, Villa, Office, PG, and Interior Design estimation.

---

## 🛠️ Tech Stack

| Tool | Version | Purpose |
|------|---------|---------|
| Java | 11 | Core programming language |
| Selenium WebDriver | 4.x | Browser automation |
| TestNG | 7.x | Test execution and reporting |
| Maven | 3.x | Build and dependency management |
| ExtentReports | 5.x | HTML test execution reports |
| Apache POI | 5.x | Data-driven test data from Excel |

---

## 📁 Project Structure

```
MagicBricksProject/
├── src/
│   └── test/
│       └── java/
│           └── com/magicbricks/
│               ├── pages/              # Page Object classes for each page
│               ├── tests/              # Test classes
│               │   ├── BaseReport.java             # ExtentReports base setup
│               │   ├── Tst_001_FlatRent.java        # Flat rental flow
│               │   ├── Tst_002_HouseRent.java       # House rental flow
│               │   ├── Tst_003_VillaRent.java       # Villa rental flow
│               │   ├── Tst_004_OfficeRent.java      # Office rental flow
│               │   ├── Tst_005_PgRent.java          # PG rental flow
│               │   └── Tst_006_EstimateInteriorDesign.java  # Interior design estimation
│               └── utils/              # Reusable utilities
├── Extent Reports/                     # Generated HTML execution reports
├── Screenshots/                        # Failure screenshots
├── pom.xml                             # Maven dependencies and build config
└── testng.xml                          # TestNG suite configuration
```

---

## ✅ Test Scenarios Automated

| Test ID | Module | Flow Automated |
|---------|--------|----------------|
| Tst_001 | Flat Rent | Search flat for rent → apply filters → view listings → enquire agent |
| Tst_002 | House Rent | Search house for rent → apply filters → view listings → enquire agent |
| Tst_003 | Villa Rent | Search villa for rent → apply filters → view listings → enquire agent |
| Tst_004 | Office Rent | Search office space for rent → apply filters → view listings → enquire agent |
| Tst_005 | PG Rent | Search PG accommodation → apply filters → view listings → enquire agent |
| Tst_006 | Interior Design | Navigate to interior design section → estimate cost for property |

---

## ⚙️ Framework Features

- **Page Object Model (POM)** — UI locators and actions separated from test logic
- **Data-Driven Testing** — Test inputs parameterised using TestNG DataProvider
- **ExtentReports** — Rich HTML reports generated after every test run with pass/fail status
- **Screenshot on Failure** — Automatic screenshot captured and embedded in report on test failure
- **Explicit Waits** — Dynamic element handling using WebDriverWait and ExpectedConditions
- **Maven Build** — Dependency management and test execution via Maven Surefire plugin
- **TestNG XML** — Suite-level test organisation and execution control

---

## 🚀 How to Run

### Prerequisites
- Java 11 or above installed
- Maven installed
- Chrome browser installed
- ChromeDriver compatible with your Chrome version

### Clone the repository
```bash
git clone https://github.com/007Umesh/MagicBricksProject.git
cd MagicBricksProject
```


## 📊 Test Reports

After execution, ExtentReports HTML report is generated at:
```
Extent Reports/ExtentReport.html
```

Open this file in any browser to view:
- Overall pass/fail summary
- Individual test step logs
- Screenshots attached on failure
- Execution timestamp and duration

---

## 🔍 Application Under Test

**MagicBricks** — [https://www.magicbricks.com](https://www.magicbricks.com)

One of India's largest real estate platforms for property search, buying, selling, and renting across multiple cities and property types.

---

## 👤 Author

**Umesh S**  
QA Engineer | Automation Testing  
[LinkedIn](https://linkedin.com/in/umesh-s-75132b1ab) · [GitHub](https://github.com/007Umesh)
