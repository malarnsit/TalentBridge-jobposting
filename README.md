Java Application Development-Sasken Technologies
# TalentBridge Project  

TalentBridge is a recruitment/job portal application that helps connect job seekers with employers efficiently.
It provides features for job postings, resume management,employee-job matching, and application tracking.
The project is built as a full-stack application with frontend, backend, and database integration.

---

## Features  
- User authentication & authorization  
- Job postings and applications  
- Employer dashboard  
- Database integration with MySQL  

---

## Tech Stack  
- **Frontend**: HTML, CSS, JavaScript 
- **Backend**:  Java (Spring Boot) —
- **Database**: MySQL   
- **Version Control**: GitHub  

---

## 📂 Project Structure  
TalentBridge/
│
├── src/                         # Java source code (Spring Boot)
│   ├── main/
│   │   ├── java/com/example/... # Controllers, Services, Models
│   │   └── resources/
│   │       ├── templates/       # Thymeleaf HTML pages
│   │       └── application.properties
│   └── test/                    # Unit/Integration tests
│
├── TalentBridge-jobposting/     # Module for job posting features
│
├── target/                     
│
├── pom.xml                      # Maven build configuration
└── README.md                    # Project documentation
## Database Schema

> use talentbridge;
> desc job_posting;
+-----------------+---------------+------+-----+---------+----------------+
| Field           | Type          | Null | Key | Default | Extra          |
+-----------------+---------------+------+-----+---------+----------------+
| id              | bigint        | NO   | PRI | NULL    | auto_increment |
| created_by      | varchar(255)  | YES  |     | NULL    |                |
| criteria        | varchar(255)  | YES  |     | NULL    |                |
| department      | varchar(255)  | YES  |     | NULL    |                |
| duration        | int           | YES  |     | NULL    |                |
| end_date        | date          | YES  |     | NULL    |                |
| location        | varchar(255)  | YES  |     | NULL    |                |
| skill_set       | varchar(255)  | YES  |     | NULL    |                |
| start_date      | date          | YES  |     | NULL    |                |
| status          | varchar(255)  | YES  |     | NULL    |                |
| title           | varchar(255)  | YES  |     | NULL    |                |
| closing_date    | date          | YES  |     | NULL    |                |
| description     | varchar(2000) | YES  |     | NULL    |                |
| employment_type | varchar(255)  | YES  |     | NULL    |                |
| posted_date     | date          | YES  |     | NULL    |                |
| requirements    | tinytext      | YES  |     | NULL    |                |
| salary          | double        | YES  |     | NULL    |                |
+-----------------+---------------+------+-----+---------+----------------+
17 rows in set (0.01 sec)
