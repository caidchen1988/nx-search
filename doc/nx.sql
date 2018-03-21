


drop table if exists nx_search;

/*==============================================================*/
/* Table: nx_search                                             */
/*==============================================================*/
create table nx_search
(
   id                   bigint(20) not null auto_increment,
   ins_code             varchar(50) not null,
   report_number        varchar(100),
   policy_number        varchar(100) not null,
   insured              varchar(50) not null,
   risk_date            date,
   claim_amount         decimal(10,2),
   closing_date         date,
   id_card              varchar(100) not null,
   primary key (id)
);
