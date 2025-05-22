PEDRO LOTÉRIO DOS SANTOS RM550909  
LUCAS THOMAZETTE BENVENUTO RM98048  

# Checkpoint 2 – Sistema de Agenda de Consultas

Projeto foi feito com o clone do meu projeto do primeiro checkpoint, por conta disso meu arquivo está com o nome "checkpoint1" ;)

Projeto Java Spring Boot desenvolvido como parte do checkpoint da disciplina de Microservices (1º semestre/2025) – Prof. Antonio.

---

## Descrição

Sistema simples de agendamento de consultas entre pacientes e profissionais de saúde.  
A aplicação permite criar, listar, editar e excluir pacientes, profissionais e consultas.  
Os dados são mantidos **em memória**.

---

## Tecnologias

- Java 17  
- Spring Boot 3.4.4  
- Maven  
- Spring Web  
- SpringDoc OpenAPI (Swagger)  
- DevTools  

---

## Como executar

Rode o projeto com Maven:

```bash
mvn clean install
mvn spring-boot:run
Acesse no navegador:

bash
Copiar
http://localhost:8080/swagger-ui/index.html
Endpoints principais
Pacientes (/pacientes)
POST /pacientes: cria novo paciente


{
  "nome": "João da Silva",
  "endereco": "Rua das Palmeiras, 100",
  "bairro": "Centro",
  "email": "joao@email.com",
  "telefoneCompleto": "(11) 99999-8888"
}
GET /pacientes: lista todos

GET /pacientes/{id}: busca por ID

PUT /pacientes/{id}: atualiza paciente

DELETE /pacientes/{id}: deleta paciente

Profissionais (/profissionais)
POST /profissionais: cria profissional


{
  "nome": "Dra. Maria Andrade",
  "especialidade": "Psicologia",
  "valorHora": 150.0
}
GET /profissionais: lista todos

GET /profissionais/{id}: busca por ID

PUT /profissionais/{id}: atualiza profissional

DELETE /profissionais/{id}: deleta profissional

Consultas (/consultas)
POST /consultas: agendar nova consulta


{
  "profissionalId": 1,
  "pacienteId": 1,
  "dataConsulta": "2025-05-05T10:00:00",
  "statusConsulta": "AGENDADA",
  "quantidadeHoras": 2,
  "valorConsulta": 300.0
}
GET /consultas: lista todas

GET /consultas/{id}: busca por ID

PUT /consultas/{id}: atualiza dados da consulta

DELETE /consultas/{id}: remove consulta

Esses foram exemplos que fiz e funcionaram perfeitamente no Swagger.
O sistema está 100% funcional conforme o enunciado do checkpoint.
