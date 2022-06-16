-- apply changes
create table mt_acl_formula (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  name                          varchar2(255) not null,
  left_formula                  varchar2(255) not null,
  left_type                     varchar2(4) not null,
  symbol                        varchar2(1) not null,
  right_formula                 varchar2(255) not null,
  right_type                    varchar2(4) not null,
  status                        varchar2(1) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint ck_mt_acl_formula_left_type check ( left_type in ('1','2','4','1024')),
  constraint ck_mt_acl_formula_symbol check ( symbol in ('1','2','3','4','5','6')),
  constraint ck_mt_acl_formula_right_type check ( right_type in ('1','2','4','1024')),
  constraint ck_mt_acl_formula_status check ( status in ('0','1','2')),
  constraint uq_mt_acl_formula_name unique (name),
  constraint pk_mt_acl_formula primary key (id)
);

create table mt_company (
  id                            number(19) not null,
  name                          varchar2(255) not null,
  logo                          varchar2(512),
  principal                     varchar2(30) not null,
  mobile                        varchar2(42) not null,
  telephone                     varchar2(38),
  email                         varchar2(99),
  address                       varchar2(255),
  description                   clob,
  ext01                         clob,
  ext02                         clob,
  ext03                         clob,
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
  url                           varchar2(512) not null,
  username                      varchar2(48) not null,
  password                      varchar2(128) not null,
  driver_name                   varchar2(68) not null,
  type                          varchar2(1) not null,
  remark                        varchar2(512),
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
  description                   clob,
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
  parent_id                     number(19) not null,
  code                          varchar2(255) not null,
  name                          varchar2(255) not null,
  type                          varchar2(1) not null,
  description                   varchar2(255),
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint ck_mt_group_type check ( type in ('1','2','3','4')),
  constraint pk_mt_group primary key (id)
);

create table mt_group_staff (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  group_id                      number(19) not null,
  staff_id                      number(19) not null,
  post_id                       number(19),
  is_main                       number(1) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  constraint pk_mt_group_staff primary key (id)
);

create table mt_login_log (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  staff_id                      number(19) not null,
  account                       varchar2(50) not null,
  login_type                    varchar2(15) not null,
  logout_type                   varchar2(1),
  ip_addr                       varchar2(128),
  user_agent                    varchar2(255),
  os                            varchar2(255),
  screen                        varchar2(255),
  login_time                    timestamp not null,
  logout_time                   timestamp,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  constraint ck_mt_login_log_login_type check ( login_type in ('account','mobile','email','qq-auth','wechat','wechat-mini-app','github','gitee','baidu')),
  constraint ck_mt_login_log_logout_type check ( logout_type in ('1','2','3')),
  constraint pk_mt_login_log primary key (id)
);

create table mt_menu (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint pk_mt_menu primary key (id)
);

create table mt_online (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  login_id                      number(19) not null,
  token                         varchar2(255) not null,
  start_time                    timestamp not null,
  end_time                      timestamp not null,
  duration                      number(19) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint pk_mt_online primary key (id)
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
  parent_id                     number(19) not null,
  code                          varchar2(255) not null,
  name                          varchar2(255) not null,
  icon                          varchar2(512),
  description                   clob,
  is_built_in                   number(1) not null,
  status                        varchar2(1) not null,
  sorted                        number(10) not null,
  type                          varchar2(4) not null,
  is_formula                    number(1) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint ck_mt_permission_status check ( status in ('0','1','2')),
  constraint ck_mt_permission_type check ( type in ('1','2','4','8','16','1024')),
  constraint uq_mt_permission_code unique (code),
  constraint uq_mt_permission_name unique (name),
  constraint pk_mt_permission primary key (id)
);

create table mt_post (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  post                          varchar2(255) not null,
  sorted                        number(10) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint pk_mt_post primary key (id)
);

create table mt_role (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  code                          varchar2(255) not null,
  name                          varchar2(255) not null,
  sorted                        number(10) not null,
  description                   clob,
  status                        varchar2(1) not null,
  is_built_in                   number(1) not null,
  is_formula                    number(1) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint ck_mt_role_status check ( status in ('0','1','2')),
  constraint uq_mt_role_code unique (code),
  constraint uq_mt_role_name unique (name),
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
  staff_name                    varchar2(30) not null,
  account                       varchar2(50) not null,
  email                         varchar2(99),
  avatar                        varchar2(512),
  mobile                        varchar2(42),
  password                      varchar2(128) not null,
  description                   clob,
  expire_time                   timestamp,
  status                        varchar2(1) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint ck_mt_staff_status check ( status in ('0','1','2')),
  constraint pk_mt_staff primary key (id)
);

create table mt_staff_role (
  id                            number(19) not null,
  tenant_id                     number(19) not null,
  staff_id                      number(19) not null,
  role_id                       number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  constraint pk_mt_staff_role primary key (id)
);

create table mt_tenant (
  id                            number(19) not null,
  name                          varchar2(255) not null,
  start_time                    timestamp not null,
  end_time                      timestamp not null,
  leases                        number(19) not null,
  company_id                    number(19) not null,
  ds_type                       varchar2(3) not null,
  status                        varchar2(1) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint ck_mt_tenant_ds_type check ( ds_type in ('1','2','128')),
  constraint ck_mt_tenant_status check ( status in ('0','1','2')),
  constraint pk_mt_tenant primary key (id)
);

create table mt_web_domain (
  id                            number(19) not null,
  domain                        varchar2(255) not null,
  ipc_no                        varchar2(255),
  owner                         varchar2(255),
  email                         varchar2(255),
  register                      varchar2(255),
  creation_date                 timestamp,
  expiration_date               timestamp,
  tenant_id                     number(19) not null,
  description                   clob,
  status                        varchar2(1) not null,
  version                       number(10) not null,
  last_mod_staff                number(19) not null,
  deleted                       number(1) default 0 not null,
  created_time                  timestamp not null,
  updated_time                  timestamp not null,
  constraint ck_mt_web_domain_status check ( status in ('0','1','2')),
  constraint uq_mt_web_domain_domain unique (domain),
  constraint pk_mt_web_domain primary key (id)
);

create index ix_mt_staff_account on mt_staff (account);
create index ix_mt_staff_email on mt_staff (email);
create index ix_mt_staff_mobile on mt_staff (mobile);
