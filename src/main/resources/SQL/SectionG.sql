CREATE TABLE "section_g" (
  "id" int PRIMARY KEY
);

CREATE TABLE "syslog_status" (
  "id" int PRIMARY KEY,
  "section_g_id" int
);

CREATE TABLE "base_health" (
  "id" int PRIMARY KEY,
  "issue" varchar,
  "name" varchar,
  "status" varchar
);

CREATE TABLE "standard_file_status" (
  "id" int PRIMARY KEY,
  "section_g_id" int
);

CREATE TABLE "standard_file" (
  "standard_file_id" int PRIMARY KEY,
  "file_name" varchar,
  "standard_file_status_id" int
);

CREATE TABLE "navic_performance_details" (
  "id" int PRIMARY KEY,
  "created_at" timestamp,
  "modified_at" timestamp,
  "section_a_id" int,
  "section_b_id" int,
  "section_c_id" int,
  "section_d_id" int,
  "section_e_id" int,
  "section_f_id" int,
  "section_g_id" int,
  "section_h_id" int
);

ALTER TABLE "syslog_status" ADD FOREIGN KEY ("section_g_id") REFERENCES "section_g" ("id");

ALTER TABLE "syslog_status" ADD FOREIGN KEY ("id") REFERENCES "base_health" ("id");

ALTER TABLE "standard_file_status" ADD FOREIGN KEY ("section_g_id") REFERENCES "section_g" ("id");

ALTER TABLE "standard_file" ADD FOREIGN KEY ("standard_file_status_id") REFERENCES "standard_file_status" ("id");

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_g_id") REFERENCES "section_g" ("id");
