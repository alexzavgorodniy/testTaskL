DROP TABLE IF EXISTS lines;

CREATE TABLE IF NOT EXISTS lines (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  longest_word INT,
  shortest_word INT,
  line_length INT,
  average_word_length INT
);