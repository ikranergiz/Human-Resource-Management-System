create table public.employee_candidates
(
id bigint primary key not null GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 100000 CACHE 1),
	identification_number char(11) UNIQUE not null,
	first_name varchar(25) not null,
	last_name varchar(25) not null,
	year_of_birt char(4)  not null,
	email varchar(320) UNIQUE not null,
	password PASSWORD  not null
)
create table public.verifications_of_employees
(
id bigint primary key not null GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 100000 CACHE 1),
	employee_id bigint UNIQUE not null,
	is_verificate bigint not null
)
create table public.employers
(
id bigint primary key not null GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 100000 CACHE 1),
	company_name varchar(120) not null,
	website varchar(300) not null,
	email varchar(320) UNIQUE not null,
	password varchar(25) not null,
	phone varchar(15) not null
)
create table public.email_verifications_of_employers
(
id bigint primary key not null GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 100000 CACHE 1),
	verification_id bigint not null,
	is_verificate bigint not null
)
create table public.confirmation_of_hrms
(
id bigint primary key not null GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 100000 CACHE 1),
	confirmation_id bigint not null,
	is_confirm bigint not null
)
create table public.job_position
(
id bigint primary key not null GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 100000 CACHE 1),
	position_id bigint not null,
	position_name varchar(75) not null UNIQUE 
)

create table public.does_match
(
id bigint primary key not null GENERATED ALWAYS AS IDENTITY(INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 100000 CACHE 1),
	match_id bigint not null ,
	does_match bigint not null
)