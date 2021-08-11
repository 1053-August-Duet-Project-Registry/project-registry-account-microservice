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
insert into status(name) values ('AVAILABLE');
insert into status(name) values ('PLANNED');

-- insert phase
insert into phase (kind, description) values ('BACKLOG_GENERATED', 'CoE has completed the iterations backlog, awaiting trainer approval');
insert into phase (kind, description) values ('TRAINER_APPROVED', 'Trainer has reviewed backlog and approves of scope and domain');
insert into phase (kind, description) values ('HANDOFF_SCHEDULED', 'Scheduled the Handoff meeting to introduce P3');
insert into phase (kind, description) values ('RESOURCE_ALLOCATION', 'Cloud Resources, access to Kanban boards and GH Organization and Repositories');
insert into phase (kind, description) values ('CHECKPOINT_MEETING', 'Progress meeting at halfway point finished');
insert into phase (kind, description) values ('CODE_REVIEW', 'Code Review of work completed in Iteration has commenced');
insert into phase (kind, description) values ('COMPLETE', 'Iteration has completed, ready to merge into upstream');
-- insert tags
insert into tag (name, description, is_enabled) values ('Angular', 'This project used an Angular Frontend', 1);
insert into tag (name, description, is_enabled) values ('React', 'This project used a React Frontend',1);
insert into tag (name, description, is_enabled) values ('JDBC', 'Uses JDBC to connect to the DB',1);
insert into tag (name, description, is_enabled) values ('AWS RDS', 'This project used AWS RDS for the database',1);
insert into tag (name, description, is_enabled) values ('REST', 'This project is a RESTful service',1);
insert into tag (name, description, is_enabled) values ('SpringMVC', 'This project used MVC for servlets',1);
insert into tag (name, description, is_enabled) values ('SPRING ORM', 'This project used Spring ORM for tables',1);
insert into tag (name, description, is_enabled) values ('GIT', 'This project used a GIT REPO',1);
-- insert projects
insert into project(description, name, owner, status) values('rideforce project', 'rideforce', 3, 3);
insert into project(description, name, owner, status) values('Finds potential condadites by scrapping facebook.', 'Make A Recruiting Application', 1, 2);
insert into project(description, name, owner, status) values('Allows for staging to be remote', 'Caliber Staging Module', 4, 3);
-- insert tags to projects
insert into project_tags_jt(project_id, tag_id) values(1, 1);
insert into project_tags_jt(project_id, tag_id) values(1, 2);
insert into project_tags_jt(project_id, tag_id) values(1, 3);
-- insert iterations
insert into iteration (start_date, end_date, batch_id, project_id, phase) values ('2021-08-09', '2021-09-13','TR-1201',1, 2);
insert into iteration (start_date, end_date, batch_id, project_id, phase) values ('2021-08-10', '2021-09-15','TR-1072',1, 3);
insert into iteration (start_date, end_date, batch_id, project_id, phase) values ('2021-08-11', '2021-09-16','TR-1140',2, 4);
insert into iteration (start_date, end_date, batch_id, project_id, phase) values ('2021-08-12', '2021-09-17','TR-1021',2, 1);
insert into iteration (start_date, end_date, batch_id, project_id, phase) values ('2021-08-12', '2021-09-17','TR-1067',2, 1);
-- insert organizations
insert into organization(name, project_id) values ('test organziation', 1);
-- insert repositories
insert into repository(name, url, organization_id) values ('repo_01', 'https://github.com/repo_01', 1);
insert into repository(name, url, organization_id) values ('repo_02', 'https://github.com/repo_02', 1);
