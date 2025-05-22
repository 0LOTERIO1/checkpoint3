PEDRO LOTÉRIO DOS SANTOS RM550909  
LUCAS THOMAZETTE BENVENUTO RM98048  

# Checkpoint 3 – Sistema de Agenda de Consultas

Projeto Java Spring Boot desenvolvido como parte do Checkpoint 3 da disciplina de Microservices (1º semestre/2025 – FIAP – Prof. Antonio Carlos de Lima Júnior).

---

## Descrição

Sistema completo de agendamento de consultas entre pacientes e profissionais de saúde.  
Permite criar, listar, editar e excluir pacientes, profissionais e consultas.  
Inclui filtros avançados para consultas por status e intervalo de datas, além de estatísticas por profissional.  
Dados são mantidos em memória, sem banco de dados.

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

1. No terminal, na pasta do projeto, rode:

```bash
mvn clean install
mvn spring-boot:run
Abra a documentação Swagger:


http://localhost:8080/swagger-ui/index.html
Endpoints principais
Pacientes (/pacientes)
POST /pacientes – cria um paciente:

json
Copiar
{
  "nome": "João da Silva",
  "endereco": "Rua das Palmeiras, 100",
  "bairro": "Centro",
  "email": "joao@email.com",
  "telefoneCompleto": "(11) 99999-8888"
}
GET /pacientes – lista todos

GET /pacientes/{id} – busca por ID

PUT /pacientes/{id} – atualiza paciente

DELETE /pacientes/{id} – remove paciente

Profissionais (/profissionais)
POST /profissionais – cria profissional:


{
  "nome": "Dra. Maria Andrade",
  "especialidade": "Psicologia",
  "valorHora": 150.0
}
GET /profissionais – lista todos

GET /profissionais/{id} – busca por ID

PUT /profissionais/{id} – atualiza profissional

DELETE /profissionais/{id} – remove profissional

GET /profissionais/{id}/stats – retorna total recebido e total de horas do profissional

Consultas (/consultas)
POST /consultas – agenda nova consulta:


{
  "profissionalId": 1,
  "pacienteId": 1,
  "dataConsulta": "2025-05-05T10:00:00",
  "statusConsulta": "AGENDADA",
  "quantidadeHoras": 2,
  "valorConsulta": 0
}
Nota: O valor da consulta é calculado automaticamente multiplicando quantidadeHoras pelo valorHora do profissional.

GET /consultas – lista todas as consultas

GET /consultas/{id} – busca por ID

PUT /consultas/{id} – atualiza dados da consulta

DELETE /consultas/{id} – remove consulta

Endpoints com filtros avançados
GET /consultas?status={AGENDADA,REALIZADA,CANCELADA}&data_de=dd-MM-yyyy'T'HH:mm&data_ate=dd-MM-yyyy'T'HH:mm
Lista consultas filtrando por status e intervalo de datas.

GET /pacientes/{id}/consultas?status=...&data_de=...&data_ate=...
Lista consultas filtrando pelo paciente.

GET /profissionais/{id}/consultas?status=...&data_de=...&data_ate=...
Lista consultas filtrando pelo profissional.

Exemplo de filtro por consulta

GET /consultas?status=AGENDADA&data_de=24-04-2025T00:00&data_ate=30-04-2025T23:59
Observações finais
Todos os dados são mantidos em memória, para simplificar o projeto.

O sistema está pronto para testes via Swagger UI ou Postman.

Código modularizado seguindo padrão MVC e boas práticas REST.
