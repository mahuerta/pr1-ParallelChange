-- REMOVE THE COLUMN
ALTER TABLE book ADD new_price float(24);

UPDATE book SET book.new_price = book.price;
