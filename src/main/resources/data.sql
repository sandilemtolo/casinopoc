INSERT INTO transaction_type (tname) VALUES ('BALANCE_CHECK');
INSERT INTO transaction_type (tname) VALUES ('WIN');
INSERT INTO transaction_type (tname) VALUES ('WAGER');
INSERT INTO transaction_type (tname) VALUES ('REGISTER_PLAYER');

INSERT INTO promotions (code, applicaton_limit) VALUES ('PAPER', 5);


-- Test data
INSERT INTO player (username,name,surname,balance) VALUES('MRA','Mr','A',987654);
INSERT INTO player (username,name,surname,balance) VALUES('DRB','Dr','B',123456);

INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('10','1','2000-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('11','1','2001-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('12','1','2002-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('13','1','2003-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('14','1','2004-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('15','1','2005-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('16','1','2006-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('17','1','2007-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('18','1','2008-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('19','1','2009-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('20','1','2010-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('21','1','2011-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('22','1','2012-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('23','1','2013-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('24','1','2014-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('25','1','2015-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('26','1','2016-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('27','1','2017-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('28','1','2018-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('29','1','2019-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('30','1','2020-01-30T19:51:44.136+00:00',2,1000);

INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('31','1','2001-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('32','1','2002-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('33','1','2003-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('34','1','2004-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('35','1','2005-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('36','1','2006-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('37','1','2007-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('38','1','2008-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('39','1','2009-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('40','1','2010-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('41','1','2011-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('42','1','2012-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('43','1','2013-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('44','1','2014-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('45','1','2015-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('46','1','2016-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('47','1','2017-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('48','1','2018-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('49','1','2019-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('50','1','2020-01-30T19:51:44.136+00:00',3,1000);

INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('60','2','2000-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('61','2','2001-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('62','2','2002-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('63','2','2003-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('64','2','2004-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('65','2','2005-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('66','2','2006-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('67','2','2007-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('68','2','2008-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('69','2','2009-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('70','2','2010-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('71','2','2011-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('72','2','2012-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('73','2','2013-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('74','2','2014-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('75','2','2015-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('76','2','2016-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('77','2','2017-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('78','2','2018-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('79','2','2019-01-30T19:51:44.136+00:00',2,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('80','2','2020-01-30T19:51:44.136+00:00',2,1000);

INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('81','2','2001-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('82','2','2002-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('83','2','2003-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('84','2','2004-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('85','2','2005-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('86','2','2006-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('87','2','2007-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('88','2','2008-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('89','2','2009-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('90','2','2010-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('91','2','2011-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('92','2','2012-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('93','2','2013-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('94','2','2014-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('95','2','2015-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('96','2','2016-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('97','2','2017-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('98','2','2018-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('99','2','2019-01-30T19:51:44.136+00:00',3,1000);
INSERT INTO transactions (tid,pid,tdate,ttid,amount) VALUES('100','2','2020-01-30T19:51:44.136+00:00',3,1000);





