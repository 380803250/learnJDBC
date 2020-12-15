drop table if exists t_user;

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   标识                   bigint not null,
   登录名                  varchar(255),
   登陆密码                 varchar(255),
   真实姓名                 varchar(255),
   primary key (标识)
);
