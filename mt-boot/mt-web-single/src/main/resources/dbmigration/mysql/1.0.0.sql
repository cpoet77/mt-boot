-- apply changes
create table mt_acl_formula (
  id                            bigint not null,
  tenant_id                     bigint not null,
  name                          varchar(255) not null,
  left_formula                  varchar(255) not null,
  left_type                     varchar(4) not null,
  symbol                        varchar(1) not null,
  right_formula                 varchar(255) not null,
  right_type                    varchar(4) not null,
  status                        varchar(1) not null,
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint uq_mt_acl_formula_name unique (name),
  constraint pk_mt_acl_formula primary key (id)
);

create table mt_company (
  id                            bigint not null,
  name                          varchar(255) not null,
  logo                          varchar(512),
  principal                     varchar(30) not null,
  mobile                        varchar(42) not null,
  telephone                     varchar(38),
  email                         varchar(99),
  address                       varchar(255),
  description                   longtext,
  ext01                         longtext,
  ext02                         longtext,
  ext03                         longtext,
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
  url                           varchar(512) not null,
  username                      varchar(48) not null,
  password                      varchar(128) not null,
  driver_name                   varchar(68) not null,
  type                          varchar(1) not null,
  remark                        varchar(512),
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
  description                   longtext,
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
  parent_id                     bigint not null,
  name                          varchar(255) not null,
  description                   varchar(255),
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
  group_id                      bigint not null,
  staff_id                      bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  constraint pk_mt_group_staff primary key (id)
);

create table mt_login_log (
  id                            bigint not null,
  tenant_id                     bigint not null,
  staff_id                      bigint not null,
  account                       varchar(50) not null,
  login_type                    varchar(15) not null,
  logout_type                   varchar(1),
  ip_addr                       varchar(128),
  user_agent                    varchar(255),
  os                            varchar(255),
  screen                        varchar(255),
  login_time                    datetime(6) not null,
  logout_time                   datetime(6),
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  constraint pk_mt_login_log primary key (id)
);

create table mt_menu (
  id                            bigint not null,
  tenant_id                     bigint not null,
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint pk_mt_menu primary key (id)
);

create table mt_online (
  id                            bigint not null,
  tenant_id                     bigint not null,
  login_id                      bigint not null,
  token                         varchar(255) not null,
  start_time                    datetime(6) not null,
  end_time                      datetime(6) not null,
  duration                      bigint not null,
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint pk_mt_online primary key (id)
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
  parent_id                     bigint not null,
  code                          varchar(255) not null,
  name                          varchar(255) not null,
  icon                          varchar(512),
  description                   longtext,
  is_built_in                   tinyint(1) not null,
  status                        varchar(1) not null,
  sorted                        integer not null,
  type                          varchar(4) not null,
  is_formula                    tinyint(1) not null,
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint uq_mt_permission_code unique (code),
  constraint uq_mt_permission_name unique (name),
  constraint pk_mt_permission primary key (id)
);

create table mt_role (
  id                            bigint not null,
  tenant_id                     bigint not null,
  name                          varchar(255) not null,
  sorted                        integer not null,
  description                   longtext,
  status                        varchar(1) not null,
  is_built_in                   tinyint(1) not null,
  is_formula                    tinyint(1) not null,
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint uq_mt_role_name unique (name),
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
  staff_name                    varchar(30) not null,
  account                       varchar(50) not null,
  email                         varchar(99),
  avatar                        varchar(512),
  mobile                        varchar(42),
  password                      varchar(128) not null,
  description                   longtext,
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
  staff_id                      bigint not null,
  role_id                       bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  constraint pk_mt_staff_role primary key (id)
);

create table mt_tenant (
  id                            bigint not null,
  start_time                    datetime(6) not null,
  end_time                      datetime(6) not null,
  leases                        bigint not null,
  company_id                    bigint not null,
  ds_type                       varchar(3) not null,
  status                        varchar(1) not null,
  version                       integer not null,
  last_mod_staff                bigint not null,
  deleted                       tinyint(1) default 0 not null,
  created_time                  datetime(6) not null,
  updated_time                  datetime(6) not null,
  constraint pk_mt_tenant primary key (id)
);

create index ix_mt_staff_account on mt_staff (account);
create index ix_mt_staff_email on mt_staff (email);
create index ix_mt_staff_mobile on mt_staff (mobile);
