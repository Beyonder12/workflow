CREATE ROLE "myservice-user" WITH
    LOGIN
    SUPERUSER
    INHERIT
    CREATEDB
    CREATEROLE
    NOREPLICATION
    PASSWORD 'myservice-pass';

CREATE DATABASE myservice
    WITH
    OWNER = "myservice-user"
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE DATABASE keycloak
    WITH
    OWNER = "myservice-user"
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;    

CREATE DATABASE dataindex
    WITH
    OWNER = "myservice-user"
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;    

GRANT ALL PRIVILEGES ON DATABASE myservice TO "myservice-user";
GRANT ALL PRIVILEGES ON DATABASE keycloak TO "myservice-user";
GRANT ALL PRIVILEGES ON DATABASE dataindex TO "myservice-user";
GRANT ALL PRIVILEGES ON DATABASE myservice TO postgres;
