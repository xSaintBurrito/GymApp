CREATE OR REPLACE PACKAGE MAINTAIN_MACHINES AS

FUNCTION reserve_machine (i_user_id     IN reservations.user_id%TYPE, 
                          i_machine_id  IN reservations.machine_id%TYPE)
                          RETURN BOOLEAN;

FUNCTION release_machine (i_machine_id  IN reservations.machine_id%TYPE)
                          RETURN BOOLEAN;

FUNCTION see_all_usage(o_total_usage OUT NUMBER) RETURN BOOLEAN;

FUNCTION see_personal_usage(o_total_usage OUT NUMBER,
                       i_user_id IN reservations.user_id%TYPE) RETURN BOOLEAN;

FUNCTION report_problem(i_machine_id IN reservations.machine_id%TYPE,
                        i_problem reservations.exclusion_reason%TYPE) RETURN BOOLEAN;

FUNCTION remove_machine(i_machine_id IN reservations.machine_id%TYPE) 
                RETURN BOOLEAN;

FUNCTION add_machine(i_type IN reservations.type%TYPE,
                     i_avaiable IN avaiable.type%TYPE   ) 
                RETURN BOOLEAN;

FUNCTION exclude_machine(i_machine_id IN reservations.machine_id%TYPE) 
                RETURN BOOLEAN;

FUNCTION add_to_statistics (i_user_id     IN reservations.user_id%TYPE, 
                          i_machine_id  IN reservations.machine_id%TYPE,
                          i_time_used IN statistics.time_used%TYPE)
                          RETURN BOOLEAN;

END;