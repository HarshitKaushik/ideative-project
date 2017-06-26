-- Create user login details for user login details

create table ideative.user_login_details (
user_login_details_id integer not null,
user_id integer not null,
access_token character varying not null,
ip_details character varying not null,
start_date timestamp with time zone,
end_date timestamp with time zone,
constraint user_login_details_id_pk primary key(user_login_details_id),
constraint user_id_fk foreign key(user_id) references ideative.user (user_id)
);

--create sequence

create sequence ideative.user_login_details_id_seq
start 1;