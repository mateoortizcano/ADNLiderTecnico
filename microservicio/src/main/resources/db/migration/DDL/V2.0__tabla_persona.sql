CREATE TABLE tipo_documento (
    id INT NOT NULL auto_increment,
    nombre VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE personas (
    id INT NOT NULL auto_increment,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    edad INT NULL,
    tipo_documento_id INT NOT NULL,
    numero_documento VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK__persona_tipo_documento FOREIGN KEY (tipo_documento_id) REFERENCES tipo_documento(id)
);