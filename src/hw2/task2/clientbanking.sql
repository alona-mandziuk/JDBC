use clientbanking;

create table accounts
(
    accountNumber varchar(16) unique,
    currency      varchar(5),
    balance       double(10, 2),
    balanceInUAH  double(10, 2),
    type          varchar(10),
    block         varchar(10)
);