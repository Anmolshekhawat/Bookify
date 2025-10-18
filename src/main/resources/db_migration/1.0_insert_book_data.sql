
CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    total_quantity INT NOT NULL,
     assigned_quantity INT DEFAULT 0,
)

INSERT INTO books (title, author, category, total_quantity, assigned_quantity) VALUES
('Clean Code', 'Robert C. Martin', 'Programming', 10, 2),
('Introduction to Algorithms', 'Thomas H. Cormen', 'Algorithms', 8, 3),
('The Pragmatic Programmer', 'Andrew Hunt', 'Software Engineering', 12, 5),
('Data Structures and Algorithms in Java', 'Michael T. Goodrich', 'Programming', 9, 1),
('Operating System Concepts', 'Abraham Silberschatz', 'Operating Systems', 7, 2),
('Computer Networks', 'Andrew S. Tanenbaum', 'Networking', 6, 1),
('Database System Concepts', 'Henry F. Korth', 'Database', 10, 4),
('Artificial Intelligence: A Modern Approach', 'Stuart Russell', 'AI', 5, 1),
('Design Patterns: Elements of Reusable Object-Oriented Software', 'Erich Gamma', 'Software Design', 6, 2),
('Modern Digital Electronics', 'R.P. Jain', 'Electronics', 15, 5),
('The C Programming Language', 'Brian W. Kernighan', 'Programming', 8, 3),
('Introduction to Machine Learning', 'Ethem Alpaydin', 'Machine Learning', 6, 1),
('Python Crash Course', 'Eric Matthes', 'Programming', 10, 2),
('Deep Learning with Python', 'François Chollet', 'AI', 7, 3),
('Let Us C', 'Yashavant Kanetkar', 'Programming', 20, 5);

SELECT * FROM books;
