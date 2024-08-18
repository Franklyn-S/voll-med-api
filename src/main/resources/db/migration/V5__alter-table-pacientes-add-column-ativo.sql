ALTER TABLE pacientes add ativo tinyint;
update pacientes set ativo = 1;