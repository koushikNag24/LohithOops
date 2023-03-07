CREATE TABLE "section_d" (
  "id" int PRIMARY KEY
);

CREATE TABLE "schemacs_health" (
  "id" int PRIMARY KEY,
  "section_d_id" int
);

CREATE TABLE "base_health" (
  "id" int PRIMARY KEY,
  "issues" varchar,
  "name" varchar,
  "status" varchar
);

CREATE TABLE "base_issues" (
  "id" int PRIMARY KEY,
  "issues" varchar
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

ALTER TABLE "schemacs_health" ADD FOREIGN KEY ("id") REFERENCES "base_health" ("id");

ALTER TABLE "schemacs_health" ADD FOREIGN KEY ("section_d_id") REFERENCES "section_d" ("id");

ALTER TABLE "section_d" ADD FOREIGN KEY ("id") REFERENCES "base_issues" ("id");

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_d_id") REFERENCES "section_d" ("id");
