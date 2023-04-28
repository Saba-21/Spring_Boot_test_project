CREATE TABLE IF NOT EXISTS FILES (
    ID BIGINT NOT NULL AUTO_INCREMENT,
    FILE_NAME VARCHAR(255),
    DATA BLOB,
    CONTENT_TYPE VARCHAR(255),
    PRIMARY KEY (ID)
);