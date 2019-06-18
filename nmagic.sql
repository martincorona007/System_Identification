CREATE DATABASE number_magics;
use number_magics;
CREATE TABLE Ctrl_user(
	ID_user INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(70) NOT NULL,
	password VARCHAR(70) NOT NULL,
	FK_user_type INT NOT NULL,
	FK_permit_type INT NOT NULL,
	PRIMARY KEY(ID_user)

);
CREATE TABLE permit_type(/*dad*/
	ID_permit INT NOT NULL AUTO_INCREMENT,
	description VARCHAR(50) NOT NULL,
	PRIMARY KEY(ID_permit)

);
CREATE TABLE user_type(
	ID_type INT NOT NULL AUTO_INCREMENT,
	description VARCHAR(50) NOT NULL,
	PRIMARY KEY(ID_type)

);
CREATE TABLE nummagic(
	ID_num INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(150) NOT NULL,
	nombre_paterno VARCHAR(150) NOT NULL,
	nombre_materno VARCHAR(150) NOT NULL,
	Fechanacimiento VARCHAR(50) NOT NULL,
	numero_personas INT NOT NULL,
	numero_hersec INT NOT NULL,
	numero_per INT NOT NULL,
	numero_des INT NOT NULL,
	numero_superper1 INT NOT NULL,
	numero_superper2 INT NOT NULL,
	numero_subben INT NOT NULL,
    PRIMARY KEY(ID_num)
);


ALTER TABLE Ctrl_user ADD CONSTRAINT FOREIGN KEY(FK_user_type) REFERENCES user_type(ID_type);
ALTER TABLE Ctrl_user ADD CONSTRAINT FOREIGN KEY(FK_permit_type) REFERENCES permit_type(ID_permit);

INSERT INTO Ctrl_user(username,password,FK_user_type,FK_permit_type) VALUES ('donnadie','666',2,4);
INSERT INTO Ctrl_user(username,password,FK_user_type,FK_permit_type) VALUES ('donnadie2','666',2,3);
INSERT INTO Ctrl_user(username,password,FK_user_type,FK_permit_type) VALUES ('donnadie3','666',2,2);
INSERT INTO Ctrl_user(username,password,FK_user_type,FK_permit_type) VALUES ('donnadie4','666',1,1);

INSERT INTO permit_type(description) VALUES ('search');
INSERT INTO permit_type(description) VALUES ('search/insert');
INSERT INTO permit_type(description) VALUES ('search/insert/delete');
INSERT INTO permit_type(description) VALUES ('search/insert/delete/update');

INSERT INTO user_type(description) VALUES ('user');
INSERT INTO user_type(description) VALUES ('admin');

CREATE TABLE Info(
	ID_in INT NOT NULL AUTO_INCREMENT,
	data LONGTEXT NOT NULL,
	PRIMARY KEY(ID_in)
);

