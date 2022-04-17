create table eataewonMember(
    id varchar(50) not null,
    name varchar(50) not null,
    pwd varchar(50) not null,
    email varchar(100) not null,
    nickname varchar(50) not null,
    profilpic varchar(100),
    likepoint int,
    profilmsg varchar(500),
    del int,
    constraint pk_eataewonMember primary key(id)
);

create sequence bbsseq
start with 1
increment by 1;


create table eataewonBbs(
    id varchar(50) not null,
    nickname varchar(50),
    seq int ,
    title varchar(500) not null,
    content varchar(4000) not null,
    picture varchar(4000),
    hashtag varchar(500),
    wdate timestamp,
    shopname varchar(100),
    address varchar(500),
    shopphnum varchar(50),
    shopurl varchar(100),
    latitude number(12,8),
    longitude number(12,8),
    readcnt int,
    likecnt int,
    constraint pk_eataewonBbs primary key(seq)
);

ALTER TABLE eataewonBbs ADD CONSTRAINT FK_id FOREIGN KEY(id) REFERENCES eataewonMember(id);



create table eataewonScrap(
    id varchar(50) not null,
    bbsseq int not null,
    seq int,
    constraint pk_scrap_seq primary key(seq)
);

create sequence scrapseq
start with 1
increment by 1;

ALTER TABLE eataewonScrap ADD CONSTRAINT FK_scrapId FOREIGN KEY(id) REFERENCES eataewonMember(id);
ALTER TABLE eataewonScrap ADD CONSTRAINT FK_scrapSeq FOREIGN KEY(bbsseq) REFERENCES eataewonBbs(seq);


create table eataewonLike(
    id varchar(50) not null,
    bbsseq int not null,
    seq int,
    constraint pk_like_seq primary key(seq)
);

create sequence likeseq
start with 1
increment by 1;

ALTER TABLE eataewonLike ADD CONSTRAINT FK_likeId FOREIGN KEY(id) REFERENCES eataewonMember(id);
ALTER TABLE eataewonLike ADD CONSTRAINT FK_likeSeq FOREIGN KEY(bbsseq) REFERENCES eataewonBbs(seq);

