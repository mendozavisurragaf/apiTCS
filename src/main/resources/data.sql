INSERT INTO usuario (email, password, nombre) VALUES ('example@outlook.com', '$2a$10$IYmYVLOs4X.L/67Ft2Io4O5RWwMg61DFTBrMC76vrkJx9J/jyfdii', 'admin');


INSERT INTO moneda (abreviatura, nombre) VALUES ('PEN', 'Nuevo Sol Peruano');
INSERT INTO moneda (abreviatura, nombre) VALUES ('USD', 'Dolar Estadounidense');
INSERT INTO moneda (abreviatura, nombre) VALUES ('MXN', 'Peso Mexicano');
INSERT INTO moneda (abreviatura, nombre) VALUES ('EUR', 'Euro');
INSERT INTO moneda (abreviatura, nombre) VALUES ('GBP', 'Libra Esterlina');

INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (0.2709, 1, 2);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (4.5217, 1, 3);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (0.2474, 1, 4);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (0.2118, 1, 5);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (3.6910, 2, 1);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (16.689, 2, 3);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (0.9132, 2, 4);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (0.7816, 2, 5);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (0.2212, 3, 1);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (0.05992, 3, 2);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (0.05472, 3, 4);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (0.04683, 3, 5);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (4.0417, 4, 1);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (1.0950, 4, 2);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (18.275, 4, 3);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (0.8559, 4, 5);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (4.7223, 5, 1);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (1.2794, 5, 2);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (21.353, 5, 3);
INSERT INTO tipo_cambio (cambio, moneda_origen_id, moneda_destino_id) VALUES (1.1684, 5, 4);