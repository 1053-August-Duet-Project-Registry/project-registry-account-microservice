-- insert roles
insert into role (type) values ('admin');
insert into role (type) values ('user');
-- insert accounts
insert into account(username, role_id) values('william', 1);
insert into account(username, role_id) values('kenny', 1);
insert into account(username, role_id) values('william', 1);
insert into account(username, role_id) values('Bob', 2);
-- insert statuses
insert into status(name) values ('IN_ITERATION');
insert into status(name) values ('CODE_FREEZE');
insert into status(name) values ('CODE_REVIEW');
insert into status(name) values ('NEEDS_CLEANUP');
insert into status(name) values ('READY_FOR_ITERATION');
insert into status(name) values ('ACTIVE');
insert into status(name) values ('NEEDS_ATTENTION');
insert into status(name) values ('ARCHIVED');
insert into status(name) values ('PLANNED');
insert into status(name) values ('AVAILABLE');
-- insert phase
insert into phase (kind, description) values ('BACKLOG_GENERATED', 'CoE has completed the iterations backlog, awaiting trainer approval');
insert into phase (kind, description) values ('TRAINER_APPROVED', 'Trainer has reviewed backlog and approves of scope and domain');
insert into phase (kind, description) values ('HANDOFF_SCHEDULED', 'Scheduled the Handoff meeting to introduce P3');
insert into phase (kind, description) values ('RESOURCE_ALLOCATION', 'Cloud Resources, access to Kanban boards and GH Organization and Repositories');
insert into phase (kind, description) values ('CHECKPOINT_MEETING', 'Progress meeting at halfway point finished');
insert into phase (kind, description) values ('CODE_REVIEW', 'Code Review of work completed in Iteration has commenced');
insert into phase (kind, description) values ('COMPLETE', 'Iteration has completed, ready to merge into upstream');
-- insert tags
insert into tag (name, description) values ('Angular', 'This project used an Angular Frontend');
insert into tag (name, description) values ('React', 'This project used a React Frontend');
insert into tag (name, description) values ('JDBC', 'Uses JDBC to connect to the DB');
insert into tag (name, description) values ('AWS RDS', 'This project used AWS RDS for the database');
insert into tag (name, description) values ('REST', 'This project is a RESTful service');
insert into tag (name, description) values ('SpringMVC', 'This project used MVC for servlets');
insert into tag (name, description) values ('SPRING ORM', 'This project used Spring ORM for tables');
insert into tag (name, description) values ('GIT', 'This project used a GIT REPO');
-- insert projects
insert into project(description, name, owner, status, phase) values('rideforce project', 'rideforce', 3, 3, 2);
insert into project(description, name, owner, status, phase) values('Finds potential condadites by scrapping facebook.', 'Make A Recruiting Application', 1, 2, 3);
insert into project(description, name, owner, status, phase) values('Allows for staging to be remote', 'Caliber Staging Module', 4, 3, 2);
-- insert organizations
insert into organization(name, project_id) values ('test organziation', 1);