CREATE OR REPLACE PACKAGE BODY MAINTAIN_MACHINES AS

FUNCTION reserve_machine (i_user_id     IN reservations.user_id%TYPE, 
                          i_machine_id  IN reservations.machine_id%TYPE)
                          RETURN BOOLEAN IS
                          
CURSOR get_reservation_id_cur IS
    SELECT max(nvl(reservation_id,0)) + 1 FROM reservations;

CURSOR check_machine_id_cur IS
    SELECT 1 FROM machines WHERE machine_id = i_machine_id;

CURSOR check_user_id_cur IS
    SELECT 1 FROM users WHERE user_id = i_user_id;

l_check_machine_id NUMBER;
l_check_user_id NUMBER;
l_reservation_id reservations.reservation_id%TYPE;

BEGIN

OPEN check_machine_id_cur;
FETCH check_machine_id_cur INTO l_check_machine_id;
CLOSE check_machine_id_cur;

OPEN check_user_id_cur;
FETCH check_user_id_cur INTO l_check_user_id;
CLOSE check_user_id_cur;

IF l_check_machine_id IS NULL THEN
    RETURN FALSE;
ELSIF l_check_user_id IS NULL THEN
    RETURN FALSE;
END IF;

OPEN get_reservation_id_cur;
FETCH get_reservation_id_cur INTO l_reservation_id;
CLOSE get_reservation_id_cur;



INSERT INTO reservations VALUES (l_reservation_id, i_user_id, i_machine_id, sysdate, null);

UPDATE machines SET reserved = 'Y' WHERE machine_id = i_machine_id;

RETURN TRUE;

END reserve_machine;

FUNCTION release_machine (i_machine_id  IN reservations.machine_id%TYPE)
                          RETURN BOOLEAN IS
                          

CURSOR check_machine_id_cur IS
    SELECT 1 FROM machines WHERE machine_id = i_machine_id;


l_check_machine_id NUMBER;


BEGIN

OPEN check_machine_id_cur;
FETCH check_machine_id_cur INTO l_check_machine_id;
CLOSE check_machine_id_cur;


IF l_check_machine_id IS NULL THEN
    RETURN FALSE;
END IF;

UPDATE reservations SET end_date = sysdate WHERE machine_id = i_machine_id AND end_date IS NULL;

UPDATE machines SET reserved = 'N' WHERE machine_id = i_machine_id;

RETURN TRUE;

END release_machine;

FUNCTION see_all_usage(o_total_usage OUT NUMBER) RETURN BOOLEAN IS
CURSOR get_total_usage IS
    SELECT SUM(time_used) FROM statistics;

BEGIN

OPEN get_total_usage;
FETCH get_total_usage INTO o_total_usage;
CLOSE get_total_usage;
RETURN TRUE;

END see_all_usage;

FUNCTION see_personal_usage(o_total_usage OUT NUMBER,
                       i_user_id IN reservations.user_id%TYPE) RETURN BOOLEAN IS
CURSOR get_total_usage IS
    SELECT SUM(time_used) FROM statistics WHERE user_id = i_user_id;

BEGIN

OPEN get_total_usage;
FETCH get_total_usage INTO o_total_usage;
CLOSE get_total_usage;
RETURN TRUE;

END see_personal_usage;

FUNCTION report_problem(i_machine_id IN reservations.machine_id%TYPE,
                        i_problem reservations.exclusion_reason%TYPE) RETURN BOOLEAN IS

CURSOR check_machine_id_cur IS
    SELECT 1 FROM machines WHERE machine_id = i_machine_id;


l_check_machine_id NUMBER;


BEGIN

OPEN check_machine_id_cur;
FETCH check_machine_id_cur INTO l_check_machine_id;
CLOSE check_machine_id_cur;


IF l_check_machine_id IS NULL THEN
    RETURN FALSE;
END IF;

UPDATE machines SET exclusion_reason = i_problem, avaiable = 'N' WHERE machine_id = i_machine_id;
RETURN TRUE;

END report_problem;

FUNCTION remove_machine(i_machine_id IN reservations.machine_id%TYPE) 
                RETURN BOOLEAN IS

CURSOR check_machine_id_cur IS
    SELECT 1 FROM machines WHERE machine_id = i_machine_id;


l_check_machine_id NUMBER;


BEGIN

OPEN check_machine_id_cur;
FETCH check_machine_id_cur INTO l_check_machine_id;
CLOSE check_machine_id_cur;


IF l_check_machine_id IS NULL THEN
    RETURN FALSE;
END IF;

DELETE machines WHERE machine_id = i_machine_id;
RETURN TRUE;

END remove_machine;

FUNCTION add_machine(i_type IN reservations.type%TYPE,
                     i_avaiable IN avaiable.type%TYPE   ) 
                RETURN BOOLEAN IS

CURSOR get_machine_id IS
    SELECT max(nvl(machine_id,0)) + 1 FROM machines;


l_machine_id NUMBER;


BEGIN

OPEN get_machine_id;
FETCH get_machine_id INTO l_machine_id;
CLOSE get_machine_id;


INSERT INTO machines (l_machine_id, i_type, 'N', null, i_avaiable);
RETURN TRUE;

END add_machine;

FUNCTION exclude_machine(i_machine_id IN reservations.machine_id%TYPE) 
                RETURN BOOLEAN IS

CURSOR check_machine_id_cur IS
    SELECT 1 FROM machines WHERE machine_id = i_machine_id;


l_check_machine_id NUMBER;


BEGIN

OPEN check_machine_id_cur;
FETCH check_machine_id_cur INTO l_check_machine_id;
CLOSE check_machine_id_cur;


IF l_check_machine_id IS NULL THEN
    RETURN FALSE;
END IF;

UPDATE machines SET avaiable = 'N' WHERE machine_id = i_machine_id;
RETURN TRUE;

END exclude_machine;


FUNCTION add_to_statistics (i_user_id     IN reservations.user_id%TYPE, 
                          i_machine_id  IN reservations.machine_id%TYPE,
                          i_time_used IN statistics.time_used%TYPE)
                          RETURN BOOLEAN IS
                          
CURSOR get_statistic_id_cur IS
    SELECT max(nvl(statistic_id,0)) + 1 FROM statistics;

CURSOR check_machine_id_cur IS
    SELECT 1 FROM machines WHERE machine_id = i_machine_id;

CURSOR check_user_id_cur IS
    SELECT 1 FROM users WHERE user_id = i_user_id;

l_check_machine_id NUMBER;
l_check_user_id NUMBER;
l_statistic_id reservations.reservation_id%TYPE;

BEGIN

OPEN check_machine_id_cur;
FETCH check_machine_id_cur INTO l_check_machine_id;
CLOSE check_machine_id_cur;

OPEN check_user_id_cur;
FETCH check_user_id_cur INTO l_check_user_id;
CLOSE check_user_id_cur;

IF l_check_machine_id IS NULL THEN
    RETURN FALSE;
ELSIF l_check_user_id IS NULL THEN
    RETURN FALSE;
END IF;

OPEN get_reservation_id_cur;
FETCH get_reservation_id_cur INTO l_statistic_id;
CLOSE get_reservation_id_cur;



INSERT INTO statistics VALUES (l_statistic_id, i_machine_id, i_time_used, i_user_id);

RETURN TRUE;

END add_to_statistics;

END;