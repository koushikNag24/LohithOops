CREATE TABLE "section_h" (
  "id" int PRIMARY KEY
);

CREATE TABLE "stn_look_angle" (
  "stn_look_angle_id" int PRIMARY KEY,
  "available_till" timestamp,
  "location" varchar,
  "base_issue_id" int
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

ALTER TABLE "stn_look_angle" ADD FOREIGN KEY ("stn_look_angle_id") REFERENCES "section_h" ("id");

ALTER TABLE "section_h" ADD FOREIGN KEY ("id") REFERENCES "base_issues" ("id");

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_h_id") REFERENCES "section_h" ("id");
