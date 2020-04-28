SELECT * FROM feedback.event;

SELECT * FROM feedback.user;

SELECT * FROM feedback.user_event;

SELECT * FROM feedback.event_summary;

SELECT * FROM feedback.feedback;

SELECT * FROM feedback.feedback_type;

SELECT * FROM feedback.feedback_answer;

SELECT * FROM feedback.feedback_preanswer;

select count(*) from feedback.feedback_preanswer where feedback_id = 21;

select *  from feedback as f left outer join feedback_preanswer as fp on f.feedback_id = fp.feedback_answer;

SELECT feedback_id, COUNT(*) FROM feedback_preanswer GROUP BY feedback_id;

select f.feedback_id,feedback_question as question,COUNT(*),feedback_type from feedback as f left outer join feedback_preanswer as fp on f.feedback_id = fp.feedback_id group by f.feedback_id;

select *from user_event where event_id=2;
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `email`, `contact_number`, `role`) VALUES ('1', 'user', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'user@gmail.com', '9003283103', 'USER');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `email`, `contact_number`, `role`) VALUES ('2', 'admin', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'admin@gmail.com', '9940593851', 'ADMIN');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `role`) VALUES ('111110', 'jake', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'USER');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `role`) VALUES ('111111', 'anna', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'EVENT');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `role`) VALUES ('111112', 'blake', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'USER');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `role`) VALUES ('111113', 'cooper', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'USER');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `role`) VALUES ('111114', 'dane', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'USER');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `role`) VALUES ('111115', 'ellen', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'USER');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `role`) VALUES ('111116', 'fanny', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'USER');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `role`) VALUES ('111117', 'geet', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'USER');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `role`) VALUES ('111118', 'harry', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'USER');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `role`) VALUES ('111119', 'ian', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'USER');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `role`) VALUES ('111121', 'Kate', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'POC');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `role`) VALUES ('111122', 'Winslet', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'POC');
INSERT INTO `feedback`.`user` (`user_id`, `user_name`, `password`, `email`, `contact_number`, `role`, `business_unit`) VALUES ('802509', 'subi', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK', 'user@gmail.com', '9003283103', 'employee', 'cde');


INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('1', 'EVM2', 'jan', 'chennai', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('2', '213', 'jan', 'chennai', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('3', '42144', 'jan', 'balore', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('4', 'EVM2135649', 'jan', 'chennai', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('5', 'EVM2149', 'jan', 'United kingdom', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('6', 'EVM213524649', 'jan', 'chennai', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('7', 'EVM2135214649', 'jan', 'chennai', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('8', 'EVM2135214649', 'jan', 'chennai', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('9', 'try', 'jan', 'chennai', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('10', 'try2', 'jan', 'chennai', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('11', 'try3', 'jan', 'chennai', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('12', 'try24', 'jan', 'chennai', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('13', 'try35', 'jan', 'chennai', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('14', 'try136', 'jan', 'chennai', 'yourplace', '22', 'anna nagar', 'help', 'education', 'help_edu', 'education');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('15', '44356', 'feb', 'Singapore', 'KWONG WAI SHIU HOSPITAL', 'ppfoa', 'Outreach Singapore', 'cde', 'Insightful_Corridor_005', 'Bags of Joy Distribution', 'Thank you for all your donations of food items to make this a good Xmas for everyone! Come be a Santa and distribute these Bags of Joy to elderly low income residents in Central Singapore and feel the joy of giving!Friends and family welcome');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('16', '234', 'feb', 'Singapore', 'KWONG WAI SHIU HOSPITAL', 'ppfoa', 'Outreach Singapore', 'cde', 'Insightful_Corridor_005', 'Bags of Joy Distribution', 'Thank you for all your donations of food items to make this a good Xmas for everyone! Come be a Santa and distribute these Bags of Joy to elderly low income residents in Central Singapore and feel the joy of giving!Friends and family welcome');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('17', '214322', 'feb', 'Singapore', 'KWONG WAI SHIU HOSPITAL', 'ppfoa', 'Outreach Singapore', 'cde', 'Insightful_Corridor_005', 'Bags of Joy Distribution', 'Thank you for all your donations of food items to make this a good Xmas for everyone! Come be a Santa and distribute these Bags of Joy to elderly low income residents in Central Singapore and feel the joy of giving!Friends and family welcome');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('18', '214323', 'feb', 'Singapore', 'KWONG WAI SHIU HOSPITAL', 'ppfoa', 'Outreach Singapore', 'cde', 'Insightful_Corridor_005', 'Bags of Joy Distribution', 'Thank you for all your donations of food items to make this a good Xmas for everyone! Come be a Santa and distribute these Bags of Joy to elderly low income residents in Central Singapore and feel the joy of giving!Friends and family welcome');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('19', '214325', 'feb', 'Chennai', 'Panchayat Union Primary School, Amman Nagar', 'ppfoa', 'Chennai RCG Outreach', 'cde', 'Insightful Classroom', 'Be a Teacher', 'Central Singapore and feel the joy of giving!');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('20', 'try214326', 'feb', 'Chennai', 'Panchayat Union Primary School, Amman Nagar', 'ppfoa', 'Chennai RCG Outreach', 'cde', 'Insightful Classroom', 'Be a Teacher', 'Central Singapore and feel the joy of giving!');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('21', 'EVM32', 'feb', 'Singapore', 'KWONG WAI SHIU HOSPITAL', 'ppfoa', 'Outreach Singapore', 'cde', 'Insightful_Corridor_005', 'Bags of Joy Distribution', 'Thank you for all your donations of food items to make this a good Xmas for everyone! Come be a Santa and distribute these Bags of Joy to elderly low income residents in Central Singapore and feel the joy of giving!Friends and family welcome');
INSERT INTO `feedback`.`event` (`event_id`, `event_no`, `month`, `location`, `beneficiary_name`, `address`, `council_name`, `project`, `category`, `event_name`, `event_description`) VALUES ('22', 'EVM33', 'feb', 'Chennai', 'Panchayat Union Primary School, Amman Nagar', 'ppfoa', 'Chennai RCG Outreach', 'cde', 'Insightful Classroom', 'Be a Teacher', 'Central Singapore and feel the joy of giving!');


INSERT INTO `feedback`.`event_summary` (`summary_id`, `total_volunteer`, `no_of_hrs`, `travel_hrs`, `lives_impact`, `avg_volunteer`, `event_id`) VALUES ('1', '50', '9', '2', '20', '29', '1');
INSERT INTO `feedback`.`event_summary` (`summary_id`, `total_volunteer`, `no_of_hrs`, `travel_hrs`, `lives_impact`, `avg_volunteer`, `event_id`) VALUES ('2', '39', '239', '23', '21', '22', '4');


INSERT INTO `feedback`.`feedback_type` (`feedback_type_id`, `feedback_name`) VALUES ('1', 'P');
INSERT INTO `feedback`.`feedback_type` (`feedback_type_id`, `feedback_name`) VALUES ('2', 'NP');
INSERT INTO `feedback`.`feedback_type` (`feedback_type_id`, `feedback_name`) VALUES ('3', 'UR');


INSERT INTO `feedback`.`feedback` (`feedback_id`, `feedback_type`, `feedback_answer_type`, `feedback_question`) VALUES ('1', '1', '1', 'How was event?');
INSERT INTO `feedback`.`feedback` (`feedback_id`, `feedback_type`, `feedback_answer_type`, `feedback_question`) VALUES ('2', '2', '2', 'Satisfied with event?');
INSERT INTO `feedback`.`feedback` (`feedback_id`, `feedback_type`, `feedback_answer_type`, `feedback_question`) VALUES ('3', '3', '3', 'Why did you  unregister?');
INSERT INTO `feedback`.`feedback` (`feedback_id`, `feedback_type`, `feedback_answer_type`, `feedback_question`) VALUES ('4', '1', '1', 'Was it worth your time?');

INSERT INTO `feedback`.`feedback_answer` (`feedback_answer_id`, `feedback_id`, `feedback_answer`, `user_id`) VALUES ('1', '1', 'GREAT', '111110');
INSERT INTO `feedback`.`feedback_answer` (`feedback_answer_id`, `feedback_id`, `feedback_answer`, `user_id`) VALUES ('2', '2', 'awesome', '111111');
INSERT INTO `feedback`.`feedback_answer` (`feedback_answer_id`, `feedback_id`, `feedback_answer`, `user_id`) VALUES ('3', '3', 'busy', '111112');


INSERT INTO `feedback`.`user_event` (`event_us_id`, `user_user_id`, `particpation`, `volunteer_hr`, `travel_hr`, `event_id`) VALUES ('1', '111121', 'Y', '1', '1', '1');
INSERT INTO `feedback`.`user_event` (`event_us_id`, `user_user_id`, `particpation`, `volunteer_hr`, `travel_hr`, `event_id`) VALUES ('2', '111122', 'Y', '1', '1', '3');
INSERT INTO `feedback`.`user_event` (`event_us_id`, `user_user_id`, `particpation`, `volunteer_hr`, `travel_hr`, `event_id`) VALUES ('3', '111121', 'Y', '1', '1', '2');

ALTER TABLE `feedback`.`user_event` DROP FOREIGN KEY `fk_user_has_event_user1` ;
ALTER TABLE `feedback`.`user_event` CHANGE COLUMN `event_us_id` `event_user_id` INT(11) NOT NULL  , CHANGE COLUMN `user_user_id` `user_id` INT(11) NULL DEFAULT NULL  , CHANGE COLUMN `particpation` `particpation` VARCHAR(45) NULL  , 
  ADD CONSTRAINT `fk_user_has_event_user1`
  FOREIGN KEY (`user_id` )
  REFERENCES `feedback`.`user` (`user_id` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `feedback`.`event_summary` CHANGE COLUMN `lives_impact` `lives_impact` INT(11) NULL DEFAULT NULL  ;

ALTER TABLE `feedback`.`feedback_answer` CHANGE COLUMN `feedback_answer_id` `feedback_answer_id` INT(11) NOT NULL AUTO_INCREMENT  ;


select *from event as e inner join user_event as ue on ue.event_id = e.event_id inner join user as u on ue.user_id = u.user_id where u.user_name='Kate';


delete from feedback.feedback_preanswer where feedback_id=19;

INSERT INTO `feedback`.`feedback_preanswer` (`answer_id`, `feedback_answer`, `feedback_id`) VALUES ('1', 'adhakf', '1');
INSERT INTO `feedback`.`feedback_preanswer` (`answer_id`, `feedback_answer`, `feedback_id`) VALUES ('2', 'saasdf', '1');
INSERT INTO `feedback`.`feedback_preanswer` (`answer_id`, `feedback_answer`, `feedback_id`) VALUES ('3', 'ea', '2');
INSERT INTO `feedback`.`feedback_preanswer` (`answer_id`, `feedback_answer`, `feedback_id`) VALUES ('4', 'sadf', '2');

ALTER TABLE `feedback`.`user_event` 
CHANGE COLUMN `particpation` `participation` VARCHAR(45) NULL DEFAULT NULL ;

ALTER TABLE `feedback`.`user_event` 
CHANGE COLUMN `event_user_id` `event_user_id` INT NOT NULL AUTO_INCREMENT ;
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '1');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '2');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '111110');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '111111');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '111112');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '111113');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '111114');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '111115');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '111116');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '111117');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '111118');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '111119');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '111121');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '111122');
UPDATE `feedback`.`user` SET `email` = 'subhikshaguha@gmail.com' WHERE (`user_id` = '802509');

UPDATE `feedback`.`user_event` SET `event_id` = '146' WHERE (`event_user_id` = '3');
UPDATE `feedback`.`feedback` SET `feedback_answer_type` = 'Allow Multiple Answer' WHERE (`feedback_id` = '1');
UPDATE `feedback`.`feedback` SET `feedback_answer_type` = 'Free text Answer' WHERE (`feedback_id` = '2');
UPDATE `feedback`.`feedback` SET `feedback_answer_type` = 'Custom Question' WHERE (`feedback_id` = '3');
UPDATE `feedback`.`feedback` SET `feedback_answer_type` = 'Allow Multiple Answer' WHERE (`feedback_id` = '4');
UPDATE `feedback`.`feedback` SET `feedback_answer_type` = 'Allow Multiple Answer' WHERE (`feedback_id` = '5');
UPDATE `feedback`.`feedback` SET `feedback_answer_type` = 'Allow Multiple Answer' WHERE (`feedback_id` = '6');
UPDATE `feedback`.`feedback` SET `feedback_answer_type` = 'Free text Answer' WHERE (`feedback_id` = '7');
