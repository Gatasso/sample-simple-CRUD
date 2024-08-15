ALTER TABLE product ADD COLUMN is_active BOOLEAN;
UPDATE product SET is_active = true;