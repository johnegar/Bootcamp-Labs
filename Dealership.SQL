CREATE TABLE Vehicles(
VehicleID INT auto_increment,
VIN VARCHAR(25),
AGE INT Not Null,
MAKE VARCHAR(10),
MODEL VARCHAR(15),
VehicleType VARCHAR(20),
Color VARCHAR(10),
Odometer INT Not Null, 
Price INT Not Null,
PRIMARY KEY(VehicleID),
SOLD BOOl);


CREATE TABLE Dealership(
DealershipID INT AUTO_INCREMENT,
PRIMARY KEY (DealershipID),
DealershipName VARCHAR(20),
Address VARCHAR(20),
Phone INT NOT NUll);

CREATE TABLE Inventory(
DealershipID INT,
VIN VARCHAR(25),
PRIMARY KEY (DealershipID, VIN),
FOREIGN KEY (DealershipID) REFERENCES Dealership(DealershipID),
FOREIGN KEY (VIN) REFERENCES Vehicles(VIN));

CREATE TABLE SalesContract(
ContractID INT AUTO_INCREMENT,
    DealershipID INT,
    VIN VARCHAR(25),
    CustomerID INT,
    SaleDate DATE,
    PRIMARY KEY (ContractID),
    FOREIGN KEY (DealershipID, VIN) REFERENCES Inventory(DealershipID, VIN));


















