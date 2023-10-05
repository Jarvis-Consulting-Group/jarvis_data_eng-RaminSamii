# Ramin Sami . Jarvis Consulting

I am a highly motivated software engineering graduate from Ontario Tech University with a fundamental knowledge of software design, development, and testing. I started learning Java earlier in high school. Being the only girl in my programming class was a huge motivation for me to keep moving forward. Throughout my degree, I designed and developed projects incorporating data structures, artificial intelligence, and embedded systems that I am proud of. I once created a Python program using TensorFlow which allowed the user to generate an outfit by type. The model was trained using Keras API to classify images. I enjoy developing games on Python, Java, and C# in my free time. A few games I'm exceptionally proud of are Snake Game, Whack-A-Mole, Tic-Tac-Toe, and Sudoku. With a strong foundation in software engineering principles and hands-on experience in various programming languages. I am eager to collaborate with talented individuals and contribute to a team-driven environment that fosters creativity and growth.

## Skills

**Proficient:** Java, Python, RDBMS/SQL, Agile/Scrum, Git

**Competent:** Linux/Bash, JavaScript/TypeScript, HTML, CSS/Bootstrap, ReactJS, Jira

**Familiar:** JQuery, Kotlin, C#, C/C++, PHP

## Jarvis Projects

Project source code: [https://github.com/Jarvis-Consulting-Group/jarvis_data_eng-RaminSamii.git](https://github.com/Jarvis-Consulting-Group/jarvis_data_eng-RaminSamii.git)


**Cluster Monitor** [[GitHub](https://github.com/Jarvis-Consulting-Group/jarvis_data_eng-RaminSamii.git/tree/master/linux_sql)]: Linux Cluster Monitoring Agent app is a solution created to manage a cluster of 10 servers. Users of the servers can simply track hardware and usage data. The app is used by the linux cluster administration team for efficient operations and maintenance. To implement the app i started by installing docker and provisioning a postGRESQL instance and client cli tool. I created a database schema for storing hardware statistics inside of a docker container to make sure the gathered data is well-organized. Then i went about created two bash scripts host_info.sh and host_usage.sh the host_info.sh script was run once during installation to retrieve and save hardware information in the PostgreSQL database. On the other hand, the host_usage.sh script was set up to run every minute through a cron job, allowing for minute-by-minute server usage monitoring. 

**RDBMS and SQL** [[GitHub](https://github.com/Jarvis-Consulting-Group/jarvis_data_eng-RaminSamii.git/tree/master/sql)]: This RDBMS and SQL project is designed to apply SQL optimization. The objectives of the project incorporated CRUD operations (DQL, DDL, DML). The project entailed understanding data modeling strategies to ensure quality data governance. The setup included a project directory structure and GitHub to manage the project source code, a psql instance, and pgAdmin was used as IDE. Sample data was loaded and distributed among the database in three tables tracking values associated with different columns. The database was tested with SQL queries to access data

**Core Java Apps** [[GitHub](https://github.com/Jarvis-Consulting-Group/jarvis_data_eng-RaminSamii.git/tree/master/core_java)]:
      
  - JDBC App: The goal of the JDBC project was to develop a Java application that connects to and communicates with a PSQL (PostgreSQL) database using the JDBC API. To make it easier to manipulate data in our PSQL database, we introduced basic CRUD actions.A docker container image was created to run PSQL. We constructed the CRUD operations after connecting Java and PSQL, and we checked our solution by consulting our database. We ran CRUD operations on a variety of default values that we loaded into the table. Maven was used to manage dependencies for the project and as i mentioned the testing was done by running CRUD actions on the database.
  - Grep App: The grep app utilizes Two methods for effectively searching patterns within files in a directory. The Stream-Based Approach uses Java Streams and functional programming concepts to analyse big datasets with clear and elegan code. It is implemented in the StreamJavaGrepImp class. The application effectively manages files that are larger than the physical memory of the system while retaining a small heap memory footprint (e.g., 10-20MB) by using streams. This method is especially useful for managing large datasets, making it the best choice in situations when memory efficiency is an issue. On the other hand The JavaGrepImp class implements the Traditional Approach, which is better suited to processing moderate-sized data sets because it uses standard file I/O and looping capabilities. it offers a dependable and simple way to find patterns in files. Grep was developed using core Java, Java Streams for the Stream-Based Approach, and Apache Maven as the build tool. The application is also Dockerized, making deployment across many enviroments simple.

**Python Data Analytics** [[GitHub](https://github.com/Jarvis-Consulting-Group/jarvis_data_eng-RaminSamii.git/tree/master/python_data_anlytics)]: Developed customized marketing tactics by using advanced data analytics tools to analyze a company's transactional data and get insights into customer shopping behavior. I used the Pandas, Numpy, Matplotlib, and SQLAlchemy libraries to undertake in-depth data analysis using Python as the primary programming language. The entire research was done in a Jupyter notebook setting, where I easily accessed information from both CSV files and a PostgreSQL database that was generated from the company's data warehouse. The notebook, which was running on a Jupyter server, produced intricate visualizations, such as plots showing monthly sales patterns, order placements, client counts, and, most importantly, the segmentation of the customer base based on recentness, frequency, and money. With the use of data-driven insights, this project demonstrated expertise in data analysis, software tools, and database integration.


## Highlighted Projects
**Web based Cloud HealthCare Service System**: Designed and created a web application depicting a Health-Care system with personalized user experience for patient and client side. The concept was generated during the peak of Covid-19 virus in 2021. The application mimiced essential elements of a visit to the specialist's office while lessening however much human contact as could be expected. Enabled login validation using Cloud Firestore database. Implemented a video call experience between patient and doctor using Web Real-Time Communication (WebRTC) API on JavaScript. A peer-to peer virtual connection was setup up from doctor's end through signalling and generating a Session Description Protocol (SDP) offer and a code which would get stored in Firebase. The code was accesible for the patient on the web interface to join the Video Call appointment.

**Hotel Database Management System**: Developed a database management system using SQL. The hotel had multiple rooms and floors, and these rooms were of different types. The system was managed by hotel employees by a web framework using HTML and CSS. The database was connected to the web app with PHP. Employees were able to query from the web app to register guests for check ins, check for available rooms, assign rooms from the available rooms directory, mark if a guest requires housekeeping, and check guests out.


## Professional Experiences

**Software Developer, Jarvis (2023-present)**: Developed, analyzed, and modified programming systems, which involved tasks such as encoding, testing, and debugging. Gained valuable experience working with diverse arrays of large data sets and large-scale data platforms. Following agile methodologies and utilizing git-flow, successfully developed applications that ran within Docker containers. Actively contributed to code-review sessions, ensuring that the code quality aligned with the specific business and project requirements.

**Programming Instructor, Zebra Robotics (2022-2023)**: Taught 100+ students (grades 5-12) HTML, CSS, Python, JavaScript and Java. Delivered STEM based curricula to students of various ages, and periodically helped create said curricula. Acted as one of the lead delivery facilitators for workshops and modules.

**Full Stack Developer, Finaeo Inc. (2021)**: Managed development projects through completion, optimizing all cross-browser and multiplatform compatibility. Gained technical development skills such as JavaScript/TypeScript as well as Git and other workflow experience. Managed time-sensitive updates, including content changes and upgrades. Provided input to the continual development of tooling and reporting to add tangible business benefits. 


## Education
**Ontario Tech University (2017-2022)**, Bachelor of Software Engineering (Honours), Engineering and Applied Science


## Miscellaneous
- Regularly engage in strength training, cardio workouts, and yoga to maintain a healthy lifestyle. Regularly attend classes, maintain a daily meditation practice, and apply principles of mindfulness to enhance focus and productivity in both personal and professional settings.
- Enthusiastic player of a wide range of board games, from complex strategy games like Risk to collaborative team games like Codenames. Participate in local game nights, honing strategic thinking, communication, and adaptability through various game scenarios.
- Avid road trip traveler who has explored diverse cultures across Ontario. Proficient in trip planning, budget management, and problem-solving during extended journeys, fostering adaptability and a strong sense of adventure. 