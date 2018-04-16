DROP TABLE IF EXISTS lines;

CREATE TABLE IF NOT EXISTS lines (
id INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(255) NOT NULL,
longest_word INT NOT NULL,
shortest_word INT NOT NULL,
line_length INT NOT NULL,
average_word_length INT NOT NULL
);