ALTER TABLE ticket DROP CONSTRAINT IF EXISTS ticket_user_profile_id_fkey;
ALTER TABLE user_profile RENAME TO users;
ALTER TABLE users RENAME COLUMN user_profile_id TO user_id;

ALTER TABLE ticket RENAME COLUMN user_profile_id TO user_id;
ALTER TABLE ticket ADD CONSTRAINT ticket_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(user_id);

CREATE TABLE roles (
    role_id TEXT PRIMARY KEY,
    name TEXT NOT NULL UNIQUE
);

CREATE TABLE users_roles (
    user_id TEXT REFERENCES users(user_id),
    role_id TEXT REFERENCES roles(role_id),
    PRIMARY KEY (user_id, role_id)
);

INSERT INTO roles (role_id, name) VALUES
('r1', 'ROLE_ADMIN'),
('r2', 'ROLE_USER');

UPDATE users SET password = '$2a$10$1mcfEh9GYUZzPbTQnYelnuxkPbaCtK/sZnuDgtsrUTS7pIzSHM0sm' WHERE user_id = 'u1';
UPDATE users SET password = '$2a$10$1mcfEh9GYUZzPbTQnYelnuxkPbaCtK/sZnuDgtsrUTS7pIzSHM0sm' WHERE user_id = 'u2';
UPDATE users SET password = '$2a$10$1mcfEh9GYUZzPbTQnYelnuxkPbaCtK/sZnuDgtsrUTS7pIzSHM0sm' WHERE user_id = 'u3';

INSERT INTO users_roles (user_id, role_id) VALUES
('u1', 'r1'),
('u1', 'r2'),
('u2', 'r2'),
('u3', 'r2');
