CREATE TABLE "section_f" (
  "id" int PRIMARY KEY
);

CREATE TABLE "base_maintenance" (
  "id" int PRIMARY KEY
);

CREATE TABLE "base_issues" (
  "id" int PRIMARY KEY,
  "issues" varchar
);

CREATE TABLE "station" (
  "stn_name_id" int PRIMARY KEY,
  "name" varchar,
  "base_maintenance_id" int
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

ALTER TABLE "station" ADD FOREIGN KEY ("base_maintenance_id") REFERENCES "base_maintenance" ("id");

ALTER TABLE "base_issues" ADD FOREIGN KEY ("id") REFERENCES "base_maintenance" ("id");

ALTER TABLE "section_f" ADD FOREIGN KEY ("id") REFERENCES "base_maintenance" ("id");

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_f_id") REFERENCES "section_f" ("id");
