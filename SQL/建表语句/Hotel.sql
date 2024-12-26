/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     2024/6/29 19:48:15                           */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Bill') and o.name = 'FK_BILL_HANDLING_HOTELSST')
alter table Bill
   drop constraint FK_BILL_HANDLING_HOTELSST
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Bill') and o.name = 'FK_BILL_PAY_CUSTOMER')
alter table Bill
   drop constraint FK_BILL_PAY_CUSTOMER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Customer') and o.name = 'FK_CUSTOMER_BOOKING_ROOM')
alter table Customer
   drop constraint FK_CUSTOMER_BOOKING_ROOM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Pre') and o.name = 'FK_PRE_PRE_CUSTOMER')
alter table Pre
   drop constraint FK_PRE_PRE_CUSTOMER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Pre') and o.name = 'FK_PRE_PRE2_ENTERTAI')
alter table Pre
   drop constraint FK_PRE_PRE2_ENTERTAI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Room') and o.name = 'FK_ROOM_BELONGING_BUILDING')
alter table Room
   drop constraint FK_ROOM_BELONGING_BUILDING
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('RoomService') and o.name = 'FK_ROOMSERV_NEED_ROOM')
alter table RoomService
   drop constraint FK_ROOMSERV_NEED_ROOM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Suggestions') and o.name = 'FK_SUGGESTI_ARISE_CUSTOMER')
alter table Suggestions
   drop constraint FK_SUGGESTI_ARISE_CUSTOMER
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Bill')
            and   name  = 'Handling_FK'
            and   indid > 0
            and   indid < 255)
   drop index Bill.Handling_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Bill')
            and   name  = 'Pay_FK'
            and   indid > 0
            and   indid < 255)
   drop index Bill.Pay_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Bill')
            and   type = 'U')
   drop table Bill
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Buildings')
            and   type = 'U')
   drop table Buildings
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Customer')
            and   name  = 'Booking_FK'
            and   indid > 0
            and   indid < 255)
   drop index Customer.Booking_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Customer')
            and   type = 'U')
   drop table Customer
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Entertainments')
            and   type = 'U')
   drop table Entertainments
go

if exists (select 1
            from  sysobjects
           where  id = object_id('HotelSstaff')
            and   type = 'U')
   drop table HotelSstaff
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Pre')
            and   name  = 'Pre_FK'
            and   indid > 0
            and   indid < 255)
   drop index Pre.Pre_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Pre')
            and   name  = 'Pre2_FK'
            and   indid > 0
            and   indid < 255)
   drop index Pre.Pre2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Pre')
            and   type = 'U')
   drop table Pre
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Room')
            and   name  = 'Belonging_FK'
            and   indid > 0
            and   indid < 255)
   drop index Room.Belonging_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Room')
            and   type = 'U')
   drop table Room
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('RoomService')
            and   name  = 'Need_FK'
            and   indid > 0
            and   indid < 255)
   drop index RoomService.Need_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('RoomService')
            and   type = 'U')
   drop table RoomService
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Suggestions')
            and   name  = 'Arise_FK'
            and   indid > 0
            and   indid < 255)
   drop index Suggestions.Arise_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Suggestions')
            and   type = 'U')
   drop table Suggestions
go

/*==============================================================*/
/* Table: Bill                                                  */
/*==============================================================*/
create table Bill (
   Bid                  varchar(10)          not null,
   Cid                  varchar(20)          null,
   HSid                 varchar(10)          null,
   Bprice               float                null,
   Btime                datetime             null,
   constraint PK_BILL primary key nonclustered (Bid)
)
go

/*==============================================================*/
/* Index: Pay_FK                                                */
/*==============================================================*/
create index Pay_FK on Bill (
Cid ASC
)
go

/*==============================================================*/
/* Index: Handling_FK                                           */
/*==============================================================*/
create index Handling_FK on Bill (
HSid ASC
)
go

/*==============================================================*/
/* Table: Buildings                                             */
/*==============================================================*/
create table Buildings (
   BLid                 int                  not null,
   BLname               varchar(20)          null,
   BLmangerid           varchar(10)          null,
   constraint PK_BUILDINGS primary key nonclustered (BLid)
)
go

/*==============================================================*/
/* Table: Customer                                              */
/*==============================================================*/
create table Customer (
   Name                 varchar(20)          not null,
   Cid                  varchar(20)          not null,
   Rid                  varchar(10)          not null,
   CphoneNumber         varchar(15)          not null,
   VIP                  bit                  not null,
   Intime               datetime             null,
   Outtime              datetime             null,
   Indeedin             datetime             null,
   Indeedout            datetime             null,
   Cpassword            varchar(20)          not null,
   constraint PK_CUSTOMER primary key nonclustered (Cid)
)
go

