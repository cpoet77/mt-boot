-- apply changes
create table mt_company (
  id                            number(19) not null,
  name                          varchar2(98) not null,
  logo                          varchar2(300),
  principal                     varchar2(32) not null,
  mobile                        varchar2(35) not null,
  telephone                     varchar2(35),
  email                         varchar2(99),
  address                       varchar2(255),
  description                   clob,
  ext01                         blob,
  ext02                         TEXT,
  ext03                         TEXT,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint uq_mt_company_name unique (name),
  constraint pk_mt_company primary key (id)
);

create table mt_datasource (
  id                            number(19) not null,
  name                          varchar2(255) not null,
  group_id                      number(19) not null,
  url                           varchar2(320) not null,
  username                      varchar2(48) not null,
  password                      varchar2(128) not null,
  driver_name                   varchar2(68) not null,
  type                          varchar2(1) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint ck_mt_datasource_type check ( type in ('1','2','3','4')),
  constraint uq_mt_datasource_name unique (name),
  constraint pk_mt_datasource primary key (id)
);

create table mt_datasource_group (
  id                            number(19) not null,
  name                          varchar2(255) not null,
  description                   TEXT,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint uq_mt_datasource_group_name unique (name),
  constraint pk_mt_datasource_group primary key (id)
);

create table mt_group (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint pk_mt_group primary key (id)
);

create table mt_group_staff (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  group_id                      number(19),
  staff_id                      number(19),
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  constraint pk_mt_group_staff primary key (id)
);

create table mt_login_log (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  constraint pk_mt_login_log primary key (id)
);

create table mt_operator_log (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  constraint pk_mt_operator_log primary key (id)
);

create table mt_option (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint pk_mt_option primary key (id)
);

create table mt_permission (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint pk_mt_permission primary key (id)
);

create table mt_role (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint pk_mt_role primary key (id)
);

create table mt_role_permission (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  role_id                       number(19),
  permission_id                 number(19),
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  constraint pk_mt_role_permission primary key (id)
);

create table mt_staff (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  staff_name                    varchar2(255),
  account                       varchar2(255),
  email                         varchar2(255),
  avatar                        varchar2(255),
  mobile                        varchar2(255),
  password                      varchar2(255),
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint pk_mt_staff primary key (id)
);

create table mt_staff_role (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  staff_id                      number(19),
  role_id                       number(19),
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  constraint pk_mt_staff_role primary key (id)
);

create table mt_tenant (
  id                            number(19) not null,
  start_time                    timestamp not null,
  end_time                      timestamp not null,
  leases                        number(19) not null,
  company_id                    number(19),
  ds_type                       varchar2(3),
  status                        varchar2(1),
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint ck_mt_tenant_ds_type check ( ds_type in ('1','2','128')),
  constraint ck_mt_tenant_status check ( status in ('0','1','2')),
  constraint pk_mt_tenant primary key (id)
);

