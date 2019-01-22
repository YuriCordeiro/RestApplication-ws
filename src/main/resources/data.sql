-- Insert some cities data--
insert into TB_CITY (ID, NAME, PROVINCE)
values(SEQ_CITY.NEXTVAL,'Americana', 'SP');

insert into TB_CITY (ID, NAME, PROVINCE)
values(SEQ_CITY.NEXTVAL,'Bauru', 'SP');

insert into TB_CITY (ID, NAME, PROVINCE)
values(SEQ_CITY.NEXTVAL,'Guarulhos', 'SP');

-- Insert Costumers --
insert into TB_COSTUMER (ID, COMPLETENAME, GENDER, BIRTHDATE, AGE, CITY_ID)
values(SEQ_COSTUMER.NEXTVAL, 'Yuri Cordeiro', 'Masculino', TO_DATE('11/12/1996', 'dd/MM/yyyy'), 22, 2);

insert into TB_COSTUMER (ID, COMPLETENAME, GENDER, BIRTHDATE, AGE, CITY_ID)
values(SEQ_COSTUMER.NEXTVAL, 'Aline Murback', 'Feminino', TO_DATE('11/12/1994', 'DD/MM/YYYY'), 24, 1);

insert into TB_COSTUMER (ID, COMPLETENAME, GENDER, BIRTHDATE, AGE, CITY_ID)
values(SEQ_COSTUMER.NEXTVAL, 'Thomas Murback', 'Feminino', TO_DATE('11/12/1970', 'DD/MM/YYYY'), 48, 3);
