-- Create master status group

create table ideative.master_status_group (
master_status_group_id integer not null,
group_name character varying not null,
start_date timestamp with time zone,
end_date timestamp with time zone,
constraint master_status_group_id_pk primary key(master_status_group_id)
);

--create sequence for master status group

create sequence ideative.master_status_group_id_seq
start 1;

-- Create master type table

create table ideative.master_status (
master_status_id integer not null,
master_status_group_id integer not null,
master_status character varying,
start_date timestamp with time zone,
end_date timestamp with time zone,
constraint master_status_id_pk primary key(master_status_id),
constraint master_status_group_id_fk foreign key(master_status_group_id) references ideative.master_status_group (master_status_group_id)
);

--create sequence for master status

create sequence ideative.master_status_id_seq
start 1;

-- Insert the User status Master Group
insert into ideative.master_status_group values(nextval('ideative.master_status_group_id_seq'), 'User Status', now(), null);

-- Insert the various User status
insert into ideative.master_status values(nextval('ideative.master_status_id_seq'), 1, 'Active', now(), null);
insert into ideative.master_status values(nextval('ideative.master_status_id_seq'), 1, 'Banned', now(), null);
insert into ideative.master_status values(nextval('ideative.master_status_id_seq'), 1, 'Inactive', now(), null);