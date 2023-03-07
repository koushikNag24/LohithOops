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

CREATE TABLE "section_a" (
  "section_a_id" int
);

CREATE TABLE "section_b" (
  "section_b_id" int
);

CREATE TABLE "section_c" (
  "section_c_id" int
);

CREATE TABLE "section_d" (
  "section_d_id" int
);

CREATE TABLE "section_e" (
  "section_e_id" int
);

CREATE TABLE "section_f" (
  "section_f_id" int
);

CREATE TABLE "section_g" (
  "section_g_id" int
);

CREATE TABLE "section_h" (
  "section_h_id" int
);

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_a_id") REFERENCES "section_a" ("section_a_id");

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_b_id") REFERENCES "section_b" ("section_b_id");

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_c_id") REFERENCES "section_c" ("section_c_id");

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_d_id") REFERENCES "section_d" ("section_d_id");

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_e_id") REFERENCES "section_e" ("section_e_id");

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_f_id") REFERENCES "section_f" ("section_f_id");

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_g_id") REFERENCES "section_g" ("section_g_id");

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_h_id") REFERENCES "section_h" ("section_h_id");