/*==============================================================*/
/* Index: Booking_FK                                            */
/*==============================================================*/
create index Booking_FK on Customer (
Rid ASC
)
go

/*==============================================================*/
/* Table: Entertainments                                        */
/*==============================================================*/
create table Entertainments (
   Eid                  varchar(10)          not null,
   Ename                varchar(10)          null,
   Esum                 int                  null,
   Ebook                int                  null,
   constraint PK_ENTERTAINMENTS primary key nonclustered (Eid)
)
go

/*==============================================================*/
/* Table: HotelSstaff                                           */
/*==============================================================*/
create table HotelSstaff (
   HSid                 varchar(10)          not null,
   HSname               varchar(20)          null,
   HSage                int                  null,
   HSposition           varchar(10)          null,
   HSPermissions        bit                  null,
   HSpassword           varchar(20)          null,
   constraint PK_HOTELSSTAFF primary key nonclustered (HSid)
)
go

/*==============================================================*/
/* Table: Pre                                                   */
/*==============================================================*/
create table Pre (
   Eid                  varchar(10)          not null,
   Cid                  varchar(20)          not null,
   Ptime                datetime             not null,
   Pid                  int                  not null,
   constraint PK_PRE primary key nonclustered (Pid)
)
go

/*==============================================================*/
/* Index: Pre2_FK                                               */
/*==============================================================*/
create index Pre2_FK on Pre (
Eid ASC
)
go

/*==============================================================*/
/* Index: Pre_FK                                                */
/*==============================================================*/
create index Pre_FK on Pre (
Cid ASC
)
go

/*==============================================================*/
/* Table: Room                                                  */
/*==============================================================*/
create table Room (
   Rid                  varchar(10)          not null,
   BLid                 int                  null,
   Rtype                varchar(10)          not null,
   Rprice               float                null,
   Rstate               varchar(10)          null,
   constraint PK_ROOM primary key nonclustered (Rid)
)
go

/*==============================================================*/
/* Index: Belonging_FK                                          */
/*==============================================================*/
create index Belonging_FK on Room (
BLid ASC
)
go

/*==============================================================*/
/* Table: RoomService                                           */
/*==============================================================*/
create table RoomService (
   RSid                 varchar(10)          not null,
   Rid                  varchar(10)          null,
   RScontent            varchar(100)         not null,
   RStime               datetime             null,
   constraint PK_ROOMSERVICE primary key nonclustered (RSid)
)
go

/*==============================================================*/
/* Index: Need_FK                                               */
/*==============================================================*/
create index Need_FK on RoomService (
Rid ASC
)
go

/*==============================================================*/
/* Table: Suggestions                                           */
/*==============================================================*/
create table Suggestions (
   Sid                  varchar(10)          not null,
   Cid                  varchar(20)          null,
   Scontent             varchar(100)         null,
   Stime                datetime             null,
   constraint PK_SUGGESTIONS primary key nonclustered (Sid)
)
go

/*==============================================================*/
/* Index: Arise_FK                                              */
/*==============================================================*/
create index Arise_FK on Suggestions (
Cid ASC
)
go

alter table Bill
   add constraint FK_BILL_HANDLING_HOTELSST foreign key (HSid)
      references HotelSstaff (HSid)
go

alter table Bill
   add constraint FK_BILL_PAY_CUSTOMER foreign key (Cid)
      references Customer (Cid)
go

alter table Customer
   add constraint FK_CUSTOMER_BOOKING_ROOM foreign key (Rid)
      references Room (Rid)
go

alter table Pre
   add constraint FK_PRE_PRE_CUSTOMER foreign key (Cid)
      references Customer (Cid)
go

alter table Pre
   add constraint FK_PRE_PRE2_ENTERTAI foreign key (Eid)
      references Entertainments (Eid)
go

alter table Room
   add constraint FK_ROOM_BELONGING_BUILDING foreign key (BLid)
      references Buildings (BLid)
go

alter table RoomService
   add constraint FK_ROOMSERV_NEED_ROOM foreign key (Rid)
      references Room (Rid)
go

alter table Suggestions
   add constraint FK_SUGGESTI_ARISE_CUSTOMER foreign key (Cid)
      references Customer (Cid)
go

