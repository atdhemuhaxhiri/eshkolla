CREATE SCHEMA `eschool` ;

USE `eschool`;

CREATE TABLE `institution_type` (
  `id` char(36) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `institution` (
  `id` char(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mob` varchar(45) DEFAULT NULL,
  `website` varchar(45) DEFAULT NULL,
  `institution_type_id` char(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_institution_type_1_idx` (`institution_type_id`),
  CONSTRAINT `fk_institution_type_1` FOREIGN KEY (`institution_type_id`) REFERENCES `institution_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `user_type` (
  `id` char(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `users` (
  `id` char(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` enum('M','F') DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `user_type_id` char(36) DEFAULT NULL,
  `mob` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_type_idx` (`user_type_id`),
  CONSTRAINT `fk_user_type` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `institution_student` (
  `user_id` char(36) NOT NULL,
  `institution_id` char(36) NOT NULL,
  PRIMARY KEY (`user_id`,`institution_id`),
  KEY `fk_institution_user_2_idx` (`institution_id`),
  CONSTRAINT `fk_institution_user_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_institution_user_2` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `proffesore_type` (
  `id` char(36) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `syllabus` (
  `id` char(36) NOT NULL,
  `literature` varchar(500) DEFAULT NULL,
  `institution_id` char(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_syllabus_institution_1_idx` (`institution_id`),
  CONSTRAINT `fk_syllabus_institution_1` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `subject` (
  `id` char(36) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `institution_id` char(36) DEFAULT NULL,
  `syllabus_id` char(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_subject_institution_1_idx` (`institution_id`),
  KEY `fk_subject_syllabus_1_idx` (`syllabus_id`),
  CONSTRAINT `fk_subject_institution_1` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_subject_syllabus_1` FOREIGN KEY (`syllabus_id`) REFERENCES `syllabus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `proffesore` (
  `id` char(36) NOT NULL,
  `user_id` char(36) DEFAULT NULL,
  `subject_id` char(36) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `proffesore_type_id` char(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_proffesor_user_1_idx` (`user_id`),
  KEY `fk_proffesor_subject_1_idx` (`subject_id`),
  KEY `fk_proffesor_type_1_idx` (`proffesore_type_id`),
  CONSTRAINT `fk_proffesor_subject_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_proffesor_type_1` FOREIGN KEY (`proffesore_type_id`) REFERENCES `proffesore_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_proffesor_user_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `chapter` (
  `id` char(36) NOT NULL,
  `subject_id` char(36) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_subject_id_1_idx` (`subject_id`),
  CONSTRAINT `fk_subject_id_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `lesson_unit` (
  `id` char(36) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `chapter_id` char(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lesson_unit_chapter_1_idx` (`chapter_id`),
  CONSTRAINT `fk_lesson_unit_chapter_1` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `class_room` (
  `id` char(36) NOT NULL,
  `student_id` char(36) DEFAULT NULL,
  `subject_id` char(36) DEFAULT NULL,
  `proffesore_id` char(36) DEFAULT NULL,
  `assistent_id` char(36) DEFAULT NULL,
  `room_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_student_class_room_1_idx` (`student_id`),
  KEY `fk_subject_class_room_1_idx` (`subject_id`),
  KEY `fk_profesor_class_room_1_idx` (`proffesore_id`),
  KEY `fk_subject_assistent_1_idx` (`assistent_id`),
  CONSTRAINT `fk_profesor_class_room_1` FOREIGN KEY (`proffesore_id`) REFERENCES `proffesore` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_class_room_1` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_subject_assistent_1` FOREIGN KEY (`assistent_id`) REFERENCES `proffesore` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_subject_class_room_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `grade_book` (
  `id` char(36) NOT NULL,
  `student_id` char(36) DEFAULT NULL,
  `proffesore_id` char(36) DEFAULT NULL,
  `subject_id` char(36) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grade_book_student_1_idx` (`student_id`),
  KEY `fk_grade_book_proffesor_1_idx` (`proffesore_id`),
  KEY `fk_grade_book_subject_id_idx` (`subject_id`),
  CONSTRAINT `fk_grade_book_proffesor_1` FOREIGN KEY (`proffesore_id`) REFERENCES `proffesore` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grade_book_student_1` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grade_book_subject_id_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
