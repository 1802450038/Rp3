INSERT INTO tipo_funcionario (tipo_id, tipo_nome) VALUES 
	(0,'Model.Gerente'), (1,'Model.Vendedor'), (2,'Model.Caixa');
	
INSERT INTO status (status_id, status) VALUES 
	(0,'Pendente'), (1,'Concluído');

INSERT INTO funcionario (tipo_id,login,senha) VALUES 
	(0,'Model.Gerente','gerente01'),
	(1,'Model.Vendedor','Vendedor01'),
	(2,'Model.Caixa','Caixa01');
	
INSERT INTO produto (pro_nome,descricao,valor,quantidade) VALUES
	('Bola de basquete','bola profissional',39.90,15);
