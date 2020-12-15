drop table if exists t_act;                           
create table t_cat(                                   
		actno int,                                       
		balance double(7,2)                              
);                                                    
insert into t_cat(actno, balance) VALUES(111, 20000); 
insert into t_cat(actno, balance) VALUES(222, 0);     
commit;                                               
select * from t_act;                                  