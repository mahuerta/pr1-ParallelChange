-- REMOVE THE COLUMN
ALTER TABLE book DROP description;

-- ADD CONSTRAINTS
UPDATE book SET preface='' WHERE preface IS NULL;

ALTER TABLE book MODIFY preface VARCHAR(5000) NOT NULL;
