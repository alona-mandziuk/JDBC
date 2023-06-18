use clientbanking;
drop table accounts;
create table accounts
(
    accountNumber varchar(16) unique,
    currency      varchar(5),
    balance       double(10, 2),
    balanceInUAH  double(10, 2),
    type          varchar(10),
    block         boolean
);