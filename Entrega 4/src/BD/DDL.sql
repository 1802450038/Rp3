CREATE TABLE cliente (
	cli_id INTEGER PRIMARY KEY AUTOINCREMENT,
	cli_nome TEXT NOT NULL,
	cpf TEXT NOT NULL
);

CREATE TABLE tipo_funcionario (
   	tipo_id INTEGER PRIMARY KEY AUTOINCREMENT,
   	tipo_nome TEXT	
 );
 
 CREATE TABLE funcionario (
  	funcionario_id INTEGER PRIMARY KEY AUTOINCREMENT,
  	tipo_id INTEGER,
  	login TEXT UNIQUE,
  	senha TEXT,
    FOREIGN KEY (tipo_id) REFERENCES tipo_funcionario (tipo_id)
  );
  
CREATE TABLE produto (
  	pro_id INTEGER PRIMARY KEY AUTOINCREMENT,
  	pro_nome text NOT NULL,
  	descricao text,
  	valor REAL,
  	quantidade INTEGER
  );
  
  CREATE TABLE status (
    status_id INTEGER PRIMARY KEY AUTOINCREMENT,
    status    TEXT    UNIQUE
);

CREATE TABLE venda (
	ven_id INTEGER PRIMARY KEY AUTOINCREMENT,
	ven_data TEXT,
	ven_total REAL,
	cli_id INTEGER,
	vendedor_id INTEGER,
	status_id INTEGER,
	FOREIGN KEY(cli_id) REFERENCES cliente (cli_id)
	FOREIGN KEY(vendedor_id) REFERENCES funcionario (funcionario_id)
	FOREIGN KEY(status_id) REFERENCES status (status_id) DEFAULT (0)
);
  
CREATE TABLE venda_produto (
  	venda_produto_id INTEGER PRIMARY KEY AUTOINCREMENT,
  	ven_id INTEGER,
  	pro_id INTEGER,
  	pro_quantidade INTEGER,
  	FOREIGN KEY (ven_id) REFERENCES venda (ven_id)
  	FOREIGN KEY (pro_id) REFERENCES produto (pro_id)
 );
 
CREATE TABLE troca (
	troca_id INTEGER PRIMARY KEY AUTOINCREMENT,
  	ven_id INTEGER,
  	valor_cupom INTEGER,
  	FOREIGN KEY (ven_id) REFERENCES venda (ven_id)
  
  );
  
CREATE TABLE troca_produto (
  	troca_produto_id INTEGER PRIMARY KEY AUTOINCREMENT,
  	troca_id INTEGER,
  	pro_id INTEGER,
  	pro_quantidade INTEGER,
  	FOREIGN KEY (troca_id) REFERENCES troca (troca_id)
  	FOREIGN KEY (pro_id) REFERENCES produto (pro_id)
 );
 

  
 
 