INSERT INTO Info(data) VALUES("1 (UNO)
  El 1 está predestinado para ocupar el primer puesto... ì
o el último; ello depende de que pueda expresar todos los ì
aspectos de su profunda personalidad o de que se vea ì
obligado a reprimirlos.
  El 1 es el número más fuerte, pero también el más ì
difícil de llevar.
  Es el número de la creación y de la invención. Pero, ì
así mismo, es el número que corresponde a una ì
personalidad que no se ata con los detalles.
  El 1 es bastante solitario aun cuando, a veces, muestra ì
una apariencia de desenvoltura en sociedad. También es ì
bastante atractivo y sensual, pero no pierde jamás su ì
punto de mira. En realidad, no puede considerarsele 
interesado, sino más bien oportunista.
  El 1 está dotado de un temperamento nervioso, con el ì
espíritu siempre al acecho. Es capaz de realizar ì
gigantescos esfuerzos para alcanzar su meta.
  Cuando ocupa el primer puesto, el 1 está temiendo ì
continuamente perderlo. Y cuando no lo ocupa, puede ì
sufrir y agriarse hasta el extremo de volverse celoso.

NOMBRES MASCULINOS              NOMBRE FEMENIMOS
ALBERTO                         ADELINA
ALFONSO                         ALFONSINA
CESAR                           AMALIA
COSME                           AMPARO
DIMAS                           BERTA
ELIAS                           CAROLINA
EVARISTO                        ELENA
GIL                             ELISA
ISRAEL                          EVA
IVAN                            FAUSTINA
JACOBO                          GABRIELA
JORGE                           GENOVEVA
JUAN                            HORTENSIA
LEON                            IRIS
LEONCIO                         LUCIA
NESTOR                          MARIA JOSE
NICOLAS                         MATILDE
PABLO                           MELANIA
PASCUAL                         MONICA
PATRICIO                        NIDIA
SERGIO                          SABINA
VALERIO                         SABRINA
VICENTE                         SONSOLES");
INSERT INTO Info(data) VALUES(" 2 (DOS)
  EL 2 está predestinado para tener contactos con los ì
demás seres humanos.
  Sensible y emotivo, el 2 no puede quedarse impasible ì
ante el infortunio de otros ni ante la angustia humana.   ì
Tiene el gusto de lo social y no soporta ver el ì
sufrimiento de los demás.
  El 2 antepone el trabajo silicioso, pero eficaz, por el ì
bienestar de sus semejantes, a la gloria y el triunfo ì
personal.
  El 2 es amado por los jovenes por los infortunados y ì
por los desdichados que son capaces de captar en él, a ì
veces tras una apariencia de frialdad, toda la ì
sensibilidad y la emotividad propia de este número.
  El 2 debe cuidarse de caer en la sensiblería que le ì
impediría actuar. En general, el 2 sabe permanecer en ì
calma; es indulgente y generoso, a veces hipócrita y a ì
menudo terco. Asi mismo, es porfiado, sabe acometer una ì
empresa con obstinación y, por consiguiente, la mayor ì
parte de las veces logra llevar a buen fin lo que ha ì
comenzado.
  Considerado a vecves como extravagante a causa de la ì
complejidad de su temperamento apasionado, capaz de todos ì
los excesos en medio de la calma más aparente, el 2 ì
raramente conoce una vida vulgar, a menos que le sea ì
totalmente imposible expresar todos sus recursos, siempre ì
numerosos.
  El 2 a veces se protege adoptando una actitud de zumba ì
y burla, que es más vehemente que dañina.

NOMBRES MASCULINOS              NOMBRE FEMENIMOS
ADAN                            AMALIA
ADRIAN                          ANTONIA
ARNALDO                         AURORA
BALTASAR                        BELEN
BARTOLOME                       DIANA
BERNABE                         ENRIQUETA
CLAUDIO                         ESTRELLA
FEDERICO                        FLORENCIA
FELICIANO                       FRANCISCA
FELIX                           INES
FLAVIO                          JOSEFA
FLORENTINO                      JUANA
JAIME                           MARIA TERESA
JAVIER                          MARINA
JESUS                           PAULINA
JOSE ANTONIO                    PILAR
JUAN PABLO                      RAQUEL
LUCAS                           SALOME
MARIO                           URSULA
MELCHOR
OSCAR
TEODORO");
INSERT INTO Info(data) VALUES("3 (TRES)
  El 3 es el número de la originalidad y de la creación.  ì
  El 3 debe tratar de expresar su talento mediante un ì
arte gráfico, plástico o dramático, si ello le es ì
posible.
  El 3 tiene una naturaleza emocional muy fuerte que ì
puede señalar con su impronta toda una vida y, en ì
particular, un trabajo.
  Para realizar plenamente su obra, el 3 tiene necesidad ì
de ser estimulado y elogiado con frecuencia. De lo que ì
podemos deducir que es bastante sensible al halago.
  El 3 se adapta fácilmente, comprende de prisa y puedeì
tomar decisiones importantes instantáneamente. Posee un ì
espíritu práctico y es inteligente, pero también astuto.
  El 3 tiene un temperamento apasionado, animoso y ì
combativo. Es ambicioso y orgulloso, pero si exagera ì
estas tendencias puede llegar a volverse vanidoso y ebrio ì
de gloria.

NOMBRES MASCULINOS          NOMBRE FEMENINOS
CASTOR                      ANA MARIA
CIRIACO                     ANGELA
DAVID                       CORAL
DIEGO                       ELVIRA
EUGENIO                     EMILIA
GERMAN                      JACINTA
GREGORIO                    LOLA
GUILLERMO                   LOURDES
IGNACIO                     MANUELA
JOSE                        MARIETA
JUAN BAUTISTA               MARTINA
JULIAN                      MARY SOL
MARCELO                     MILAGROS
MIGUEL                      NATALIA
OCTAVIO                     PALOMA
PEDRO                       SONIA
REMIGIO
RODOLFO
ROMULO");
INSERT INTO Info(data) VALUES("4 (CUATRO)
  El número 4 es de la organización (cuadrado = 4 ángulos ì
rectos y 4 lados ), la estabilidad.
  Por lo tanto, el 4 sabe emprender y organizar más que ì
mandar o dirigir. 
  El 4 tiene una gran capacidad de trabajo; puede ì
apasionarse por él si concederse un momento de respiro ì
hasta el cumplimiento final de su objetivo. Su ì
encarnizado apasionamiento puede resultar a veces incluso ì
embarazoso.
  El 4 generalmente es bastante apreciado por sus jefes y ì
sus patrones. No le gusta el desorden.
  El 4 es un buen y leal ayudante que raramente busca los ì
puestos de gran responsibilidad, y menos aún trata de ì
arrebatar lo primeros lugares a los demás.
  De forma general, es 4 sabe compaginar la flexibilidad ì
con la prudencia.
  Si el 4 parece a veces demasiado rutinario, e incluso ì
maniático, hay que poner ensu activo su agudo sentido de ì
la justicia y su amor a la familia, bien equilibrada y ì
respetable.

NOMBRES MASCULINOS          NOMBRE FEMENINOS
CASTOR                      ANA MARIA
CIRIACO                     ANGELA
DAVID                       CORAL
DIEGO                       ELVIRA
EUGENIO                     EMILIA
GERMAN                      JACINTA
GREGORIO                    LOLA
GUILLERMO                   LOURDES
IGNACIO                     MANUELA
JOSE                        MARIETA
JUAN BAUTISTA               MARTINA
JULIAN                      MARY SOL
MARCELO                     MILAGROS
MIGUEL                      NATALIA
OCTAVIO                     PALOMA
PEDRO                       SONIA
REMIGIO
RODOLFO
ROMULO");

