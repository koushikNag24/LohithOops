CREATE TABLE "section_a" (
  "id" int,
  PRIMARY KEY ("id")
);

CREATE TABLE "communications_issue" (
  "communication_id" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "section_a_id" int
);

CREATE TABLE "link_status" (
  "id" int PRIMARY KEY,
  "communication_id" int
);

CREATE TABLE "base_health" (
  "id" int,
  "issue" varchar,
  "name" varchar,
  "status" varchar
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

ALTER TABLE "section_a" ADD FOREIGN KEY ("id") REFERENCES "communications_issue" ("section_a_id");

ALTER TABLE "link_status" ADD FOREIGN KEY ("communication_id") REFERENCES "communications_issue" ("communication_id");

ALTER TABLE "base_health" ADD FOREIGN KEY ("id") REFERENCES "link_status" ("id");

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_a_id") REFERENCES "section_a" ("id");
