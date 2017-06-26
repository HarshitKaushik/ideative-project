-- Create a user table

create table ideative.user (
user_id integer not null,
first_name character varying,
last_name character varying,
email character varying not null UNIQUE,
password character varying not null,
start_date timestamp with time zone,
end_date timestamp with time zone,
status integer not null,
constraint user_id_pk primary key(user_id)
);

-- Create a sequence for user ID

create sequence ideative.user_id_seq
start 1;