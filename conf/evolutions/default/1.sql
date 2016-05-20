# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table banks (
  id                            serial not null,
  name                          varchar(255),
  constraint pk_banks primary key (id)
);

create table banks_branches (
  ifsc                          varchar(255) not null,
  bank_id                       varchar(255),
  bank_name                     varchar(255),
  branch                        varchar(255),
  address                       varchar(255),
  city                          varchar(255),
  district                      varchar(255),
  state                         varchar(255),
  constraint pk_banks_branches primary key (ifsc)
);


# --- !Downs

drop table if exists banks cascade;

drop table if exists banks_branches cascade;

