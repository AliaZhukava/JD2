create schema gym_storage;

SET SEARCH_PATH TO gym_storage;

CREATE TABLE training (
  id BIGSERIAL PRIMARY KEY,
  name CHARACTER VARYING(128) NOT NULL,
  level CHARACTER VARYING(128) NOT NULL
);

CREATE TABLE gym_user (
  id BIGSERIAL PRIMARY KEY,
  login CHARACTER VARYING(128) NOT NULL UNIQUE,
  password CHARACTER VARYING(128) NOT NULL,
  gym_user_role CHARACTER VARYING(128) NOT NULL,
  name CHARACTER VARYING(128) UNIQUE NOT NULL,
  phone_number BIGINT NOT NULL,
  email CHARACTER VARYING(128) NOT NULL UNIQUE
 );

CREATE TABLE review (
  id BIGSERIAL PRIMARY KEY,
  date TIMESTAMP NOT NULL,
  text CHARACTER VARYING (528) NOT NULL,
  gym_user_id BIGINT REFERENCES gym_user (id)
);

CREATE TABLE trainer (
  id BIGSERIAL PRIMARY KEY,
  gym_user_id BIGINT UNIQUE REFERENCES gym_user (id),
  category CHARACTER VARYING(128) NOT NULL
);

CREATE TABLE gym_program (
  id BIGSERIAL PRIMARY KEY,
  name CHARACTER VARYING(128) NOT NULL,
  trainer_id BIGINT REFERENCES trainer (id),
  training_id BIGINT REFERENCES training (id),
  time time not null ,
  day_of_week CHARACTER VARYING(128) NOT NULL,
  cost INTEGER NOT NULL
);

CREATE TABLE client (
  id BIGSERIAL PRIMARY KEY,
  gym_user_id BIGINT UNIQUE REFERENCES gym_user (id),
  bonus_count INTEGER
);

CREATE TABLE client_gym_program (
  id BIGSERIAL PRIMARY KEY,
  client_id BIGINT REFERENCES client (id),
  gym_program_id BIGINT REFERENCES gym_program (id)
);