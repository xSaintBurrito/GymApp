CREATE TABLE reservations (reservation_id NUMBER(12) PRIMARY KEY, user_id NUMBER(12), machine_id NUMBER(12), 
start_date DATE, end_date DATE);

CREATE TABLE machines (machine_id NUMBER(12) PRIMARY KEY, type VARCHAR2(120), reserved VARCHAR2(1), exclusion_reason VARCHAR2(120),
avaiable VARCHAR2(1));

CREATE TABLE statistics (statistic_id NUMBER(12) PRIMARY KEY, machine_id NUMBER(12), time_used NUMBER(6,2), user_id NUMBER(12));

