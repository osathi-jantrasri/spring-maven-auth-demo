

--BCryptPasswordEncoder
--Go to a site like https://www.bcryptcalculator.com/.
--Enter plaintext password (e.g., admin123). 
--It will generate a BCrypt hash for you.

----------------------------------------------------------------------------------

-- Insert Users
INSERT INTO app_user (username, password, role) VALUES 
('admin', '$2a$10$XEoLB734qkzKRyfMbxWsruGO5NYe4STKBkaPkgWh7BfNKRsmMnWOy', 'ADMIN'),
('director', '$2a$10$OBnUPvvNtNiNDYtTc0X2SOByvy2zuFc45QhBzBtpgtDPqpIkYVNi2', 'DIRECTOR'),
('employee', '$2a$10$UYY4km2iGpx1QLE9ATDE1OVFCkZjJVhZ16MKfuBEEl9hI6X5jdi8y', 'EMPLOYEE');

-- Insert Documents
INSERT INTO document (title, content) VALUES 
('Doc1-public', 'Everyone can see - no need to login'),
('Doc2-admin', 'Admin only'),
('Doc3-director', 'director only'),
('Doc4-employee', 'employee only'),
('Doc5-admin-director-employee', 'everyone in company can see');

INSERT INTO document_allowed_roles (document_id, allowed_role) VALUES 
(1, 'GUEST'),
(2, 'ADMIN'),
(3, 'DIRECTOR'),
(4, 'EMPLOYEE'),
(5, 'EMPLOYEE'),
(5, 'DIRECTOR'),
(5, 'ADMIN');