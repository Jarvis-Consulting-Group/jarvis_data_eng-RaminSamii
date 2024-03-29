# Introduction
(all words)
Discuss the design of the project. What does this project/product do? Who are the users? What are the technologies you have used? (e.g. bash, docker, git, etc..)

# Quick Start
- Start a psql instance using psql_docker.sh
`
./scripts/psql_docker.s start
`
- Create tables using ddl.sql
`
psql -h localhost -U postgres -d host_agent -f sql/ddl.sql
`
- Insert hardware specs data into the DB using host_info.sh
`
./scripts/host_info.sh localhost 5432 host_agent postgres password
`
- Insert hardware usage data into the DB using host_usage.sh
`
./scripts/host_usage.sh localhost 5432 host_agent postgres password
`
- Crontab setup
`
crontab -e
#add in cron job to collect usage data every minute
*****.../host_usage.sh localhost 5432 host_agent postgres password > /tmp/host_usage.log
`

# Implemenation
Discuss how you implement the project.
## Architecture
Draw a cluster diagram with three Linux hosts, a DB, and agents (use draw.io website). Image must be saved to the `assets` directory.

## Scripts
Shell script description and usage (use markdown code block for script usage)
- psql_docker.sh
* The script contains input command with username and password variables.
* This script creates a psql instance within a docker container.
* The script creates, starts or stops the container according to the container's status.

- host_info.sh
* This script gets executed once during installation.
* This script stores harware specifications of the host and adds it into the database.

- host_usage.sh
* This script inserts a row of harware usage data of the machine into the database.
* This script runs every minute using crontab.

- crontab
* Automates data usage monitoring and insersion by running `host_usage.sh` regularly (every minute).

- queries.sql
* Lets the user request for a piece of information from the database.

## Database Modeling
- `host_info schema`
| Column            | Data Type | Description |
| :---------------- | :---------: | --------------------: |
| id                |  SERIAL  | Unique ID (Primary Key) |
| hostname          |   VARCHAR   | Hostname for the machine |
| cpu_number    |  INTEGER   | Number of CPU's in host |
| cpu_architecture |  VARCHAR   | CPU Architecture |
| cpu_mhz                |  FLOAT  | CPU clock speed (MHz) |
| l2_cache          |  INTEGER  | L2 cache size |
| timestamp    |  TIMESTAMP   | Timestamp for when the data got collected |
| total_mem |  INTEGER   | Total idle memory in host |

- `host_usage schema`
| Column            | Data Type | Description |
| :---------------- | :---------: | --------------------: |
| timestamp                |  TIMESTAMP  | Timestamp for when usage data was inserted |
| host_id          |  INTEGER   | Host ID (References id in host_info) |
| memory_free    |  INTEGER   | Total idle memory |
| cpu_idle |  INTEGER   | Percentage of CPU idle time |
| cpu_kernel                |  INTEGER  | Percentage of CPU time spent running kernel |
| disk_io        |  INTEGER  | All current disk I/O operations |
| disk_available    |  INTEGER   | Available disk space (MB) |

# Test
How did you test your bash scripts DDL? What was the result?
-run the script with bash-x

# Deployment
###GitHub
- A GitHub repository maintains `psql_docker.sh`, `host_info.sh`, `host_usage.sh` and `ddl.sql`.

###Crontab
- By using cron job, usage data is inserted into the database by executing `host_usage.sh` every minute.

###Docker
- Install Docker
- Using Docker, provision PostgreSQL instance

###PostgreSQL
- Create a PostgreSQL container by using `psql_docker.sh` script.
- Use `ddl.sql` to create host_info and host_usage tables in the database.
- Enter hardware specifications into the database by using `host_info.sh`

# Improvements
- Handle hardware updates 
- Implement a GUI to display key metrics over a period of time
- Automate running of the bash scripts
- Setup alerts for detected usage issues
