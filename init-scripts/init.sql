-- Create category table
CREATE TABLE `category` (
  `CategoryID` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Create customer table
CREATE TABLE `customer` (
  `CustomerID` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CustomerID`),
  UNIQUE KEY `Email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Create supplier table
CREATE TABLE `supplier` (
  `SupplierID` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(255) NOT NULL,
  `contact_email` varchar(255) DEFAULT NULL,
  `contact_phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`SupplierID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Create product table
CREATE TABLE `product` (
  `ProductID` int(11) NOT NULL AUTO_INCREMENT,
  `CategoryID` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `image_URL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ProductID`),
  KEY `FK_Category_Product` (`CategoryID`),
  CONSTRAINT `FK_Category_Product` FOREIGN KEY (`CategoryID`) REFERENCES `category` (`CategoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Create address table
CREATE TABLE `address` (
  `AddressID` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerID` int(11) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip_code` varchar(10) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AddressID`),
  KEY `FK_Customer_Address` (`CustomerID`),
  CONSTRAINT `FK_Customer_Address` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Create order table
CREATE TABLE `order` (
  `OrderID` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerID` int(11) DEFAULT NULL,
  `order_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `status` varchar(50) DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  `payment_method_id` int(11) DEFAULT NULL,
  `shipping_address_id` int(11) DEFAULT NULL,
  `billing_address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `FK_Customer_Order` (`CustomerID`),
  KEY `FK_Payment_Method_Order` (`payment_method_id`),
  KEY `FK_Shipping_Address_Order` (`shipping_address_id`),
  KEY `FK_Billing_Address_Order` (`billing_address_id`),
  CONSTRAINT `FK_Billing_Address_Order` FOREIGN KEY (`billing_address_id`) REFERENCES `address` (`AddressID`),
  CONSTRAINT `FK_Customer_Order` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`),
  CONSTRAINT `FK_Payment_Method_Order` FOREIGN KEY (`payment_method_id`) REFERENCES `paymentmethod` (`PaymentMethodID`),
  CONSTRAINT `FK_Shipping_Address_Order` FOREIGN KEY (`shipping_address_id`) REFERENCES `address` (`AddressID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Create orderitem table
CREATE TABLE `orderitem` (
  `order_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `FK_Order_ID` (`order_id`),
  KEY `FK_Product_ID` (`product_id`),
  CONSTRAINT `FK_Order_ID` FOREIGN KEY (`order_id`) REFERENCES `order` (`OrderID`),
  CONSTRAINT `FK_Product_ID` FOREIGN KEY (`product_id`) REFERENCES `product` (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Create inventory table
CREATE TABLE `inventory` (
  `InventoryID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductID` int(11) DEFAULT NULL,
  `SupplierID` int(11) DEFAULT NULL,
  `stock_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`InventoryID`),
  KEY `FK_Product_Inventory` (`ProductID`),
  KEY `FK_Supplier_Inventory` (`SupplierID`),
  CONSTRAINT `FK_Product_Inventory` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `FK_Supplier_Inventory` FOREIGN KEY (`SupplierID`) REFERENCES `supplier` (`SupplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Insert data into category
INSERT INTO `category` (`CategoryID`, `category_name`) VALUES
(1, 'Electronics'),
(2, 'Clothing'),
(3, 'Books'),
(4, 'Home Appliances');

-- Insert data into customer
INSERT INTO `customer` (`first_name`, `last_name`, `email`, `phone_number`) VALUES
('John', 'Doe', 'john.doe@example.com', '123-456-7890'),
('Jane', 'Smith', 'jane.smith@example.com', '234-567-8901'),
('Alice', 'Johnson', 'alice.johnson@example.com', '345-678-9012'),
('Bob', 'Brown', 'bob.brown@example.com', '456-789-0123');

-- Insert data into supplier
INSERT INTO `supplier` (`SupplierID`, `supplier_name`, `contact_email`, `contact_phone`) VALUES
(1, 'Tech Supplies Inc.', 'info@techsupplies.com', '123-456-7890'),
(2, 'Fashion Wholesale', 'contact@fashionwholesale.com', '234-567-8901'),
(3, 'Book Distributors', 'support@bookdistributors.com', '345-678-9012'),
(4, 'Kitchen Equipment Co.', 'sales@kitchenequipco.com', '456-789-0123');

-- Insert data into product
INSERT INTO `product` (`ProductID`, `CategoryID`, `name`, `description`, `price`, `image_URL`) VALUES
(1, 1, 'Smartphone', 'A high-end smartphone with a powerful processor and camera.', 699.99, 'smartphone.jpg'),
(2, 2, 'T-Shirt', 'A comfortable and stylish cotton t-shirt.', 19.99, 'tshirt.jpg'),
(3, 3, 'Fiction Novel', 'A bestselling fiction novel with a gripping storyline.', 14.99, 'novel.jpg'),
(4, 4, 'Microwave Oven', 'A high-efficiency microwave oven with multiple presets.', 89.99, 'microwave.jpg');

-- Insert data into address
INSERT INTO `address` (`CustomerID`, `street`, `city`, `state`, `zip_code`, `country`) VALUES
(1, '123 Main St', 'Anytown', 'Anystate', '12345', 'USA'),
(2, '456 Elm St', 'Othertown', 'Otherstate', '67890', 'USA'),
(3, '789 Maple Ave', 'Sample City', 'Sample State', '54321', 'Canada');

-- Insert data into order
INSERT INTO `order` (`OrderID`, `CustomerID`, `order_date`, `status`, `total_amount`, `payment_method_id`, `shipping_address_id
