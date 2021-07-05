UPDATE book SET book.preface = book.description;

-- DROPPING THE NOT NULL CONSTRAINT
ALTER TABLE book MODIFY COLUMN description varchar(5000) NULL DEFAULT NULL;
