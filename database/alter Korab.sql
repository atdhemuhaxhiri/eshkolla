ALTER TABLE `eschool`.`chapter`
ADD COLUMN `created_at` DATE NULL AFTER `description`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`,
ADD COLUMN `deleted_at` DATE NULL AFTER `updated_at`,
ADD COLUMN `created_by` VARCHAR(255) NULL AFTER `deleted_at`,
ADD COLUMN `updated_by` VARCHAR(255) NULL AFTER `created_by`,
ADD COLUMN `deleted_by` VARCHAR(255) NULL AFTER `updated_by`;

ALTER TABLE `eschool`.`class_room`
ADD COLUMN `created_at` DATE NULL AFTER `room_number`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`,
ADD COLUMN `deleted_at` DATE NULL AFTER `updated_at`,
ADD COLUMN `created_by` VARCHAR(255) NULL AFTER `deleted_at`,
ADD COLUMN `updated_by` VARCHAR(255) NULL AFTER `created_by`,
ADD COLUMN `deleted_by` VARCHAR(255) NULL AFTER `updated_by`;

ALTER TABLE `eschool`.`grade_book`
ADD COLUMN `created_at` DATE NULL AFTER `grade`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`,
ADD COLUMN `deleted_at` DATE NULL AFTER `updated_at`,
ADD COLUMN `created_by` VARCHAR(255) NULL AFTER `deleted_at`,
ADD COLUMN `updated_by` VARCHAR(255) NULL AFTER `created_by`,
ADD COLUMN `deleted_by` VARCHAR(255) NULL AFTER `updated_by`;

ALTER TABLE `eschool`.`institution`
ADD COLUMN `created_at` DATE NULL AFTER `institution_type_id`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`,
ADD COLUMN `deleted_at` DATE NULL AFTER `updated_at`,
ADD COLUMN `created_by` VARCHAR(255) NULL AFTER `deleted_at`,
ADD COLUMN `updated_by` VARCHAR(255) NULL AFTER `created_by`,
ADD COLUMN `deleted_by` VARCHAR(255) NULL AFTER `updated_by`;

ALTER TABLE `eschool`.`institution_type`
ADD COLUMN `created_at` DATE NULL AFTER `department`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`,
ADD COLUMN `deleted_at` DATE NULL AFTER `updated_at`,
ADD COLUMN `created_by` VARCHAR(255) NULL AFTER `deleted_at`,
ADD COLUMN `updated_by` VARCHAR(255) NULL AFTER `created_by`,
ADD COLUMN `deleted_by` VARCHAR(255) NULL AFTER `updated_by`;

ALTER TABLE `eschool`.`lesson_unit`
ADD COLUMN `created_at` DATE NULL AFTER `chapter_id`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`,
ADD COLUMN `deleted_at` DATE NULL AFTER `updated_at`,
ADD COLUMN `created_by` VARCHAR(255) NULL AFTER `deleted_at`,
ADD COLUMN `updated_by` VARCHAR(255) NULL AFTER `created_by`,
ADD COLUMN `deleted_by` VARCHAR(255) NULL AFTER `updated_by`;

ALTER TABLE `eschool`.`proffesore`
ADD COLUMN `created_at` DATE NULL AFTER `proffesore_type_id`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`,
ADD COLUMN `deleted_at` DATE NULL AFTER `updated_at`,
ADD COLUMN `created_by` VARCHAR(255) NULL AFTER `deleted_at`,
ADD COLUMN `updated_by` VARCHAR(255) NULL AFTER `created_by`,
ADD COLUMN `deleted_by` VARCHAR(255) NULL AFTER `updated_by`;

ALTER TABLE `eschool`.`proffesore_type`
ADD COLUMN `created_at` DATE NULL AFTER `description`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`,
ADD COLUMN `deleted_at` DATE NULL AFTER `updated_at`,
ADD COLUMN `created_by` VARCHAR(255) NULL AFTER `deleted_at`,
ADD COLUMN `updated_by` VARCHAR(255) NULL AFTER `created_by`,
ADD COLUMN `deleted_by` VARCHAR(255) NULL AFTER `updated_by`;

ALTER TABLE `eschool`.`subject`
ADD COLUMN `created_at` DATE NULL AFTER `syllabus_id`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`,
ADD COLUMN `deleted_at` DATE NULL AFTER `updated_at`,
ADD COLUMN `created_by` VARCHAR(255) NULL AFTER `deleted_at`,
ADD COLUMN `updated_by` VARCHAR(255) NULL AFTER `created_by`,
ADD COLUMN `deleted_by` VARCHAR(255) NULL AFTER `updated_by`;

ALTER TABLE `eschool`.`syllabus`
ADD COLUMN `created_at` DATE NULL AFTER `institution_id`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`,
ADD COLUMN `deleted_at` DATE NULL AFTER `updated_at`,
ADD COLUMN `created_by` VARCHAR(255) NULL AFTER `deleted_at`,
ADD COLUMN `updated_by` VARCHAR(255) NULL AFTER `created_by`,
ADD COLUMN `deleted_by` VARCHAR(255) NULL AFTER `updated_by`;

ALTER TABLE `eschool`.`user_type`
ADD COLUMN `created_at` DATE NULL AFTER `description`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`,
ADD COLUMN `deleted_at` DATE NULL AFTER `updated_at`,
ADD COLUMN `created_by` VARCHAR(255) NULL AFTER `deleted_at`,
ADD COLUMN `updated_by` VARCHAR(255) NULL AFTER `created_by`,
ADD COLUMN `deleted_by` VARCHAR(255) NULL AFTER `updated_by`;

ALTER TABLE `eschool`.`users`
ADD COLUMN `created_at` DATE NULL AFTER `mob`,
ADD COLUMN `updated_at` DATE NULL AFTER `created_at`,
ADD COLUMN `deleted_at` DATE NULL AFTER `updated_at`,
ADD COLUMN `created_by` VARCHAR(255) NULL AFTER `deleted_at`,
ADD COLUMN `updated_by` VARCHAR(255) NULL AFTER `created_by`,
ADD COLUMN `deleted_by` VARCHAR(255) NULL AFTER `updated_by`;
