-- apply changes
create table mt_company (
  id                            bigint not null,
  name                          varchar(98) not null,
  logo                          varchar(300),
  principal                     varchar(32) not null,
  mobile                        varchar(35) not null,
  telephone                     varchar(35),
  email                         varchar(99),
  address                       varchar(255),
  description                   longtext,
  ext01                         longblob,
  ext02                         TEXT,
  ext03                         TEXT,
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint uq_mt_company_name unique (name),
  constraint pk_mt_company primary key (id)
);

create table mt_datasource (
  id                            bigint not null,
  name                          varchar(255) not null,
  group_id                      bigint not null,
  url                           varchar(320) not null,
  username                      varchar(48) not null,
  password                      varchar(128) not null,
  driver_name                   varchar(68) not null,
  type                          varchar(1) not null,
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint uq_mt_datasource_name unique (name),
  constraint pk_mt_datasource primary key (id)
);

create table mt_datasource_group (
  id                            bigint not null,
  name                          varchar(255) not null,
  description                   TEXT,
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint uq_mt_datasource_group_name unique (name),
  constraint pk_mt_datasource_group primary key (id)
);

create table mt_group (
  id                            bigint not null,
  tenant_id                     bigint not null,
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint pk_mt_group primary key (id)
);

create table mt_group_staff (
  id                            bigint not null,
  tenant_id                     bigint not null,
  group_id                      bigint,
  staff_id                      bigint,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  constraint pk_mt_group_staff primary key (id)
);

create table mt_login_log (
  id                            bigint not null,
  tenant_id                     bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  constraint pk_mt_login_log primary key (id)
);

create table mt_operator_log (
  id                            bigint not null,
  tenant_id                     bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  constraint pk_mt_operator_log primary key (id)
);

create table mt_option (
  id                            bigint not null,
  tenant_id                     bigint not null,
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint pk_mt_option primary key (id)
);

create table mt_permission (
  id                            bigint not null,
  tenant_id                     bigint not null,
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint pk_mt_permission primary key (id)
);

create table mt_role (
  id                            bigint not null,
  tenant_id                     bigint not null,
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint pk_mt_role primary key (id)
);

create table mt_role_permission (
  id                            bigint not null,
  tenant_id                     bigint not null,
  role_id                       bigint,
  permission_id                 bigint,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  constraint pk_mt_role_permission primary key (id)
);

create table mt_staff (
  id                            bigint not null,
  tenant_id                     bigint not null,
  staff_name                    varchar(255),
  account                       varchar(255),
  email                         varchar(255),
  avatar                        varchar(255),
  mobile                        varchar(255),
  password                      varchar(255),
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint pk_mt_staff primary key (id)
);

create table mt_staff_role (
  id                            bigint not null,
  tenant_id                     bigint not null,
  staff_id                      bigint,
  role_id                       bigint,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  constraint pk_mt_staff_role primary key (id)
);

create table mt_tenant (
  id                            bigint not null,
  start_time                    datetime(6) not null,
  end_time                      datetime(6) not null,
  leases                        bigint not null,
  company_id                    bigint,
  ds_type                       varchar(3),
  status                        varchar(1),
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint pk_mt_tenant primary key (id)
);

