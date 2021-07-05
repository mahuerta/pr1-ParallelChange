ALTER TABLE book ADD price float(24);

UPDATE book SET book.price = book.new_price;
