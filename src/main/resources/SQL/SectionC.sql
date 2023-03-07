CREATE TABLE "section_c" (
  "id" int,
  PRIMARY KEY ("id")
);

CREATE TABLE "parallel_chain" (
  "id" int PRIMARY KEY,
  "section_c_id" int
);

CREATE TABLE "base_health" (
  "id" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "issue" varchar,
  "name" varchar,
  "status" varchar
);

CREATE TABLE "irnwt" (
  "id" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "section_c_id" int
);

CREATE TABLE "twstft_offset" (
  "base_valueid" int PRIMARY KEY,
  "section_c_id" int
);

CREATE TABLE "gnss_offset" (
  "base_valueid" int PRIMARY KEY,
  "section_c_id" int
);

CREATE TABLE "base_value" (
  "base_valueid" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "name" varchar,
  "value" int
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

ALTER TABLE "parallel_chain" ADD FOREIGN KEY ("section_c_id") REFERENCES "section_c" ("id");

ALTER TABLE "base_health" ADD FOREIGN KEY ("id") REFERENCES "parallel_chain" ("id");

ALTER TABLE "irnwt" ADD FOREIGN KEY ("id") REFERENCES "base_health" ("id");

ALTER TABLE "irnwt" ADD FOREIGN KEY ("section_c_id") REFERENCES "section_c" ("id");

ALTER TABLE "twstft_offset" ADD FOREIGN KEY ("base_valueid") REFERENCES "base_value" ("base_valueid");

ALTER TABLE "twstft_offset" ADD FOREIGN KEY ("section_c_id") REFERENCES "section_c" ("id");

ALTER TABLE "gnss_offset" ADD FOREIGN KEY ("base_valueid") REFERENCES "base_value" ("base_valueid");

ALTER TABLE "gnss_offset" ADD FOREIGN KEY ("section_c_id") REFERENCES "section_c" ("id");

ALTER TABLE "navic_performance_details" ADD FOREIGN KEY ("section_c_id") REFERENCES "section_c" ("id");