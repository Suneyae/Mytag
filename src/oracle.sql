-- Create table
create table MYLOG
(
  req    VARCHAR2(1000),
  aae036 NUMBER(14),
  aae037 VARCHAR2(20)
)
tablespace GGYW_DATA01
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table MYLOG
  is '登录日记表(自用的)';
-- Add comments to the columns 
comment on column MYLOG.req
  is '请求参数日记';
comment on column MYLOG.aae036
  is '插入日记时间';
comment on column MYLOG.aae037
  is '插入时间';
