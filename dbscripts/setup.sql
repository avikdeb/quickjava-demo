CREATE SCHEMA `quickjava` ;
CREATE TABLE `quickjava`.`emp` (
  `idemp` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idemp`),
  UNIQUE INDEX `idemp_UNIQUE` (`idemp` ASC) VISIBLE);
