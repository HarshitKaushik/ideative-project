-- Create master type group

create table ideative.master_type_group (
master_type_group_id integer not null ,
group_name character varying not null,
start_date timestamp with time zone,
end_date timestamp with time zone,
constraint master_type_group_id_pk primary key(master_type_group_id)
);

--create sequence for master type group

create sequence ideative.master_type_group_id_seq
start 1;

-- Create master type table

create table ideative.master_type (
master_type_id integer not null,
master_type_group_id integer not null,
master_type character varying,
start_date timestamp with time zone,
end_date timestamp with time zone,
constraint master_type_id_pk primary key(master_type_id),
constraint master_type_group_id_fk foreign key(master_type_group_id) references ideative.master_type_group (master_type_group_id)
);

--create sequence for master type

create sequence ideative.master_type_id_seq
start 1;